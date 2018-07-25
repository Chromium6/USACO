package chromium.proj1;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        /* var dec */
        Cardiac pc; // cardiac simulation
        CardiacUI gui; // display data
        /* init */
        pc = new Cardiac();
        gui = new CardiacUI();
        pc.setDefaultInput();
        pc.setDefaultOutput();
        /* run */
        gui.run();
        BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
        while ((pc.pc+"").charAt(0) != '9') {
            try {
                System.out.print(">>> ");
                pc.execute(Integer.parseInt(k.readLine()));
                for (int i = 0; i < 10; i ++) {
                    for (int j = 0; j < 10; j ++) {
                        int val = pc.getCell(j*10+i);
                        gui.memCells.setValueAt(""+val, j, i);
                    }
                }
            }
            catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        System.out.println("CARDIAC Interactive Shell Terminating...");
        gui.f.setVisible(false);
        gui.f.dispose();
        // read from a file
        /*String fileName = "multiplication.txt";
        try (BufferedReader k  = new BufferedReader(new FileReader("C:\\Users\\Michael Zhang\\Desktop\\00\\18\\Docs\\USACO\\CARDIAC\\src\\main\\java\\CardiacFiles\\" + fileName))) {
            while(true) {
                String exe = k.readLine();
                if (exe.charAt(0) == '9') break;
                pc.execute(exe);
                for (int i = 0; i < 10; i ++) {
                    for (int j = 0; j < 10; j ++) {
                        gui.setTableVal(pc.getCell(j*10+i), j, i);
                    }
                }
            }
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }*/
    }
}
