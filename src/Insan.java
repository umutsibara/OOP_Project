import java.util.InputMismatchException;
import java.util.Scanner;

public class Insan {
    private Scanner scn;
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

    private void kiloGir(){
        System.out.println("Kilonuzu Giriniz: ");
        try {
            kilo = scn.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Lütfen bir sayı giriniz.");
            scn.next();
            kiloGir();
        }
    }
    private void boyGir(){
        System.out.println("Boyunuzu Giriniz: ");
        try {
            boy = scn.nextDouble();
        }catch (InputMismatchException e){
            System.out.println("Lütfen bir sayı giriniz.");
            scn.next();
            boyGir();
        }
    }
    private void yasGir(){
        System.out.println("Yaşınızı Giriniz: ");
        try {
            yas = scn.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Lütfen bir sayı giriniz.");
            scn.next();
            yasGir();
        }
    }
    private void aktiviteGir(){
        System.out.println("Günlük Hareket Seviyenizi Giriniz\n1-Az Hareketli\n2-Orta Hareketli\n3-Çok Hareketli ");
        try {
            aktivite = scn.nextInt();
            scn.nextLine();
            if (aktivite == 1)
                aktivite = 1.28;
            else if (aktivite == 2)
                aktivite = 1.55;
            else if (aktivite == 3)
                aktivite = 1.81;
            else
                throw new Exception();
        }catch (InputMismatchException e){
            System.out.println("Lütfen Bir Sayı Giriniz: ");
            scn.next();
            aktiviteGir();
        }catch (Exception e){
            System.out.println("1,2 veya 3 sayısını giriniz.");
            aktiviteGir();
        }
    }
    public void bilgiAl() {
        System.out.println("İsminizi Giriniz: ");
        isim = scn.nextLine();

        System.out.println("Cinsiyetinizi Giriniz: \n(Erkek \\ Kadın)");
        cinsiyet = scn.nextLine();

        boyGir();

        kiloGir();

        yasGir();

        aktiviteGir();
    }

    //Inner CLASS!!!
    public class Erkek {
        private Food sabahYemek, ogleYemek, aksamYemek;
        private Kalori kaloriSinifi;

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
        private Food sabahYemek, ogleYemek, aksamYemek;
        private Kalori kaloriSinifi;

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
