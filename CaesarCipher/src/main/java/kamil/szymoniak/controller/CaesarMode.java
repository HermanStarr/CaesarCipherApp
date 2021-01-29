package kamil.szymoniak.controller;
import kamil.szymoniak.model.IllegalConsoleArgumentsException;

/**
 * Enumeration type for a mode of operation of given program.
 * Modes to be used
 * {@link #ENCODING}
 * {@link #DECODING}
 * 
 * @author Kamil Szymoniak
 * @version 3.0
 */
public enum CaesarMode {
    /**
     * Encoding mode of operation
     */
    ENCODING,
    /**
     * Decoding mode of operation
     */
    DECODING;
    
    /**
     * Method takes string and returns appropriate enumeration value
     * 
     * @param mode passed string
     * @return either of two values of the enumeration
     * @throws IllegalConsoleArgumentsException if no match was found
     */
    public static CaesarMode getModeFromInput(String mode) throws IllegalConsoleArgumentsException{
        try{
            return valueOf(mode.toUpperCase());
        }
        catch(IllegalArgumentException e){
            throw new IllegalConsoleArgumentsException("Mode should be either 'encoding' or 'decoding'");
        }
    }
}
