package kamil.szymoniak.controller;

import kamil.szymoniak.model.IllegalInputFormException;
import kamil.szymoniak.model.IllegalConsoleArgumentsException;
import kamil.szymoniak.model.CipherModel;

import javax.swing.*;
import java.util.*;

/**
 * Controller class for Caesar cipher
 * 
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class Controller {

    /**
     * Default constructor for Controller class
     */
    public Controller() {
    }
    
    /**
     * Method differentiates between the specified modes of operation
     * 
     * @param input console arguments
     * @param test optional input that deactivates warning messages during a test
     * @return View generated for given task or error
     */
    public String beginTranslation(String[] input, boolean... test){
        boolean isTest = test.length != 0;
        int key;
        List<String> argsCollection = new ArrayList<>(Arrays.asList(input));
        try{
            key = checkInput(argsCollection);
        }
        catch(IllegalConsoleArgumentsException e){
            if(!isTest)
                JOptionPane.showMessageDialog(null, "Invalid input", e.getMessage(), JOptionPane.WARNING_MESSAGE);
            return "";
        }
        return translateControl(argsCollection, key, isTest);
    }
    
    /**
     * Method checks for errors in arguments and mode of operation
     * 
     * @param input console arguments
     * @return key to be applied to the message. If negative, proper countermeasures are implemented
     * @throws IllegalConsoleArgumentsException for errors in console arguments
     */
    private int checkInput(List<String> input) throws IllegalConsoleArgumentsException{
        CaesarMode mode = CaesarMode.getModeFromInput(input.get(0));
        if(input.get(1).matches("([+-]?[1-9]\\d*|0)$")){
            int key = Integer.parseInt(input.get(1));
            return
                    key < 0 ?
                            CaesarMode.ENCODING.equals(mode) ? 26 + key % 26 : - key :
                            CaesarMode.DECODING.equals(mode) ? 26 - key % 26 :   key
                    ;
        }
        throw new IllegalConsoleArgumentsException("Key should be of integral type");
    }
    
    
    
    /**
     * Method calls for encoding and manages the View
     * 
     * @param input console arguments
     * @param key en/decryption key
     * @param test input that deactivates warning messages during a test
     * @return View received from task or an error
     */
    private String translateControl(List<String> input, int key, boolean test){
        String message;
        CipherModel cipherModel = new CipherModel();
        try{
            message = cipherModel.translate(input, key);
        }
        catch(IllegalInputFormException e){
           message = "";
           if(!test)
                JOptionPane.showMessageDialog(null, "Invalid message", "Illegal characters in the message", JOptionPane.WARNING_MESSAGE);
        }
        return message;
    }    
}
