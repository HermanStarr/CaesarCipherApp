package kamil.szymoniak.view;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class for window creation
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public abstract class Window {

    /**
     * Window title
     */
    private String title;
    /**
     * Dimensions of the window
     */
    private Dimension dimensions;
    /**
     * Content frame
     */
    private JFrame frame;

    /**
     * Constructor
     * @param title title of the window
     * @param dimensions dimensions of the window
     */
    public Window(String title, Dimension dimensions) {
        setWindowTitle(title);
        setWindowDimensions(dimensions);
    }

    /**
     * Method initializing window and its components if existing
     */
    public final void init(){

        initFrame();

        Container c = initContentPane();
        if(c != null)
            frame.setContentPane(c);

        JMenuBar mb = initMenuBar();
        if(mb != null)
            frame.setJMenuBar(mb);

        frame.setSize(getWindowDimensions());
        frame.setVisible(true);

        afterInit();
    }

    /**
     * If there is something to perform after the init
     */
    protected void afterInit() {

    }

    /**
     * Init window frame
     */
    protected void initFrame(){
        frame = new JFrame(getWindowTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Abstract method to init content pane of the frame
     * @return created content pane or null
     */
    abstract protected Container initContentPane();

    /**
     * Initializes the menu bar
     * @return created menu bar or null
     */
    protected JMenuBar initMenuBar(){
        return null;
    }

    /**
     *
     * @return window title
     */
    public String getWindowTitle(){
        return title;
    }

    /**
     *
     * @return window dimensions
     */
    public Dimension getWindowDimensions(){
        return dimensions;
    }

    /**
     *
     * @return window frame
     */
    public JFrame getWindowFrame() {
        return frame;
    }

    /**
     * Set the window title
     * @param title new window title
     */
    public void setWindowTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param dimensions new window dimensions
     */
    public void setWindowDimensions(Dimension dimensions) {
        this.dimensions = dimensions;
    }

}
