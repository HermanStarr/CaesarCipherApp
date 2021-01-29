package kamil.szymoniak.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class which displays the split pane of both input and history views
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class MainView {

    /**
     * Split pane holding both views
     */
    private final JSplitPane splitPane;

    /**
     * Constructor taking both views and dimension
     * @param inputView input form and output view of upper half of split pane
     * @param historyView history table view of the lower half of split pane
     * @param dimensions dimensions of the split pane
     */
    public MainView(InputView inputView, HistoryView historyView, Dimension dimensions){
        splitPane = new JSplitPane(SwingConstants.HORIZONTAL, inputView.getPanel(), historyView.getPanel());

        splitPane.setDividerLocation(0.3);
        splitPane.setSize(dimensions);

    }

    /**
     *
     * @return split pane holding two views
     */
    public JSplitPane getSplitPane() {
        return splitPane;
    }
}
