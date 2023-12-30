import java.util.Scanner;

public class Insan {
    Scanner scn;
    private String isim, secilenOgun;
    private String cinsiyet;
    private double boy, kilo, aktivite;
    public double bmr = 0;

    private int yas;

    public Insan(Scanner scn) {
        System.out.println("\u001B[32m| | | | | Hoş Geldiniz | | | | |\u001B[0m");
        this.scn = scn;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void bilgiAl() {

        System.out.println("İsminizi Giriniz: ");
        isim = scn.nextLine();

        System.out.println("Cinsiyetinizi Giriniz: \n(Erkek \\ Kadın)");
        cinsiyet = scn.nextLine();

        System.out.println("Boyunuzu Giriniz: ");
        boy = scn.nextDouble();

        System.out.println("Kilonuzu Giriniz: ");
        kilo = scn.nextDouble();

        System.out.println("Yaşınızı Giriniz: ");
        yas = scn.nextInt();

        System.out.println("Günlük Hareket Seviyenizi Giriniz\n1-Az Hareketli\n2-Orta Hareketli\n3-Çok Hareketli ");
        aktivite = scn.nextInt();
        scn.nextLine();
        if (aktivite == 1)
            aktivite = 1.28;
        else if (aktivite == 2)
            aktivite = 1.55;
        else if (aktivite == 3)
            aktivite = 1.81;


    }

    //Inner CLASS!!!
    public class Erkek {
        Food sabahYemek, ogleYemek, aksamYemek;
        Kalori kaloriSinifi;

        public Erkek(Food sabahYemek, Food ogleYemek, Food aksamYemek, Kalori kaloriSinifi) {
            this.sabahYemek = sabahYemek;
            this.ogleYemek = ogleYemek;
            this.aksamYemek = aksamYemek;
            this.kaloriSinifi = kaloriSinifi;
            System.out.println(" - - - - - - - - - - - - - - - - - - - -\n\tMerhaba " + isim + " Bey");
            setBmr();
            System.out.println("Bugün Almanız Gereken Kalori Miktarı: " + Math.floor(bmr) + "\n- - - - - - - - - - - - - - - - - - - -");
        }

        public void setBmr() {
            bmr = (88.362 + (13.397 * kilo) + (4.799 * boy) - (5.677 * yas) * aktivite);
            kaloriSinifi.setBmr(bmr);
        }

        public void ogunSecimi() {
            System.out.println("Sabah - Öğle - Akşam\nÖğün Seçiniz: ");
            secilenOgun = scn.nextLine();

            if (secilenOgun.equalsIgnoreCase("sabah") || secilenOgun.equals("1")) {
                sabahYemek = new SabahOgun();
                sabahYemek.yiyecekSec();

            } else if (secilenOgun.equalsIgnoreCase("öğle") || secilenOgun.equals("2")) {
                ogleYemek = new OgleOgun();
                ogleYemek.yiyecekSec();

            } else if (secilenOgun.equalsIgnoreCase("akşam") || secilenOgun.equals("3")) {
                ogleYemek = new OgleOgun();
                aksamYemek.yiyecekSec();
            } else {
                System.out.println("\nLütfen Geçerli Bir Öğün Giriniz");
                ogunSecimi();
            }

            System.out.println("\u001B[31mTekrar Öğün Seçmek İster Misiniz?\tEvet: E - Hayır: H\u001B[0m");//Kırmızı Yazı
            if (scn.nextLine().equalsIgnoreCase("e"))
                ogunSecimi();
            else {
                kaloriSinifi.degerleriYazdir();
            }
        }

    }

    public class Kadin {
        Food sabahYemek, ogleYemek, aksamYemek;
        Kalori kaloriSinifi;

        public Kadin(Food sabahYemek, Food ogleYemek, Food aksamYemek, Kalori kaloriSinifi) {
            this.sabahYemek = sabahYemek;
            this.ogleYemek = ogleYemek;
            this.aksamYemek = aksamYemek;
            this.kaloriSinifi = kaloriSinifi;
            System.out.println("- - - - - - - - - - - - - - - - - - - -\n\tMerhaba " + isim + " Hanım");
            setBmr();
            System.out.println("Bugün Almanız Gereken Kalori Miktarı: " + Math.floor(bmr) + "\n- - - - - - - - - - - - - - - - - - - -");
        }

        public void setBmr() {
            bmr = (88.362 + (13.397 * kilo) + (4.799 * boy) - (5.677 * yas) * aktivite);
            kaloriSinifi.setBmr(bmr);
        }

        public void ogunSecimi() {
            System.out.println("Sabah - Öğle - Akşam\nLütfem Bunlardan Bir Öğün Seçiniz: ");
            secilenOgun = scn.nextLine();

            if (secilenOgun.equalsIgnoreCase("sabah") || secilenOgun.equals("1")) {
                sabahYemek = new SabahOgun();
                sabahYemek.yiyecekSec();

            } else if (secilenOgun.equalsIgnoreCase("öğle") || secilenOgun.equals("2")) {
                ogleYemek = new OgleOgun();
                ogleYemek.yiyecekSec();

            } else if (secilenOgun.equalsIgnoreCase("akşam") || secilenOgun.equals("3")) {
                aksamYemek = new AksamOgun();
                aksamYemek.yiyecekSec();
            } else {
                System.out.println("Lütfen Geçerli Bir Öğün Giriniz");
                ogunSecimi();
            }

            System.out.println("\u001B[31mTekrar Öğün Seçmek İster Misiniz?\tEvet: E - Hayır: H\u001B[0m");//Kırmızı Yazı
            if (scn.nextLine().equalsIgnoreCase("e"))
                ogunSecimi();
            else {
                kaloriSinifi.degerleriYazdir();
            }
        }
    }
}
