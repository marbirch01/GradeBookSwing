import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassTableModel extends AbstractTableModel {
    public static final String[] columnNames = {"Imie", "Nazwisko", "Status", "Rok urodzenia", "Ilość punktów", "Adres"};
    public List<Student> data;

    public ClassTableModel(List<Student> data) {
        this.data = data;
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).name;
            case 1:
                return data.get(rowIndex).lastName;
            case 2:
                return data.get(rowIndex).studentStatus;
            case 3:
                return data.get(rowIndex).birthDate;
            case 4:
                return data.get(rowIndex).points;
            case 5:
                return data.get(rowIndex).Address;
        }
        throw new IllegalStateException("Unhandled column index: " + columnIndex);
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
}