package chromium.proj1;

import java.io.*;

public class Cardiac {
    private int acc, accLength; // accumulator, accumulator digits (default 5)
    private int pointer; // operand address (defaults to size-1)
    int pc; // program counter
    private BufferedReader stdin; // default System.in
    private PrintWriter stdout; // default System.out
    private int[] memory; // memory cells (default 100)

    public Cardiac() {
        memory = new int[100];
        memory[1] = 1; // SPECIAL: mem[0] = 1, mem[1] = 1
        acc = 0;
        pointer = 99;
        accLength = 4;
    }

    public void execute(int command) {
        execute(command + "");
    }

    public void execute(String command) {
        pc = Integer.parseInt(command);
        if (command.length() < 3) command = "0" + command;

        int opcode = Integer.parseInt(command.substring(0, 1)); // specific command
        int operand = Integer.parseInt(command.substring(1)); // cell specifications

        switch (opcode) {
            case 0: // INP [input]: take input and pass it into operand
                try {
                    System.out.print("INPUT: ");
                    int val = Integer.parseInt(stdin.readLine());
                    setCell(operand, val);
                    stdout.println(String.format("PRINTING %d TO CELL %d FROM STDIN", val, operand));
                }
                catch (IOException ioe) {
                    System.err.println(String.format("Error reading from stdout: %s", ioe.getMessage()));
                }
                break;
            case 1: // CLA [clear and add]: reset acc and put operand contents in acc
                acc = getCell(operand);
                stdout.println(String.format("SETTING ACC TO THE VALUE OF CELL %d[%d]", operand, getCell(operand)));
                break;
            case 2: // ADD [add]: add operand to acc
                acc += getCell(operand);
                stdout.println(String.format("ADDING VALUE OF CELL %d[%d] TO ACC[%d]", operand, getCell(operand), acc));
                break;
            case 3: // TAC [test acc contents]: if acc is negative, jump to operand
                stdout.println(String.format("TESTING ACC CONTENTS"));
                if (acc < 0) {
                    pointer = operand;
                    stdout.println(String.format("\tJUMPING TO CELL %d[%d]", getCell(operand)));
                }
                break;
            case 4: // SFT [shift]: shift acc x to left, then y to right (x is operand[0]. y is operand[1]
                acc >>= (int)(operand/10);
                acc <<= (operand%10);
                stdout.println(String.format("SHIFTING ACC %d TO THE LEFT AND %d TO THE RIGHT [%d]", (int)(operand/10), operand%10, acc));
                break;
            case 5: // OUT [output]: output operand contents
                stdout.print(String.format("VALUE OF CELL %d IS ", operand));
                stdout.println(getCell(operand));
                break;
            case 6: // STO [store]: copy acc to operand
                setCell(operand, acc);
                stdout.println(String.format("COPIED ACC[%d] TO CELL %d", acc, operand));
                break;
            case 7: // SUB [subtract]: subtract operand from acc
                acc -= getCell(operand);
                stdout.println(String.format("SUBTRACTED CELL %d[%d] FROM ACC[%d]", operand, getCell(operand), acc));
                break;
            case 8: // JMP [jump]: move to operand
                pointer = operand;
                stdout.println(String.format("JUMPING TO CELL %d[%d]", operand, getCell(operand)));
                break;
            case 9: // HRS [halt and reset]: move to operand, and stop program
                stdout.println(String.format("JUMPING TO CELL %d[%d]\n\tPROGRAM TERMINATED", operand, getCell(operand)));
                stdout.flush();
                pointer = operand;
                return;
        }
        stdout.flush();
    }

    public void interactive() {
        while ((pc+"").charAt(0) != '9') {
            try {
                stdout.print(">>> ");
                stdout.flush();
                execute(Integer.parseInt(stdin.readLine()));
            }
            catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        stdout.println("CARDIAC Interactive Shell Terminating...");
    }

    public int getSize() { return memory.length; }

    public void setInput(String fileName) {
        try {
            stdin = new BufferedReader(new FileReader(fileName));
        }
        catch (IOException ioe) {
            System.err.println(String.format("Error setting stdin to %s: %s", fileName, ioe.getMessage()));
        }
    }
    public void setDefaultInput() { stdin = new BufferedReader(new InputStreamReader(System.in)); }

    public void setOutput(String fileName) {
        try {
            stdout = new PrintWriter(fileName);
        }
        catch (IOException ioe) {
            System.err.println(String.format("Error setting stdout to %s: %s", fileName, ioe.getMessage()));
        }
    }
    public void setDefaultOutput() { stdout = new PrintWriter(System.out); }

    public int getCell(int cellId) { return memory[cellId]; }
    public void setCell(int cellId, int val) { memory[cellId] = val; }
}
