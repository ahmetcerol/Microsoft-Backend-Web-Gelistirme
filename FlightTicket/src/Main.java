import java.awt.image.ColorConvertOp;
import java.util.Scanner;
/**
 * Uçuş bilet fiyatı hesaplayan bir Java programı.
 * Date: 12.10.2023
 * @Author: Ahmet Can Erol
 */
public class Main {
    public static void main(String[] args) {
         final double DISTANCE_RATE = 0.10;
         final double AGE_DISCOUNT_CHILD = 0.50;
         final double AGE_DISCOUNT_YOUNG = 0.10;
         final double AGE_DISCOUNT_ELDERLY = 0.30;
         final double ROUND_TRIP_DISCOUNT = 0.20;

        int distance, age, flightType, ticketPrice, discount;
        Scanner input = new Scanner(System.in);

        /*Kullanıcıdan gideceği mesafeyi aldık. Burada do while kullanmamızın sebebi kullanıcı doğru sayıları girene kadar
        yeniden sormamız gerekmesi */
        do {
            System.out.print("Mesafeyi KM türünden giriniz: ");
            distance = input.nextInt();
            if (distance <= 0) {
                System.out.println("Hatalı Veri Girdiniz !");
            }
        } while (distance <= 0);

        /*Kullanıcıdan yaşını aldık yine do while kullanarak döngüye soktuk.*/
        do {
            System.out.print("Yasinizi giriniz: ");
            age = input.nextInt();
            if (age <= 0) {
                System.out.println("Hatalı Veri Girdiniz !");
            }
        } while (age <= 0);

        /*Kullanıcıdan yolculuk tipini aldık.*/
        do {
            System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): ");
            flightType = input.nextInt();
            if (flightType != 1 && flightType != 2) {
                System.out.println("Hatalı Veri Girdiniz !");
            }
        } while (flightType != 1 && flightType != 2);

        //Bilet fiyatını hesapladık
        ticketPrice = (int) (distance*DISTANCE_RATE);

        //Yaşa göre bilet fiyatına indirim yaptık.
        if (age < 12 ) {
            discount = (int) (ticketPrice*AGE_DISCOUNT_CHILD);
            ticketPrice = ticketPrice - discount;
        }
        else if (age>12 && age<24) {
            discount = (int) (ticketPrice*AGE_DISCOUNT_YOUNG);
            ticketPrice = ticketPrice - discount;
        }
        else if (age > 65) {
            discount = (int) (ticketPrice*AGE_DISCOUNT_ELDERLY);
            ticketPrice = ticketPrice - discount;
        }

        switch (flightType){
            case 1: System.out.println("Toplam Tutar:"+ ticketPrice);
            break;
            case 2: discount = (int) (ticketPrice*ROUND_TRIP_DISCOUNT);
                    //İndirimi hesapladıktan sonra iki ile çarparak gidiş dönüş bileti fiyatını hesapladık.
                    ticketPrice= (ticketPrice-discount)*2;
                    System.out.println("Toplam Tutar:"+ ticketPrice);
                    break;
        }
    }
}
