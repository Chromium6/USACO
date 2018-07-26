package chromium.proj1;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CardiacSwingGUI {
    private JPanel mainPanel;
    private JTable memoryCells;

    private void createUIComponents() {
        // JTable settings
        String[] columns = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };
        Integer[][] data = new Integer[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                data[j][i] = 0;//machine.getCell(i * 10 + j);
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            // prevents user editing of table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return Integer.class;
            }
        };
        memoryCells = new JTable(model);
    }

    public void setTableVal(int val, int x, int y) {
        memoryCells.setValueAt(val, y, x);
        mainPanel.repaint();
    }

    public void run() {
        JFrame f = new JFrame("CARDIAC");
        f.setContentPane(new CardiacSwingGUI().mainPanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}
