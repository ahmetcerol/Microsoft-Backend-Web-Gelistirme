import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Bir sayı giriniz: ");
            int sayi = scanner.nextInt();

            if (sayi <= 1) {
                System.out.println(sayi + " bir asal sayı değildir.");
            } else if (isAsal(sayi, 2)) {
                System.out.println(sayi + " bir asal sayıdır.");
            } else {
                System.out.println(sayi + " bir asal sayı değildir.");
            }
        }
        public static boolean isAsal(int sayi, int bolen) {
            if (bolen * bolen > sayi) {
                return true;
            }
            if (sayi % bolen == 0) {
                return false;
            }
            return isAsal(sayi, bolen + 1);
        }
    }

