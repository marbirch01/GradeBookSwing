import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassContainerTableModel extends AbstractTableModel {
    public static final String[] columnNames = {"Imie", "Ilość Studentów", "Maksymalna Ilość Studentów", "Procent"};
    public List<Class> data;

    public ClassContainerTableModel(Map<?, Class> data) {
        this.data = new ArrayList<Class>(data.values());
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).groupName;
            case 1:
                return data.get(rowIndex).studentList.size();
            case 2:
                return data.get(rowIndex).maxNumberOfStudents;
            case 3:
                return (((float) data.get(rowIndex).studentList.size()) / data.get(rowIndex).maxNumberOfStudents) * 100;
        }
        throw new IllegalStateException("Unhandled column index: " + columnIndex);
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
}