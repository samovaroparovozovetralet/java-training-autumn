package org.java.training.autumn.model.notebook;

public class NotUniqueLoginException extends Exception {
    private String login;

    public NotUniqueLoginException(String message, String login){
        super(message);
        this.login = login;
    }

    public String getLogin() {return login;}
}
