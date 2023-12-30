import java.util.Scanner;

public class Kalori {
    Scanner scn;
    private static double kaloriToplam = 0, proteinToplam = 0, yagToplam = 0, sekerToplam = 0, gramajToplam = 0;
    private double gelenGramaj, bmr;

    Kalori(Scanner scn) {
        this.scn = scn;
    }

    Kalori(double bmr) {
        this.bmr = bmr;
    }
    public void method1(Insan insan){
        String kaloriDegeri = insan.getCinsiyet();
    }

    public void gramajYaz() {
        System.out.println("Yediğiniz Yemeğin Gramajını Yazınız");
        this.gelenGramaj = scn.nextDouble();
        scn.nextLine();
        setGramajToplam(gelenGramaj);
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
        System.out.println("Kaç Gram Yediniz: " + gramajToplam);
        System.out.println("Alınan Toplam Kalori: " + kaloriToplam);
        System.out.println("Alınan Toplam Protein: " + proteinToplam);
        System.out.println("Alınan Toplam Yağ: " + yagToplam);
        System.out.println("Alınan Toplam Şeker: " + sekerToplam);

    }

}
