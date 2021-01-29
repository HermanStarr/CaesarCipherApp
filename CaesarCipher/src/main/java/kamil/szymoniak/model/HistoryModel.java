package kamil.szymoniak.model;


import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Class responsible for historyView logic
 *
 * @author Kamil Szymoniak
 * @version 3.0
 */
public class HistoryModel extends AbstractTableModel {

    /**
     * Column names in the table
     */
    private final String[] columns = {"Number", "Mode", "Key", "Message", "Date"};

    /**
     * Table of displayed history entries
     */
    private final List<String[]> previousEntryList;

    /**
     * Date formatter
     */
    private final SimpleDateFormat simpleDateFormat;


    /**
     * Constructor
     */
    public HistoryModel() {
        this.previousEntryList = new ArrayList<>();
        this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }


    /**
     * Method adds a new entry to the list of previous entries
     * @param entry Strings as read from the text fields
     */
    public void addEntry(String[] entry){
        String[] newEntry = new String[5];
        if(previousEntryList.isEmpty())
            newEntry[0] = "0";
        else
            newEntry[0] = Integer.toString(previousEntryList.size());

        newEntry[1] = entry[0];
        newEntry[2] = entry[1];
        newEntry[3] = entry[2];

        Date date = new Date();
        newEntry[4] = simpleDateFormat.format(date);

        previousEntryList.add(newEntry);
        fireTableDataChanged();
    }

    /**
     * Deletes a single element from the list
     * @param index row of given element
     */
    public void clearSingleElement(int index){
        previousEntryList.remove(index);
        for(int i = index; i < previousEntryList.size(); i++){
            previousEntryList.get(i)[0] = Integer.toString(i);
        }
        fireTableDataChanged();
    }

    /**
     * Gets the number of rows in the table
     * @return the numbers of rows in the table
     */
    @Override
    public int getRowCount() {
        return previousEntryList.size();
    }

    /**
     * Gets the number of columns in the table
     * @return the numbers of columns in the table
     */
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    /**
     * Gets value from the selected cell
     * @param rowIndex index of cell's row
     * @param columnIndex index of cell's column
     * @return cell under specified indexes
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        String[] previousEntry = previousEntryList.get(rowIndex);

        switch (columnIndex){
            case 0:
                return previousEntry[0];

            case 1:
                return previousEntry[1];

            case 2:
                return previousEntry[2];

            case 3:
                return previousEntry[3];

            case 4:
                return previousEntry[4];

            default:
                return null;
        }
    }

    /**
     * Gets names of the columns
     * @param columnIndex index of the column
     * @return names of thew columns
     */
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
}
