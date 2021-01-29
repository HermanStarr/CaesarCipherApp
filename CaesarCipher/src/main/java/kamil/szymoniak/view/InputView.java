package kamil.szymoniak.view;

import kamil.szymoniak.model.HistoryModel;
import kamil.szymoniak.view.listener.InputListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class allows to display the input form for the cipher
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class InputView {

    /**
     * History cipher
     */
    private final HistoryModel historyModel;
    /**
     * Panel of the view
     */
    protected JPanel panel;
    /**
     * Button group for radio buttons
     */
    protected ButtonGroup buttonGroup;
    /**
     * Text fields for inputting key and message
     */
    protected JTextField keyTextField, messageTextField;
    /**
     * Encoded message output
     */
    protected JTextArea translationTextArea;

    /**
     * Constructor for the class. Creates buttons and text field used in the input form and output
     * @param historyModel model of the history view
     */
    public InputView(HistoryModel historyModel){

        this.historyModel = historyModel;

        panel = new JPanel();

        JRadioButton encodeRadioButton = new JRadioButton("Encode");
        encodeRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
        encodeRadioButton.setAlignmentY(Component.TOP_ALIGNMENT);
        encodeRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        encodeRadioButton.setActionCommand("encode");
        encodeRadioButton.setSelected(true);

        JRadioButton decodeRadioButton = new JRadioButton("Decode");
        decodeRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
        decodeRadioButton.setAlignmentY(Component.TOP_ALIGNMENT);
        decodeRadioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        decodeRadioButton.setActionCommand("decode");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(encodeRadioButton);
        buttonGroup.add(decodeRadioButton);

        messageTextField = new PromptedText("Enter message", 40);
        messageTextField.setHorizontalAlignment(SwingConstants.CENTER);
        messageTextField.setAlignmentY(Component.TOP_ALIGNMENT);
        messageTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        keyTextField = new PromptedText("Enter key", 15);
        keyTextField.setHorizontalAlignment(SwingConstants.CENTER);
        keyTextField.setAlignmentY(Component.TOP_ALIGNMENT);
        keyTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton translateButton = new JButton("Translate");
        translateButton.setHorizontalAlignment(SwingConstants.CENTER);
        translateButton.setAlignmentY(Component.TOP_ALIGNMENT);
        translateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        translateButton.setActionCommand("translate");

        translationTextArea = new JTextArea(4, 40);
        translationTextArea.setAlignmentY(Component.TOP_ALIGNMENT);
        translationTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        translationTextArea.setText("Translated message");
        translationTextArea.setEditable(false);

        InputListener inputListener = new InputListener(this);
        encodeRadioButton.addActionListener(inputListener);
        decodeRadioButton.addActionListener(inputListener);
        translateButton.addActionListener(inputListener);

        panel.add(encodeRadioButton);
        panel.add(decodeRadioButton);
        panel.add(messageTextField);
        panel.add(keyTextField);
        panel.add(translateButton);
        panel.add(translationTextArea);

    }

    /**
     * @return text of the message text field
     */
    public String getMessageText(){
        return messageTextField.getText();
    }

    /**
     * @return text of the key text field
     */
    public String getKeyText(){
        return keyTextField.getText();
    }

    /**
     * Sets the text of the output translation area
     * @param text new text of the field
     */
    public void setTranslationTextArea(String text){
        translationTextArea.setText(text);
    }

    /**
     * @return history model inside the class
     */
    public HistoryModel getHistoryModel() {
        return historyModel;
    }

    /**
     * @return panel of the view
     */
    public JPanel getPanel() {
        return panel;
    }

}

/**
 * Private class managing out-of-focus text field texts
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
class PromptedText extends JTextField implements FocusListener{

    /**
     * Default string of the field
     */
    private final String defaultText;
    /**
     * Flag describing what the field should show, default or typed text
     */
    private boolean showingDefault;


    /**
     * Constructor taking default text and size of the field
     * @param defaultText default text when out of focus
     * @param columns number of columns in text field
     */
    public PromptedText(String defaultText, int columns) {
        super(defaultText, columns);
        this.defaultText = defaultText;
        this.showingDefault = true;
        super.addFocusListener(this);
    }


    /**
     * Listens if focus is gained
     * @param e focus event
     */
    @Override
    public void focusGained(FocusEvent e){
        if(this.getText().isEmpty()){
            super.setText("");
            showingDefault = false;
        }          
    }

    /**
     * Listens if focus is lost
     * @param e focus event
     */
    @Override
    public void focusLost(FocusEvent e){
        if(this.getText().isEmpty()){
            super.setText(defaultText);
            showingDefault = true;
        }   
    }

    /**
     * @return text inside the field
     */
    @Override
    public String getText(){
        return showingDefault ? "" : super.getText();
    }
}
