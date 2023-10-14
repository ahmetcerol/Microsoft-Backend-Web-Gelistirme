import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyunu");
        System.out.print("Satır sayısını girin: ");
        int rows = scanner.nextInt();
        System.out.print("Sütun sayısını girin: ");
        int cols = scanner.nextInt();
        int totalCells = rows * cols;
        int mines = totalCells / 4; // Mayın sayısını hesapla (elemanSayisi / 4)
        MineSweeper game = new MineSweeper(rows, cols, mines);
        game.printGameBoard();
        while (true) {
            System.out.print("Satır ve sütun seçin (örneğin: 1 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.revealCell(row, col);
            game.printGameBoard();
            if (game.isGameWon()) {
                System.out.println("Tebrikler! Oyunu kazandınız.");
                break;
            }
        }

    }
}