import java.util.InputMismatchException;
import java.util.Scanner;

public interface Food {
    void yiyecekSec();

    void gramajYaz();

    void besinDegleriniGonder(double kalori, double protein, double yag, double seker);
}

class SabahOgun implements Food {
    private final String[] sabahKahvalti = {"Yumurta", "Muz", "Yulaf", "Ispanak", "Badem"};
    static private Scanner scn;
    static private Kalori kaloriSinifi;

    public SabahOgun() {
        System.out.println("* * * * * Günaydın * * * * *");
    }

    public SabahOgun(Scanner scn, Kalori kaloriSinifi) {
        SabahOgun.scn = scn;
        SabahOgun.kaloriSinifi = kaloriSinifi;
    }

    @Override
    public void gramajYaz() {
        kaloriSinifi.gramajYaz();
    }

    @Override
    public void yiyecekSec() {
        String devamEt = "e";
        int secim=0;

        do {
            for (int i = 0; i < sabahKahvalti.length; i++) {
                System.out.println((i + 1) + " - " + sabahKahvalti[i]);
            }
            System.out.println("Lütfen Yediğiniz Yemeği Seçiniz \n(1,2,3,4,5)");
            try {
                secim = scn.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Lütfen Bir Sayı Giriniz.");
                scn.next();
                yiyecekSec();
            }

            gramajYaz();

            switch (secim) {
                case 1:
                    besinDegleriniGonder(70, 6, 5, 0.0);
                    break;
                case 2:
                    besinDegleriniGonder(89, 1.1, 0.3, 12.2);
                    break;
                case 3:
                    besinDegleriniGonder(389, 16.9, 6.9, 0.8);
                    break;
                case 4:
                    besinDegleriniGonder(23, 2.9, 0.4, 0.4);
                    break;
                case 5:
                    besinDegleriniGonder(576, 21, 49, 4);
                    break;
                default:
                    System.out.println("HATALI İŞLEM");
                    yiyecekSec();
                    break;
            }
            System.out.println("\u001B[31mFarklı Yiyecek Seçmek İstiyor Musunuz?\tEvet: E - Hayır: H\u001B[0m");//Kırmızı Yazı
            devamEt = scn.nextLine();
        } while (devamEt.equalsIgnoreCase("e"));
    }

    @Override
    public void besinDegleriniGonder(double kalori, double protein, double yag, double seker) {
        kaloriSinifi.kaloriAyarla(kalori);
        kaloriSinifi.proteinAyarla(protein);
        kaloriSinifi.yagAyarla(yag);
        kaloriSinifi.sekerAyarla(seker);
    }

}

class OgleOgun implements Food {
    private String[] ogleYemegi = {"Ekmek", "Tavuk Göğsü", "Pilav", "Sebzeli Çorba"};

    static private Scanner scn;
    static private Kalori kaloriSinifi;

    public OgleOgun() {
        System.out.println("* * * * * Tünaydın * * * * *");
    }

    public OgleOgun(Scanner scn, Kalori kaloriSinifi) {
        OgleOgun.scn = scn;
        OgleOgun.kaloriSinifi = kaloriSinifi;
    }

    @Override
    public void gramajYaz() {
        kaloriSinifi.gramajYaz();
    }

    @Override
    public void yiyecekSec() {
        String devamEt = "e";
        int secim=0;
        do {
            for (int i = 0; i < ogleYemegi.length; i++) {
                System.out.println((i + 1) + " - " + ogleYemegi[i]);
            }

            System.out.println("Lütfen Yediğiniz Yemeği Seçiniz \n(1,2,3,4)");
            try {
                secim = scn.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Lütfen Bir Sayı Giriniz.");
                scn.next();
                yiyecekSec();
            }

            gramajYaz();

            switch (secim) {
                case 1:
                    besinDegleriniGonder(250, 9, 1.5, 1.5);
                    break;
                case 2:
                    besinDegleriniGonder(165, 31, 3.6, 0);
                    break;
                case 3:
                    besinDegleriniGonder(130, 2.5, 0.2, 0);
                    break;
                case 4:
                    besinDegleriniGonder(40, 2, 2, 2.5);
                    break;
                default:
                    System.out.println("HATALI İŞLEM");
                    yiyecekSec();
                    break;
            }
            System.out.println("\u001B[31mFarklı Yiyecek Seçmek İstiyor Musunuz?\tEvet: E - Hayır: H\u001B[[0m");//Kırmızı Yazı
            devamEt = scn.nextLine();
        } while (devamEt.equalsIgnoreCase("e"));
    }

    @Override
    public void besinDegleriniGonder(double kalori, double protein, double yag, double seker) {
        kaloriSinifi.kaloriAyarla(kalori);
        kaloriSinifi.proteinAyarla(protein);
        kaloriSinifi.yagAyarla(yag);
        kaloriSinifi.sekerAyarla(seker);
    }
}

class AksamOgun implements Food {
    String[] aksamYemegi = {"Dana Eti", "Pilav", "Yoğurt", "Ton Balığı"};

    static private Scanner scn;
    static private Kalori kaloriSinifi;

    public AksamOgun() {
        System.out.println("* * * * * İyi Akşamlar * * * * *");
    }

    public AksamOgun(Scanner scn, Kalori kaloriSinifi) {
        AksamOgun.scn = scn;
        AksamOgun.kaloriSinifi = kaloriSinifi;
    }

    @Override
    public void gramajYaz() {
        kaloriSinifi.gramajYaz();
    }

    @Override
    public void yiyecekSec() {
        String devamEt = "e";
        int secim=0;
        do {
            for (int i = 0; i < aksamYemegi.length; i++) {
                System.out.println((i + 1) + " - " + aksamYemegi[i]);
            }
            System.out.println("Lütfen Yediğiniz Yemeği Seçiniz \n(1,2,3,4)");
            try {
                secim = scn.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Lütfen Bir Sayı Giriniz.");
                scn.next();
                yiyecekSec();
            }

            gramajYaz();

            switch (secim) {
                case 1:
                    besinDegleriniGonder(250, 28.5, 18.5, 0);
                    break;
                case 2:
                    besinDegleriniGonder(130, 2.5, 0.2, 0);
                    break;
                case 3:
                    besinDegleriniGonder(59, 10, 1.5, 3.5);
                    break;
                case 4:
                    besinDegleriniGonder(100, 23.5, 0.75, 0);
                    break;
                default:
                    System.out.println("HATALI İŞLEM");
                    yiyecekSec();
                    break;
            }
            System.out.println("\u001B[31mFarklı Yiyecek Seçmek İstiyor Musunuz?\tEvet: E - Hayır: H\u001B[0m");//Kırmızı Yazı
            devamEt = scn.nextLine();
        } while (devamEt.equalsIgnoreCase("e"));
    }

    @Override
    public void besinDegleriniGonder(double kalori, double protein, double yag, double seker) {
        kaloriSinifi.kaloriAyarla(kalori);
        kaloriSinifi.proteinAyarla(protein);
        kaloriSinifi.yagAyarla(yag);
        kaloriSinifi.sekerAyarla(seker);
    }
}