import java.util.Scanner;

public class TicTacToe {

    private static final char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("=== TIC-TAC-TOE (Morpion) ===\n");
        System.out.println("Player X vs Player O");
        System.out.println("Enter row and column (1-3) to play.\n");

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row column): ");

            int row = scanner.nextInt() - 1; // Convert to 0-based index
            int col = scanner.nextInt() - 1;

            // Validation
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Place the mark
            board[row][col] = currentPlayer;

            // Check if someone won
            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " WINS!");
                break;
            }

            // Check for draw
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a DRAW!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Initialize empty board
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the board nicely
    private static void printBoard() {
        System.out.println("\n   1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("  ---+---+---");
        }
        System.out.println();
    }

    // Check if current player has won
    private static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;

        return false;
    }

    // Check if the board is full (draw)
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}