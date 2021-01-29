package kamil.szymoniak.view.listener;

import kamil.szymoniak.view.HistoryView;

import java.awt.event.*;

/**
 * Class listens to key and mouse actions and performs specified actions in history table
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class HistoryListener implements KeyListener{

    /**
     * Listened to instance of history view
     */
    private final HistoryView historyView;

    /**
     * Constructor taking history view
     * @param historyView passed history view
     */
    public HistoryListener(HistoryView historyView) {
        this.historyView = historyView;
    }

    /**
     * Method listens for typed key
     * @param e key event
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Method listens for pressed key
     * @param e key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DELETE){
            historyView.deleteSelected();
        }
    }

    /**
     * Method listens for released key
     * @param e key event
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
