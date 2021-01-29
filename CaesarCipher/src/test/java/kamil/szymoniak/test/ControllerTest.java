package kamil.szymoniak.test;

import kamil.szymoniak.controller.Controller;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class of tests for Controller class
 * 
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class ControllerTest {
    private Controller controller;
    
    /**
     * Set up for a test
     */
    @BeforeEach
    public void setUp(){
        controller = new Controller();
    }
    
    /**
     * Tear down of a class after the test
     */
    @AfterEach
    public void tearDown(){
        controller = null;
    }
        
    /**
     * Test of behavior when illegal modes of operation are specified
     * 
     * @param input parameterized test input
     */
    @ParameterizedTest
    @ValueSource(strings = {"encode", "decode", " ", "1"})
    public void testInvalidModes(String input){
       String[] args = new String[]{input, "1", "message"};
       
        assertSame(           
            "",
            controller.beginTranslation(args, true)
        ); 
    }
    
    /**
     * Tests different styles of legal input to specify mode of operation
     * 
     * @param input parameterized test input
     */
    @ParameterizedTest
    @ValueSource(strings = {"encoding", "decoding", "ENCODING", "eNcOdInG"})
    public void testValidMode(String input){
        String[] args = new String[]{input, "1", "message"};
        
        assertNotSame(
                "",
                controller.beginTranslation(args, true)
        );      
    }
       
    /**
     * Tests different forms of invalid cipher keys
     * 
     * @param input parameterized test input
     */
    @ParameterizedTest
    @ValueSource(strings = {"01", "kmwtw", "--1", "++10", "-0", "+-1", "-+1"})
    public void testInvalidKey(String input){
        String[] args = new String[]{"encoding", input, "message"};
        
        assertSame(
            "",
            controller.beginTranslation(args, true)
        ); 
    }
        
    /**
     * Test different forms of legal cipher keys
     * 
     * @param input parameterized test input
     */
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "-1", "10", "-10", "+10"})
    public void testValidKey(String input){
        String[] args = new String[]{"encoding", input, "message"};
        
        assertNotSame( 
            "",
            controller.beginTranslation(args, true)
        ); 
    }
    
}
