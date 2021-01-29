package kamil.szymoniak.model;

/**
 * Exception to be thrown when there are illegal arguments
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class IllegalConsoleArgumentsException extends Exception{
    /**
     * Constructor for IllegalConsoleArgumentsException
     * 
     * @param s message of the exception
     */
    public IllegalConsoleArgumentsException(String s) { super(s); }   
}
