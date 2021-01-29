package kamil.szymoniak.view;

import kamil.szymoniak.model.HistoryModel;
import kamil.szymoniak.view.listener.HistoryListener;

import javax.swing.*;
import java.awt.*;


/**
 * Class allowing the view of history of performed encodings
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class HistoryView {

    /**
     * Panel of the view
     */
    private final JPanel panel;
    /**
     * Model for the given class
     */
    private final HistoryModel historyModel;
    /**
     * Table of previouys entries
     */
    private final JTable historyTable;


    /**
     * Constructor taking history model.
     * History mode is instance is defined in {@link MainWindow#initContentPane()} to aid with changes in entries table
     *
     * @param historyModel passed history model
     */
    public HistoryView(HistoryModel historyModel) {

        this.historyModel = historyModel;

        HistoryListener historyListener = new HistoryListener(this);

        historyTable = new JTable(historyModel);
        historyTable.addKeyListener(historyListener);

        JScrollPane scrollPane = new JScrollPane(historyTable);

        panel = new JPanel(new BorderLayout());
        panel.setOpaque(true);
        panel.add(scrollPane, BorderLayout.CENTER);

    }

    /**
     * Method deletes selected item
     */
    public void deleteSelected(){
        historyModel.clearSingleElement(historyTable.getSelectedRow());
    }

    /**
     * @return panel of a class
     */
    public JPanel getPanel() {
        return panel;
    }

}
