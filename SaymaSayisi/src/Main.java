import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int totalNumber;
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç tane sayı gireceksiniz :");
        totalNumber = input.nextInt();
        int [] numbers  = new int [totalNumber];
        for (int sayaç = 1; sayaç<=totalNumber; sayaç++) {
            System.out.print(sayaç+".Sayıyı Giriniz:");
            numbers[sayaç-1] = input.nextInt();
        }
        Arrays.sort(numbers);
        int enKucuk = numbers[0]; // En küçük sayı
        int enBuyuk = numbers[totalNumber - 1]; // En büyük sayı

        System.out.println("En küçük sayı: " + enKucuk);
        System.out.println("En büyük sayı: " + enBuyuk);

    }
}