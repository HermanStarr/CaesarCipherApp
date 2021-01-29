package kamil.szymoniak.view;

import kamil.szymoniak.view.listener.MenuBarListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Class creates menu bar in the top of a Window
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class MenuBar extends JMenuBar{

    /**
     * Menu bar listener instance
     */
    private final MenuBarListener menuBarListener;

    /**
     * Constructor creates inits all elements and listener
     */
    public MenuBar() {
        menuBarListener = new MenuBarListener();
        addElementFile();
    }

    /**
     * Add File element to the menu bar
     */
    private void addElementFile(){
        JMenu menu = new JMenu("File");

        JMenuItem exit = new JMenuItem("Exit");
        exit.setActionCommand("Quit");
        menu.add(exit);
        exit.addActionListener(menuBarListener);

        this.add(menu);
    }
}
