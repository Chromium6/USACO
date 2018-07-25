package chromium.proj1;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CardiacUI {
    JFrame f;
    /* components */
    JTable memCells; // display CARDIAC memory contents

    public CardiacUI() {
        f = new JFrame("CARDIAC");
        String[] columns = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };
        String[][] data = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                data[j][i] = "" + 0;//machine.getCell(i * 10 + j);
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
        memCells = new JTable(model);

        f.add(memCells);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public void setTableVal(int val, int x, int y) {
        memCells.setValueAt((x*10+y) + ":\t\t" + val, y, x);
        f.invalidate();
        f.revalidate();
        f.repaint();
    }

    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardiacUI();
            }
        });
    }
}
