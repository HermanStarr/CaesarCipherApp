package kamil.szymoniak.main;

import kamil.szymoniak.view.MainWindow;
import kamil.szymoniak.view.Window;

/**
 * Main class of Caesar cipher
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class Main {

    /**
     * Main function acts as an entry point to the program.
     * 
     * @param args command line arguments.
     *             args[0] - width of the window
     *             args[1] - height of the window
     */
    public static void main(String[] args) {

        int width = args.length != 0 ? Integer.parseInt(args[0]) : 700;
        int height = args.length > 1 ? Integer.parseInt(args[1]) : 600;

        javax.swing.SwingUtilities.invokeLater(() -> {
            Window mainWindow = new MainWindow("Caesar Cipher", width, height);
            mainWindow.init();
        });
    }
    
}
