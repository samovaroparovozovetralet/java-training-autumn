package org.java.training.autumn.model.notebook;

/**
 * The class NotUniqueLoginException are a form of Exception that indicates if
 * DB already has NoteBook with such login.
 * @see     Exception
 * @see     DBNoteBook
 * @see     NoteBook
 */

public class NotUniqueLoginException extends Exception {
    private String login;

    /**
     * Constructs a new exception with specified detail message and login
     * passed to a DB.
     * @param message - the detail message.
     * @param login   - login we`d try to wrote to DB(which is saved for later
     *                  retrieval by getLogin() method).
     */

    public NotUniqueLoginException(String message, String login){
        super(message);
        this.login = login;
    }

    public String getLogin() {return login;}
}
