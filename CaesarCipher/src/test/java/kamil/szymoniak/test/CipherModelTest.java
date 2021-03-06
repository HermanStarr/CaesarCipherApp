package kamil.szymoniak.test;

import java.util.*;
import kamil.szymoniak.model.IllegalInputFormException;
import kamil.szymoniak.model.CipherModel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Class of tests for Model class
 * 
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class CipherModelTest {
    private CipherModel cipherModel;
    
    /**
     * Set up for a test
     */
    @BeforeEach
    public void setUp(){
        cipherModel = new CipherModel();
    }
    
    /**
     * Tear down of a class after the test
     */
    @AfterEach
    public void tearDown(){
        cipherModel = null;
    }
    
    /**
     * Test of behavior when passed invalid characters
     * 
     * @param input parameterized test input
     */
    @ParameterizedTest
    @ValueSource(strings = {"alphanumerical123", "message.", "Je suis desolé", "bio-mechanical"})
    @SuppressWarnings("ThrowableResultIgnored")
    public void testInvalidCharacters(String input){
        List<String> testStrings =  new ArrayList<>(
                Arrays.asList("1", "1", input));
        
        Assertions.assertThrows(IllegalInputFormException.class, () ->{
            cipherModel.translate(testStrings, 1);
        });
    }

    /**
     * test of behavior when passed valid characters
     * 
     * @param input parameterized test input
     */
    @ParameterizedTest
    @ValueSource(strings = {"alphaandnotnumerical", "MESSAGE", "mEsSaGe", " ", "alpha and not numerical"})
    public void testValidCharacters(String input){
        List<String> testStrings =  new ArrayList<>(
                Arrays.asList("1", "1", input));
        try{
            cipherModel.translate(testStrings, 1);
        }
        catch(IllegalInputFormException e){
            fail("IllegalInputFormException should not be thrown, as string is valid");
        }
    }
    
    /**
     * Test of correctness of encoding
     * 
     * @param input parameterized test input. As the method translate would never receive negative numbers, none are passed
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 27, 53})
    public void testEncodingMessage(int input){
        List<String> testStrings =  new ArrayList<>(
                Arrays.asList("1", "1", "A", "b"));
        String expectedString = "B c";
        
        try{
        assertEquals(expectedString, cipherModel.translate(testStrings, input));
        }
        catch(IllegalInputFormException e){
            fail("IllegalInputFormException should not be thrown, as string is valid");
        }
    }
    
    /**
     * Test of correctness of encoding and then decoding
     */
    @Test
    public void testEncodingAndDecodingMessage(){
        String expectedDecodeString = "A b z";
        List<String> testStrings =  new ArrayList<>(
                Arrays.asList("1", "1", "A", "b", "z"));       
        String expectedEncodedString = "B c a";
        List<String> encodedStrings =  new ArrayList<>(
                Arrays.asList("1", "1", "B", "c", "a"));
        try{
        assertEquals(expectedEncodedString, cipherModel.translate(testStrings, 1));
        }
        catch(IllegalInputFormException e){
            fail("IllegalInputFormException should not be thrown, as string is valid");
        }
        try{
        assertEquals(expectedDecodeString, cipherModel.translate(encodedStrings, 26 - 1));
        }
        catch(IllegalInputFormException e){
            fail("IllegalInputFormException should not be thrown, as string is valid");
        }
    }
}
