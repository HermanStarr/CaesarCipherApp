package kamil.szymoniak.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class for menu bar
 *
 * @author Kamil Szu=ymoniak
 * @version 3.0
 */
public class MenuBarListener implements ActionListener {

    /**
     * Constructor
     */
    public MenuBarListener() {
    }

    /**
     * Listen to actions.
     * For 'Quit' it exits the program
     *
     * @param e action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Quit")){
            System.exit(0);
        }
    }
}
