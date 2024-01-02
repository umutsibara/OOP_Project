import java.util.Scanner;

public class Main {

    private static void calistir() {
        Scanner scn = new Scanner(System.in);
        Insan insan = new Insan(scn);
        Kalori kaloriSinifi = new Kalori(scn);
        Food sabahYemek = new SabahOgun(scn, kaloriSinifi);
        Food ogleYemek = new OgleOgun(scn, kaloriSinifi);
        Food aksamYemek = new AksamOgun(scn, kaloriSinifi);

        try {
            insan.bilgiAl();
            if (insan.getCinsiyet().equalsIgnoreCase("erkek") ||
                    insan.getCinsiyet().equalsIgnoreCase("e") || insan.getCinsiyet().equals("1")) {
                Insan.Erkek insanErkek = insan.new Erkek(sabahYemek, ogleYemek, aksamYemek, kaloriSinifi);
                insanErkek.ogunSecimi();
            } else if (insan.getCinsiyet().equalsIgnoreCase("kadın") ||
                    insan.getCinsiyet().equalsIgnoreCase("k") || insan.getCinsiyet().equals("2")) {
                Insan.Kadin insanKadin = insan.new Kadin(sabahYemek, ogleYemek, aksamYemek, kaloriSinifi);
                insanKadin.ogunSecimi();
            }else {
                System.out.println("Geçersiz Cinsiyet.");
            }
        } catch (Exception e) {
            System.out.println("Çok Önemli Hata!!!\n" + "Hata Mesajı: " + e);
        } finally {
            System.out.println("\u001B[31mUygulamayı Tekrar Başlamak İstiyor Musunuz?\tEvet: E - Hayır: H\u001B[0m");//Kırmızı Yazı
            if (scn.nextLine().equalsIgnoreCase("e")) {
                calistir();
            }
        }
    }

    public static void main(String[] args) {
        calistir();
    }

}