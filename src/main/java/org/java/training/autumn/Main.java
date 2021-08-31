package org.java.training.autumn;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}
