import java.util.Scanner;

/** @author Ahmet Can Erol
    Date: 11.10.2023
    Proje Amaci: Vucut Kitle Indeks Hesaplama
 **/
public class Main {
    public static void main(String[] args) {
        //Scanner kütüphanesi Javada kullanıcıdan girdi almamaıza yaramaktadır.
        Scanner input = new Scanner(System.in);
        //Veri tipini float olarak almadaki nedenim kullanıcıdan boyunu metre olarak almamamız.
        float boy, kilo,kitle;
        // Kullanıcıdan boyunu metre olarak aldık.
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz :");
        boy = input.nextFloat();
        //Kullanıcıdan kilosunu aldık.
        System.out.print("Lütfen kilonuzu giriniz:");
        kilo = input.nextFloat();
        //Kitlesini ölçmek için gerekli işlemleri yaptık.
        kitle= kilo/(boy*boy);
        //Sonucu ekrana bastırdık.
        System.out.println("Vücut Kitle İndeksiniz:"+kitle);

    }
}