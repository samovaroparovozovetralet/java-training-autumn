package org.java.training.autumn;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private boolean activeState;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        this.activeState = true;
    }

    private void setCustomRange(Scanner sc){
        view.printMessage(View.CUSTOM_RANGE_MIN_MESSAGE);
        while(!sc.hasNextInt()){
            view.printMessage(View.ERR_MESSAGE);
            sc.next();
        }
        int min = sc.nextInt();

        view.printMessage(View.CUSTOM_RANGE_MAX_MESSAGE);
        while(!sc.hasNextInt()){
            view.printMessage(View.ERR_MESSAGE);
            sc.next();
        }
        int max = sc.nextInt();

        model.setRange(min, max);
        if(!model.checkLogic()){
            view.printMessage(View.BAD_INPUT_RANGE_MESSAGE);
            setCustomRange(sc);
        }
    }

    private void executeCommand(Scanner sc){
        String userInput = sc.next();
        switch (userInput){
            case "help":{
                view.printMessage(View.HELP_MESSAGE);
                break;
            }
            case "casual":{
                model.setRange(Model.DEFAULT_MIN, Model.DEFAULT_MAX);
                view.printMessage(View.CASUAL_MESSAGE);
                break;
            }
            case "custom":{
                setCustomRange(sc);
                view.printMessage(View.CUSTOM_MESSAGE);
                break;
            }
            case "end":{
                view.printMessage(View.END_GAME_MESSAGE);
                activeState = false;
                break;
            }

            default:{
                view.printMessage(View.ERR_MESSAGE);
                view.printMessage(View.HELP_MESSAGE);
            }
        }
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        view.displayMenu();
        while(activeState){
            if(sc.hasNextInt()){
                int current = sc.nextInt();
                if(!model.checkInRange(current)){
                    view.printMessage(View.OUT_OF_RANGE_MESSAGE);
                    view.displayRange(model.getMin(), model.getMax());
                }
                else{
                    model.checkEquals(current);
                    view.displayRange(model.getMin(), model.getMax());
                    view.displayStatistic(model.getStatistics());
                }
            }
            else { executeCommand(sc); }
        }
    }
}
