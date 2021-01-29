package kamil.szymoniak.view.listener;

import kamil.szymoniak.controller.Controller;
import kamil.szymoniak.view.InputView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class listens to actions performed in input view
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class InputListener implements ActionListener {

    /**
     * Listened to instance of InputView class
     */
    private final InputView inputView;

    /**
     * Mode of operations as passed by radio buttons
     */
    private String mode;

    /**
     * Constructor taking input view
     * @param inputView passed input view
     */
    public InputListener(InputView inputView) {
        this.inputView = inputView;
        mode = "encoding";
    }

    /**
     * Method listens to the actions performed in input view and acts accordingly.
     * For 'translate' it performs encoding and adds input to the history
     * For 'encode' or 'decode' it changes the mode string
     *
     * @param e action performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "translate":

                if(!inputView.getKeyText().equals("")) {

                    if(!inputView.getMessageText().equals("")) {

                        String[] input = {mode, inputView.getKeyText(), inputView.getMessageText()};
                        Controller controller = new Controller();
                        String translation = controller.beginTranslation(input);
                        inputView.setTranslationTextArea(translation);

                        if(!translation.equals(""))
                            inputView.getHistoryModel().addEntry(input);

                    }
                    else
                        JOptionPane.showMessageDialog(null, "Empty key", "Key cannot be empty", JOptionPane.PLAIN_MESSAGE   );
                }
                else
                    JOptionPane.showMessageDialog(null, "Empty message", "Message cannot be empty", JOptionPane.PLAIN_MESSAGE);
                break;

            case "encode":

                mode = "encoding";
                break;

            case "decode":

                mode = "decoding";
                break;
        }
    }
}
