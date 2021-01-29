package kamil.szymoniak.view;

import kamil.szymoniak.model.HistoryModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


/**
 * Class of main window of the program, implementing action listener
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class MainWindow extends Window implements ComponentListener {

    /**
     * Constructor
     * @param title window title
     * @param width window width
     * @param height window height
     */
    public MainWindow(String title, int width, int height) {
        super(title, new Dimension(width, height));
    }

    /**
     * Init Frame of the window
     */
    @Override
    protected void initFrame() {
        super.initFrame();
    }

    /**
     * Add component listener to the window frame after initialization
     */
    @Override
    protected void afterInit() {
        getWindowFrame().addComponentListener(this);
    }

    /**
     * Initializes contents of the window
     * @return content pane of the window
     */
    @Override
    protected Container initContentPane() {
        HistoryModel historyModel = new HistoryModel();
        InputView inputView = new InputView(historyModel);
        HistoryView historyView = new HistoryView(historyModel);

        MainView mainView = new MainView(inputView, historyView, getWindowDimensions());

        return mainView.getSplitPane();
    }

    /**
     * Initializes menu bar
     * @return new menu bar
     */
    @Override
    protected JMenuBar initMenuBar() {
        return new MenuBar();
    }

    /**
     * Listen for resizing of the window
     * @param e resize event
     */
    @Override
    public void componentResized(ComponentEvent e) {
        JSplitPane splitPane = (JSplitPane) getWindowFrame().getContentPane();

        splitPane.setDividerLocation(0.3);
    }

    /**
     * Listen for moving
     * @param e move event
     */
    @Override
    public void componentMoved(ComponentEvent e) {

    }

    /**
     * Listen for shown event
     * @param e shown event
     */
    @Override
    public void componentShown(ComponentEvent e) {

    }

    /**
     * Listen for hidden event
     * @param e hidden event
     */
    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
