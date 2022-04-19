package odev3;

/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        dosyaTemizle("C:\\Users\\beyza\\OneDrive\\Documents\\NetBeansProjects\\Odev3\\src\\odev3\\filmKiralamaLogFile.txt");

        Musteri m1 = new Musteri("Burcu", "Kambur", 3434, 22, 200) {
        };
        Musteri m2 = new Musteri("Ahmet", "Can", 5678, 32, 150) {
        };
        Musteri m3 = new Musteri("Eray", "Aslan", 4578, 25, 50) {
        };

        Film kor1 = new Korku("Korku Seansı", 48759, 40);
        Film kor2 = new Korku("Halka", 4657, 50);

        Film b1 = new BilimKurgu("Geleceğe Dönüş", 2345, 40);
        Film b2 = new BilimKurgu("Yıldızlararası", 6879, 50);
        Film b3 = new BilimKurgu("Başlangıç", 9879, 60);

        Film g1 = new Gerilim("Prestij", 4657, 50);
        Film g2 = new Gerilim("Olağan Şüpheliler", 8097, 45);
        Film g3 = new Gerilim("Kuzuların Sessizliği", 23436, 60);
        Film g4 = new Gerilim("Kanlı Elmas", 4565, 35);

        Film kom1 = new Komedi("3 Aptal", 4546, 35);
        Film kom2 = new Komedi("Evde Tek Başına", 3546, 45);

        Film r1 = new Romantik("Gurur ve Önyargı", 3556, 65);
        Film r2 = new Romantik("Not Defteri", 3546, 60);
        Film r3 = new Romantik("Aynı Yıldızın Altında", 43657, 45);

        Magaza m = new Magaza("FilmKirala");

        m.musteriEkle(m1);
        m.musteriEkle(m2);
        m.musteriEkle(m3);

        m.filmEkle(kor1);
        m.filmEkle(kor2);
        m.filmEkle(b1);
        m.filmEkle(b2);
        m.filmEkle(b3);
        m.filmEkle(g1);
        m.filmEkle(g2);
        m.filmEkle(g3);
        m.filmEkle(g4);
        m.filmEkle(kom1);
        m.filmEkle(kom2);
        m.filmEkle(r1);
        m.filmEkle(r2);
        m.filmEkle(r3);

        String[] secenekler = {"1.Film kirala\n", "2.Film geri ver\n", "3.Mağazadaki film sayısı\n", "4.Film sil\n",
            "5.Müşteri sil\n", "6.Belirli tarih arası filmleri listele\n", "7.Özel müşteriler\n",
            "8.En çok film alan müşteri\n", "9.Müşterinin filmlerini listele\n", "10.Filmin kimler tarafından kiralandığını listele\n"};

        Scanner in = new Scanner(System.in);
        boolean menuKontrol = true; // Cikis yaptiktan sonra donguye tekrar girmemesi icin boolean ile kontrol ediyorum.
        while (menuKontrol) {
            System.out.println("1.Uygulamayi calistir");
            System.out.println("2.Çıkış");
            System.out.print("Secenek: ");
            String secenek = in.next();
            if (StringToNumber(secenek) < 1 || StringToNumber(secenek) > 2) {
                System.out.println("Lütfen 1 ya da 2 yi seçiniz");
                System.out.print("Secenek: ");
                secenek = in.next();
            }
            if (StringToNumber(secenek) == 2) {
                System.out.println("İyi günler..");
                menuKontrol = false;
            } else if (StringToNumber(secenek) == 1) {
                System.out.println();
                m.filmListele();
                System.out.println();
                for (int i = 0; i < secenekler.length; i++) {
                    System.out.print(secenekler[i]);
                }
                System.out.print("Seçenek: ");
                String secenekMagaza = in.next();
                if (StringToNumber(secenekMagaza) < 1 || StringToNumber(secenekMagaza) > 10) {
                    System.out.println("Lütfen 1 ile 9 arasında bir rakam seçiniz");
                    System.out.print("Seçenek: ");
                    secenekMagaza = in.next();
                }
                if (StringToNumber(secenekMagaza) == 1) {
                    m.musteriListele();
                    System.out.print("Lütfen bir müşteri seçiniz: ");
                    String secenekMusteri = in.next();
                    if (StringToNumber(secenekMusteri) < 1 || StringToNumber(secenekMusteri) > 3) {
                        System.out.println("Lütfen 1 ile 3 arasında bir rakam seçiniz.");
                        System.out.print("Lütfen bir müşteri seçiniz: ");
                        secenekMusteri = in.next();
                    }
                    System.out.print("Kiralamak istediğiniz filmi seçin: ");
                    String film = in.next();
                    if (StringToNumber(film) < 1 || StringToNumber(film) > 14) {
                        System.out.println("Lütfen 1 ile 14 arasında bir sayı seçiniz.");
                        System.out.print("Kiralamak istediğiniz filmi seçin: ");
                        film = in.next();
                    }
                    System.out.print("Tarihi giriniz: ");
                    String tarih = in.next();
                    boolean tarihKontrol = true; // Girilen tarihin kontrolunu yaptiktan sonra donguden cikmak icin yaptim.
                    while (tarihKontrol) {
                        if (!(tarihKontrol(tarih))) {
                            System.out.println("Lütfen tarihi gg.aa.yyyy şeklinde giriniz");
                            System.out.print("Tarihi giriniz: ");
                            tarih = in.next();
                        } else {
                            tarihKontrol = false;
                        }
                    }
                    for (int i = 0; i < m.getFilmListesi().length; i++) {
                        if (m.getFilmListesi()[i] != null) {
                            for (int j = 0; j < m.getMusteriListesi().length; j++) {
                                if (m.getMusteriListesi()[j] != null) {
                                    if (i + 1 == StringToNumber(film) && j + 1 == StringToNumber(secenekMusteri)) {
                                        m.filmKirala(m.getFilmListesi()[i], m.getMusteriListesi()[j], tarih);
                                    }
                                }
                            }
                        }
                    }
                } else if (StringToNumber(secenekMagaza) == 2) {
                    m.musteriListele();
                    System.out.print("Lütfen bir müşteri seçiniz: ");
                    String secenekMusteri = in.next();
                    if (StringToNumber(secenekMusteri) < 1 || StringToNumber(secenekMusteri) > 3) {
                        System.out.println("Lütfen 1 ile 3 arasında bir rakam seçiniz.");
                        System.out.print("Lütfen bir müşteri seçiniz: ");
                        secenekMusteri = in.next();
                    }
                    System.out.print("Geri vermek istediğiniz filmi seçin: ");
                    String film = in.next();
                    if (StringToNumber(film) < 1 || StringToNumber(film) > 14) {
                        System.out.println("Lütfen 1 ile 14 arasında bir sayı seçiniz.");
                        System.out.print("Geri vermek istediğiniz filmi seçin: ");
                        film = in.next();
                    }
                    System.out.print("Tarihi giriniz: ");
                    String tarih = in.next();
                    boolean tarihKontrol = true; // Girilen tarihin kontrolunu yaptiktan sonra donguden cikmak icin yaptim.
                    while (tarihKontrol) {
                        if (!(tarihKontrol(tarih))) {
                            System.out.println("Lütfen tarihi gg.aa.yyyy şeklinde giriniz");
                            System.out.print("Tarihi giriniz: ");
                            tarih = in.next();
                        } else {
                            tarihKontrol = false;
                        }
                    }
                    for (int i = 0; i < m.getFilmListesi().length; i++) {
                        if (m.getFilmListesi()[i] != null) {
                            for (int j = 0; j < m.getMusteriListesi().length; j++) {
                                if (m.getMusteriListesi()[j] != null) {
                                    if (i + 1 == StringToNumber(film) && j + 1 == StringToNumber(secenekMusteri)) {
                                        m.filmGeriVer(m.getFilmListesi()[i], m.getMusteriListesi()[j], tarih);
                                    }
                                }
                            }
                        }
                    }
                } else if (StringToNumber(secenekMagaza) == 3) {
                    m.filmSayma();
                } else if (StringToNumber(secenekMagaza) == 4) {
                    System.out.print("Silmek istediğiniz filmi seçiniz: ");
                    String secenekFilmSil = in.next();
                    if (StringToNumber(secenekFilmSil) < 1 || StringToNumber(secenekFilmSil) > 14) {
                        System.out.println("Lütfen 1 ile 14 arasında bir sayı seçiniz.");
                        System.out.print("Silmek istediğiniz filmi seçiniz: ");
                        secenekFilmSil = in.next();
                    }
                    for (int i = 0; i < m.getFilmListesi().length; i++) {
                        if (m.getFilmListesi()[i] != null) {
                            if (i + 1 == StringToNumber(secenekFilmSil)) {
                                m.filmSilme(m.getFilmListesi()[i]);
                            }
                        }
                    }
                } else if (StringToNumber(secenekMagaza) == 5) {
                    System.out.print("Silmek istediğiniz müşteriyi seçiniz: ");
                    String secenekMusteriSil = in.next();
                    if (StringToNumber(secenekMusteriSil) < 1 || StringToNumber(secenekMusteriSil) > 3) {
                        System.out.println("Lütfen 1 ile 3 arasında bir sayı seçiniz.");
                        System.out.print("Silmek istediğiniz müşteriyi seçiniz: ");
                        secenekMusteriSil = in.next();
                    }
                    for (int i = 0; i < m.getMusteriListesi().length; i++) {
                        if (m.getMusteriListesi()[i] != null) {
                            if (i + 1 == StringToNumber(secenekMusteriSil)) {
                                m.musteriSilme(m.getMusteriListesi()[i], "11.01.2021");
                            }
                        }
                    }
                } else if (StringToNumber(secenekMagaza) == 6) {
                    System.out.print("Başlangıç tarihi giriniz: ");
                    String basTarih = in.next();
                    boolean basTarihKontrol = true; // Girilen tarihin kontrolunu yaptiktan sonra donguden cikmak icin yaptim.
                    while (basTarihKontrol) {
                        if (!(tarihKontrol(basTarih))) {
                            System.out.println("Lütfen tarihi gg.aa.yyyy şeklinde giriniz");
                            System.out.print("Başlangıç tarihi giriniz: ");
                            basTarih = in.next();
                        } else {
                            basTarihKontrol = false;
                        }
                    }
                    System.out.print("Bitiş tarihi giriniz: ");
                    String bitTarih = in.next();
                    boolean bitTarihKontrol = true; // Girilen tarihin kontrolunu yaptiktan sonra donguden cikmak icin yaptim.
                    while (bitTarihKontrol) {
                        if (!(tarihKontrol(bitTarih))) {
                            System.out.println("Lütfen tarihi gg.aa.yyyy şeklinde giriniz");
                            System.out.print("Bitiş tarihi giriniz: ");
                            bitTarih = in.next();
                        } else {
                            bitTarihKontrol = false;
                        }
                    }
                    basTarih = basTarih.replace(".", ""); // Tarihi 'replace' metodunu kullanarak '.' ları silerek bir string e donusturdum.
                    bitTarih = bitTarih.replace(".", "");
                    int basTrh = Integer.parseInt(basTarih); // 'replace' metodunu kullandiktan sonra olusan stringi sayiya cevirdim.
                    int bitTrh = Integer.parseInt(bitTarih);
                    boolean buyuklukKontrol = true; // Tarihlerin buyukluk kontrolunu yaptiktan sonra donguden cikmak icin yaptim.
                    while (buyuklukKontrol) {
                        if (basTrh > bitTrh) {
                            System.out.println("Başlangıç tarihi bitiş tarihinden büyük olamaz");
                            System.out.print("Başlangıç tarihi giriniz: ");
                            basTarih = in.next();
                            basTarihKontrol = true;
                            while (basTarihKontrol) {
                                if (!(tarihKontrol(basTarih))) {
                                    System.out.println("Lütfen tarihi gg.aa.yyyy şeklinde giriniz");
                                    System.out.print("Başlangıç tarihi giriniz: ");
                                    basTarih = in.next();
                                } else {
                                    basTarihKontrol = false;
                                }
                            }
                        } else if (bitTrh < basTrh) {
                            System.out.println("Bitiş tarihi başlangıç tarihinden küçük olamaz");
                            System.out.print("Bitiş tarihi giriniz: ");
                            bitTarih = in.next();
                            bitTarihKontrol = true;
                            while (bitTarihKontrol) {
                                if (!(tarihKontrol(bitTarih))) {
                                    System.out.println("Lütfen tarihi gg.aa.yyyy şeklinde giriniz");
                                    System.out.print("Bitiş tarihi giriniz: ");
                                    bitTarih = in.next();
                                } else {
                                    bitTarihKontrol = false;
                                }
                            }
                        } else {
                            buyuklukKontrol = false;
                        }
                    }
                    m.belirliTarihArası(basTarih, bitTarih);
                } else if (StringToNumber(secenekMagaza) == 7) {
                    m.ozelMusteriler();
                } else if (StringToNumber(secenekMagaza) == 8) {
                    m.enCokFilmAlanMusteri();
                } else if (StringToNumber(secenekMagaza) == 9) {
                    System.out.print("Filmlerinin listelenmesini istediğiniz müşteriyi seçiniz: ");
                    String istenenMusteri = in.next();
                    if (StringToNumber(istenenMusteri) < 1 || StringToNumber(istenenMusteri) > 3) {
                        System.out.println("Lütfen 1 ile 3 arasında bir sayı seçiniz.");
                        System.out.print("Silmek istediğiniz müşteriyi seçiniz: ");
                        istenenMusteri = in.next();
                    }
                    for (int i = 0; i < m.getMusteriListesi().length; i++) {
                        if (m.getMusteriListesi()[i] != null) {
                            if (i + 1 == StringToNumber(istenenMusteri)) {
                                m.musteriFilmListele(m.getMusteriListesi()[i]);
                            }
                        }
                    }
                } else if (StringToNumber(secenekMagaza) == 10) {
                    System.out.print("Müşterilerinin listelenmesini istediğiniz filmi seçiniz: ");
                    String istenenFilm = in.next();
                    if (StringToNumber(istenenFilm) < 1 || StringToNumber(istenenFilm) > 14) {
                        System.out.println("Lütfen 1 ile 14 arasında bir sayı seçiniz.");
                        System.out.print("Müşterilerinin listelenmesini istediğiniz filmi seçiniz: ");
                        istenenFilm = in.next();
                    }
                    for (int i = 0; i < m.getFilmListesi().length; i++) {
                        if (m.getFilmListesi()[i] != null) {
                            if (i + 1 == StringToNumber(istenenFilm)) {
                                m.getFilmListesi()[i].musteriListele();
                            }
                        }
                    }
                }
            }
        }
        System.out.println("----------Yapılan İşlemler-----------");
        DosyaIslemleri.dosyaOku("C:\\Users\\beyza\\OneDrive\\Documents\\NetBeansProjects\\Odev3\\src\\odev3\\filmKiralamaLogFile.txt");
        System.out.println("-------------------------------------");
    }

    public static int StringToNumber(String tmp) {
        // String olarak alinan sayilari integer a cevirmek icin bu methodu yaptim.
        int toplam = 0;
        int basamak = 1;
        for (int i = tmp.length() - 1; i >= 0; i--) {
            toplam += (tmp.charAt(i) - '0') * basamak;
            basamak *= 10;
        }
        return toplam;
    }

    public static boolean tarihKontrol(String tarih) {
        // Tarih kontrolunu 'gg.aa.yyyy' bicimine gore yaptim.
        if (tarih.length() != 10) {
            return false;
        }
        for (int i = 0; i < tarih.length(); i++) {
            if (i == 2 || i == 5) {
                if (tarih.charAt(i) < '.' || tarih.charAt(i) > '9') {
                    return false;
                }
            } else {
                if (tarih.charAt(i) < '0' || tarih.charAt(i) > '9') {
                    return false;
                }
            }
            if (i == 0) {
                if (tarih.charAt(i) == '3') {
                    if (tarih.charAt(i + 1) == '1') {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (tarih.charAt(i) > '/' && tarih.charAt(i) < '3') {
                    continue;
                } else {
                    return false;
                }
            }
            if (i == 2) {
                if (tarih.charAt(i) != '.') {
                    return false;
                }
            }
            if (i == 3) {
                if (tarih.charAt(i) == '1') {
                    if (tarih.charAt(i + 1) > '/' && tarih.charAt(i + 1) < '3') {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (tarih.charAt(i) == '0' || tarih.charAt(i) == '1') {
                    continue;
                } else {
                    return false;
                }
            }
            if (i == 5) {
                if (tarih.charAt(i) != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void dosyaTemizle(String dosyaAd) throws IOException {
        FileWriter writer = new FileWriter(new File(dosyaAd));
        writer.close();
    }
}
