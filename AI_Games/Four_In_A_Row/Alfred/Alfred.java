
import java.io.IOException;
import util.*;

/**
The bot that will control all the activity (the CPU), also contains AI module.
*/
public class Alfred {
    IO io;
    Board board;
    /* Game Settings */
    String myName, enemyName;
    int myID;
    int length = -1, width = -1;

    public void run() throws IOException {
        String[] cmd = io.nextLine().split(" ");
        switch (cmd[0]) {
            case "settings":
                // Only at beginning of game
                switch (cmd[1]) {
                    case "player_names":
                        String[] names = cmd[2].split(",");
                        myName = names[0];
                        enemyName = names[1];
                        break;
                    case "your_bot":
                        if (myName != cmd[2]) {
                            enemyName = myName;
                            myName = cmd[2];
                        }
                        break;
                    case "your_botid":
                        myID = Integer.parseInt(cmd[2]);
                        break;
                    case "field_columns":
                        length = Integer.parseInt(cmd[2]);
                        if (length != -1 && width != -1) {
                            board = new Board(length, width);
                        }
                        break;
                    case "field_rows":
                        width = Integer.parseInt(cmd[2]);
                        if (length != -1 && width != -1) {
                            board = new Board(length, width);
                        }
                        break;
                }
                break;
            case "update":
                if (cmd[1] == "game") {
                    if (cmd[2] == "field") {
                        board.updateBoard(cmd[3]);
                    }
                }
                break;
            case "action":
                io.putToken(0);
                break;
        }
        System.err.println(board);
    }

    public static void main(String[] args) throws IOException {
        (new Alfred()).run();
    }

}