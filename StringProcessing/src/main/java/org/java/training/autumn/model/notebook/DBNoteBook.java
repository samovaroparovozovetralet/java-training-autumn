package org.java.training.autumn.model.notebook;

public enum DBNoteBook {
    NOTE_ONE("Oleksandr", "sasha123"),
    NOTE_TWO("Oleksiy", "lesha321");

    private final String firstName;
    private final String login;

    DBNoteBook(String firstName, String login){
        this.firstName = firstName;
        this.login = login;
    }

    private String getFirstName(){
        return firstName;
    }
    private String getLogin(){return login;}

    public static boolean checkLogin(String login){
        for(DBNoteBook note : DBNoteBook.values()){
            if(note.getLogin().equals(login)){return true;}
        }
        return false;
    }

}
