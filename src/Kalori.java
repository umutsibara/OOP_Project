import java.util.InputMismatchException;
import java.util.Scanner;

public class Kalori {
    private Scanner scn;
    private static double kaloriToplam = 0, proteinToplam = 0, yagToplam = 0, sekerToplam = 0, gramajToplam = 0;
    private double gelenGramaj, bmr;

    Kalori(Scanner scn) {
        this.scn = scn;
    }

    public void gramajYaz() {
        System.out.println("Yediğiniz Yemeğin Gramajını Yazınız");
        try{
            this.gelenGramaj = scn.nextDouble();
            scn.nextLine();
            setGramajToplam(gelenGramaj);
        }catch (InputMismatchException e){
            System.out.println("Lütfen Bir Sayı Giriniz.");
            scn.next();
            gramajYaz();
        }
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    private void setGramajToplam(double gramaj) {
        gramajToplam = gramajToplam + gramaj;
    }

    public void kaloriAyarla(double kalori) {
        kaloriToplam += kalori / 100 * gelenGramaj;
    }

    public void proteinAyarla(double protein) {
        proteinToplam += protein / 100 * gelenGramaj;
    }

    public void yagAyarla(double yag) {
        yagToplam += yag / 100 * gelenGramaj;
    }

    public void sekerAyarla(double seker) {
        sekerToplam += seker / 100 * gelenGramaj;
    }

    public void degerleriYazdir() {
        System.out.println(gramajToplam + "Gram Yemek Yediniz: ");
        System.out.print("Alınan \tToplam Kalori: " + Math.floor(kaloriToplam));
        System.out.print("\tToplam Protein: " + Math.floor(proteinToplam));
        System.out.print("\tToplam Yağ: " + Math.floor(yagToplam));
        System.out.println("\tToplam Şeker: " + Math.floor(sekerToplam));
        if (kaloriToplam < bmr)
            System.out.println("\u001B[32mAlmanız Gerekenden " + Math.floor((bmr - kaloriToplam)) + " Kadar Az Kalori Aldınız\u001B[0m");//Yeşil Yazı
        else if (kaloriToplam >= bmr)
            System.out.println("\u001B[32mAlmanız Gerekenden " + Math.floor((bmr - kaloriToplam)) + " Kadar Fazla Kalori Aldınız\u001B[0m");//Yeşil Yazı
    }
}
