import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    private int[][] gameBoard;
    private boolean[][] mineLocations;
    private int rows;
    private int cols;
    private int mines;

    public MineSweeper(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        gameBoard = new int[rows][cols];
        mineLocations = new boolean[rows][cols];
        initializeGameBoard();
        placeMines();
    }

    public void initializeGameBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameBoard[i][j] = -1; // -1 represents unrevealed cells
            }
        }
    }

    public void placeMines() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < mines) {
            int row = rand.nextInt(rows);
            int col = rand.nextInt(cols);
            if (!mineLocations[row][col]) {
                mineLocations[row][col] = true;
                minesPlaced++;
            }
        }
    }

    public void printGameBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gameBoard[i][j] == -1) {
                    System.out.print("X "); // Unrevealed cell
                } else {
                    System.out.print(gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && gameBoard[row][col] == -1;
    }

    public void revealCell(int row, int col) {
        if (!isValidMove(row, col)) {
            System.out.println("Geçersiz hamle. Lütfen tekrar deneyin.");
            return;
        }

        if (mineLocations[row][col]) {
            System.out.println("Mayına bastınız! Oyunu kaybettiniz.");
            gameBoard[row][col] = -2; // -2 represents a revealed mine
            printGameBoard();
            System.exit(0);
        } else {
            int count = countAdjacentMines(row, col);
            gameBoard[row][col] = count;
            if (count == 0) {
                // If there are no adjacent mines, recursively reveal adjacent cells.
                revealAdjacentCells(row, col);
            }
        }
    }

    public int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && mineLocations[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void revealAdjacentCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && gameBoard[newRow][newCol] == -1) {
                    revealCell(newRow, newCol);
                }
            }
        }
    }

    public boolean isGameWon() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (gameBoard[i][j] == -1 && !mineLocations[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    }


