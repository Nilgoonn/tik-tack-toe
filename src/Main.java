import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        char p1 = 'X';
        char p2 = 'O';

        boolean isPlayer1 = true;
        boolean gameOn = true;
        Scanner sc = new Scanner(System.in);

        while (gameOn) {
            printBoard(board);

            if (isPlayer1) {
                System.out.println("Player 1 (X), choose a cell (1-9):");
            } else {
                System.out.println("Player 2 (O), choose a cell (1-9):");
            }
            int cell = sc.nextInt();

            if (cell >= 1 && cell <= 9 && placeMove(board, cell, isPlayer1 ? p1 : p2)) {
                if (checkWinner(board)) {
                    printBoard(board);
                    if (isPlayer1) {
                        System.out.println("Player 1 (X) wins!");
                    } else {
                        System.out.println("Player 2 (O) wins!");
                    }
                    gameOn = false;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a tie!");
                    gameOn = false;
                }
                isPlayer1 = !isPlayer1;
            } else {
                System.out.println("Invalid move! Please choose an empty cell.");
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
        System.out.println();
    }

    public static boolean placeMove(char[][] board, int cell, char symbol) {
        int row = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        if (board[row][col] != 'X' && board[row][col] != 'O') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public static boolean checkWinner(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}