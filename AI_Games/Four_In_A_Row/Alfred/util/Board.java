package util;

/**
Stores game board information (Memory).
*/
public class Board {
    // 0 = empty, -1 = enemy, 1 = self
    private int[][] data;
    private int column, row;

    public Board(int l, int w) {
        data = new int[l][w]; // seven columns, six rows
        column = l;
        row = w;
    }

    /**
    * Searches for a horizontal win-condition (given a key to look for i.e. 1 or -1)
    */
    public boolean hasHorizontalMatch(int key) {
        for (int i = 0; i < row; i ++) { // y-axis
            for (int j = 0; j < column; j ++) { // x-axis
                int sum = (data[j][i] == key ? key : 0);
                for (int offset = -2; offset <= 2; offset++) {
                    if (offset == 0) continue;
                    if (j+offset <= 0 || j+offset > column) continue;
                    sum += (data[j+offset][i] == key ? key : 0);
                }
                if (Math.abs(sum) >= 3) return true;
            }
        }
        return false;
    }

    /**
    * Searches for a vertical win-condition (given a key to look for i.e. 1 or -1)
    */
    public boolean hasVerticalMatch(int key) {
        return false;
    }

    /**
    * Searches for a diagonal win-condition (given a key to look for i.e. 1 or -1)
    */
    public boolean hasDiagonalMatch(int key) {
        return false;
    }

    public void updateBoard(String scheme) {
        String[] lines = scheme.split(";");
        String[] numbers;
        int a = 0;
        int b = 0;
        for (String row : lines) {
            numbers = row.split(",");
            for (String num : numbers) {
                data[b][a] = Integer.parseInt(num);
                b++;
            }
            a++;
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int[] i : data) {
            for (int j : i) {
                output += j + "\t";
            }
            output += "\n";
        }
        return output;
    }

}