import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Game {

    public Snake[][] board;
    private int length = 3;
    Scanner scan;
    int headRow;
    int headCol;
    String move;
    int appleX;
    int appleY;
    boolean justAte;

    public Game() {
        board = new Snake[16][16];
        board[6][6] = new Snake(length, 6, 6, this);
        headRow = 6;
        headCol = 6;
        scan = new Scanner(System.in);
        spawnApple();
        printBoard();
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (appleX == i && appleY == j) {
                    System.out.print("@ ");
                } else if (board[i][j] == null){
                    System.out.print("+ ");
                } else {
                    System.out.print(board[i][j].currentState() + " ");
                }
            }
            System.out.println();
        }
    }

    private void spawnApple() {
        appleX = (int) (Math.random() * board.length);
        appleY = (int) (Math.random() * board.length);
        if (board[appleX][appleY] != null) {
            spawnApple();
        }

    }



    public void update() {
        while(true) {
            while (true) {
                System.out.println("What is your move? (W, A, S, D)");
                move = scan.nextLine().toUpperCase();
                if (!move.equals("W") && !move.equals("A") && !move.equals("S") && !move.equals("D")) {
                    System.out.println("DENIED");
                    continue;
                }
                if (move.equals("W") && headRow == 0) {
                    System.out.println("DENIED");
                } else if (move.equals("A") && headCol == 0) {
                    System.out.println("DENIED");
                } else if (move.equals("S") && headRow == 15) {
                    System.out.println("DENIED");
                } else if (move.equals("D") && headCol == 15) {
                    System.out.println("DENIED");
                } else {
                    break;
                }
            }
            if (move.equals("W")) {
                headRow--;
            } else if (move.equals("S")) {
                headRow++;
            } else if (move.equals("A")) {
                headCol--;
            } else if (move.equals("D")) {
                headCol++;
            }
            if (board[headRow][headCol] != null) {
                System.out.println("DENIED");
                if (move.equals("W")) {
                    headRow++;
                } else if (move.equals("S")) {
                    headRow--;
                } else if (move.equals("A")) {
                    headCol++;
                } else if (move.equals("D")) {
                    headCol--;
                }
            } else {
                break;
            }
        }
        if (justAte){
            justAte = false;
        }
        if (headRow == appleX && headCol == appleY) {
            length++;
            justAte = true;
            spawnApple();
        }
        board[headRow][headCol] = new Snake(length, headRow, headCol, this);
        printBoard();

    }



}
