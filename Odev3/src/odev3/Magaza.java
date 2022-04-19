package odev3;

import java.io.IOException;

/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */
public class Magaza implements OzelMusteriler {

    private String ad;
    private Film[] filmListesi;
    private Musteri[] musteriListesi;
    private KiralananFilmler[] kiralananFilmler;

    public Magaza(String ad) {
        this.ad = ad;
        this.filmListesi = new Film[100];
        this.musteriListesi = new Musteri[100];
        this.kiralananFilmler = new KiralananFilmler[100];
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Film[] getFilmListesi() {
        return filmListesi;
    }

    public void setFilmListesi(Film[] filmListesi) {
        this.setFilmListesi(filmListesi);
    }

    public Musteri[] getMusteriListesi() {
        return musteriListesi;
    }

    public void setMusteriListesi(Musteri[] musteriListesi) {
        this.setMusteriListesi(musteriListesi);
    }

    public KiralananFilmler[] getKiralananFilmler() {
        return kiralananFilmler;
    }

    public void setKiralananFilmler(KiralananFilmler[] kiralananFilmler) {
        this.kiralananFilmler = kiralananFilmler;
    }

    // Magazaya film ekliyorum
    public void filmEkle(Film film) throws IOException {
        for (int i = 0; i < getFilmListesi().length; i++) {
            if (getFilmListesi()[i] == null) {
                getFilmListesi()[i] = film;
                DosyaIslemleri.dosyayaEkle(getFilmListesi()[i].filmBilgi(), "film eklendi");
                break;
            }
        }
    }

    // Magazaya musteri ekliyorum
    public void musteriEkle(Musteri musteri) throws IOException {
        for (int i = 0; i < getMusteriListesi().length; i++) {
            if (getMusteriListesi()[i] == null) {
                getMusteriListesi()[i] = musteri;
                DosyaIslemleri.dosyayaEkle(getMusteriListesi()[i].musteriBilgi(),"müşteri eklendi");
                break;
            }
        }
    }

    // Test sınıfında filmleri listeliyorum
    public void filmListele() {
        for (int i = 0; i < getFilmListesi().length; i++) {
            if (getFilmListesi()[i] != null) {
                System.out.println((i + 1) + ":Film adı: " + getFilmListesi()[i].getAd() + " ,Film ücreti: " + getFilmListesi()[i].getUcret());
            }
        }
    }

    // Test sınıfında musterileri listeliyorum
    public void musteriListele() {
        for (int i = 0; i < getMusteriListesi().length; i++) {
            if (getMusteriListesi()[i] != null) {
                System.out.println((i + 1) + ":Müşteri adı soyadı: " + getMusteriListesi()[i].getAd() + " " + getMusteriListesi()[i].getSoyad()
                        + " ,Yaş: " + getMusteriListesi()[i].getYas() + " ,Id: " + getMusteriListesi()[i].getId()
                        + " ,Bakiye: " + getMusteriListesi()[i].getBakiye());
            }
        }
    }

    public void filmKirala(Film film, Musteri musteri, String tarih) throws IOException {
        for (int i = 0; i < getFilmListesi().length; i++) {
            if (getFilmListesi()[i] != null && getFilmListesi()[i].equals(film)) {
                for (int j = 0; j < musteri.getFilmListesi().length; j++) {
                    if (musteri.getFilmListesi()[j] == null && getKiralananFilmler()[j] == null) {
                        if (musteri.getBakiye() >= film.getUcret()) {
                            getKiralananFilmler()[j] = new KiralananFilmler(tarih, musteri, film, "kiralandı");
                            musteri.getFilmListesi()[j] = film;
                            film.getMusteriListesi()[j] = musteri;
                            musteri.setBakiye(musteri.getBakiye() - film.getUcret());
                            musteri.setFilmUcretMaliyet(musteri.getFilmUcretMaliyet() + film.getUcret());
                            DosyaIslemleri.dosyayaEkle("Müşteri ad soyad: " + musteri.getAd() + " " + musteri.getSoyad() + ", Film adı: " + film.getAd() + "\n", "film kiralandı");
                            break;
                        }
                    }
                }
            }
        }
    }

    public void filmGeriVer(Film film, Musteri musteri, String tarih) throws IOException {
        for (int i = 0; i < musteri.getFilmListesi().length; i++) {
            if (musteri.getFilmListesi()[i] != null && musteri.getFilmListesi()[i].equals(film)) {
                musteri.getFilmListesi()[i] = null;
                film.getMusteriListesi()[i] = null;
                for (int j = 0; j < getKiralananFilmler().length; j++) {
                    if (getKiralananFilmler()[j] == null) {
                        getKiralananFilmler()[j] = new KiralananFilmler(tarih, musteri, film, "iade");
                        DosyaIslemleri.dosyayaEkle("Müşteri ad soyad: " + musteri.getAd() + " " + musteri.getSoyad() + ", Film adı: " + film.getAd() + "\n", "film iade edildi");
                        break;
                    }
                }
            }
        }
    }

    public void filmSayma() {

        int gerilim = 0;
        int korku = 0;
        int komedi = 0;
        int romantik = 0;
        int bilimKurgu = 0;

        for (int i = 0; i < getFilmListesi().length; i++) {
            if (getFilmListesi()[i] != null) {
                if (getFilmListesi()[i] instanceof Korku) {
                    korku++;
                } else if (getFilmListesi()[i] instanceof Gerilim) {
                    gerilim++;
                } else if (getFilmListesi()[i] instanceof Komedi) {
                    komedi++;
                } else if (getFilmListesi()[i] instanceof Romantik) {
                    romantik++;
                } else if (getFilmListesi()[i] instanceof BilimKurgu) {
                    bilimKurgu++;
                }
            }
        }
        System.out.println("Gerilim film sayısı: " + gerilim);
        System.out.println("Korku film sayısı: " + korku);
        System.out.println("Komedi film sayısı: " + komedi);
        System.out.println("Romantik film sayısı: " + romantik);
        System.out.println("Bilim kurgu film sayısı: " + bilimKurgu);
    }

    public void musteriFilmListele(Musteri musteri) {
        for (int i = 0; i < getKiralananFilmler().length; i++) {
            if (getKiralananFilmler()[i] != null && getKiralananFilmler()[i].getMusteri().equals(musteri)
                    // Musterinin iade yaparken kiralananfilmler listeme 'iade' olarak tekrar ekledigim icin 
                    //iki kere yazmaması icin sadece kiralananları yazdırıyorum
                    && getKiralananFilmler()[i].getIslemTipi().equals("kiralandı")) {
                System.out.println("Film adı: " + getKiralananFilmler()[i].getFilm().getAd());
            }
        }
    }

    public void enCokFilmAlanMusteri() {
        int max = 0;
        int index = -1;
        for (int i = 0; i < getMusteriListesi().length; i++) {
            if (getMusteriListesi()[i] != null) {
                int sayi = 0;
                for (int j = 0; j < getMusteriListesi()[i].getFilmListesi().length; j++) {
                    if (getMusteriListesi()[i].getFilmListesi()[j] != null) {
                        sayi++;
                    }
                }
                if (sayi != 0 && sayi > max) {
                    max = sayi;
                    index = i;
                }
            }
        }
        if (index != -1) {
            System.out.println("En çok film kiralayan kişi:");
            System.out.println(getMusteriListesi()[index].musteriBilgi());
            System.out.print("Kiraladığı filmler: ");
            for (int i = 0; i < getMusteriListesi()[index].getFilmListesi().length; i++) {
                if (getMusteriListesi()[index].getFilmListesi()[i] != null) {
                    System.out.print(getMusteriListesi()[index].getFilmListesi()[i].getAd()
                            + (i < getMusteriListesi()[index].getFilmListesi().length - 1 ? "," : ""));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void ozelMusteriler() {
        // 5. madde icin yaptigim interface deki metodu override ettim.
        int toplam = 0;
        for (int i = 0; i < getMusteriListesi().length; i++) {
            if (getMusteriListesi()[i] != null) {
                for (int j = 0; j < getMusteriListesi()[i].getAd().length(); j++) {
                    if (getMusteriListesi()[i].getAd().charAt(0) == 'A') {
                        if (getMusteriListesi()[i].getAd().charAt(j) == 'H' || getMusteriListesi()[i].getAd().charAt(j) == 'h'
                                || getMusteriListesi()[i].getAd().charAt(j) == 'M' || getMusteriListesi()[i].getAd().charAt(j) == 'm') {
                            if (getMusteriListesi()[i].getAd().charAt(getMusteriListesi()[i].getAd().length() - 1) == 'e'
                                    || getMusteriListesi()[i].getAd().charAt(getMusteriListesi()[i].getAd().length() - 1) == 't') {
                                toplam += getMusteriListesi()[i].getFilmUcretMaliyet();
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (toplam != 0) {
            System.out.println("Özel müşterilerin filmlere harcadıkları toplam maliyetleri: " + toplam);
        }
    }

    public void filmSilme(Film film) throws IOException {
        for (int i = 0; i < getFilmListesi().length; i++) {
            if (getFilmListesi()[i] != null && getFilmListesi()[i].equals(film)) {
                for (int j = 0; j < film.getMusteriListesi().length; j++) {
                    if (film.getMusteriListesi()[j] != null) {
                        if (film.getMusteriListesi()[j].getFilmListesi()[j] != null && film.getMusteriListesi()[j].getFilmListesi()[j].equals(film)) {
                            System.out.println(film.getAd() + " filmi silindi film ücreti bakiyenize geri yüklendi.");
                            film.getMusteriListesi()[j].getFilmListesi()[j] = null;
                            if (getKiralananFilmler()[j] != null && getKiralananFilmler()[j].getFilm().getAd().equals(film.getAd())) {
                                getKiralananFilmler()[j] = null;
                            }
                            // Silinen film eger bir musteriye kiralanmıssa bakiyesine ucreti geri yukluyorum
                            film.getMusteriListesi()[j].setBakiye(film.getMusteriListesi()[j].getBakiye() + film.getUcret());
                            film.getMusteriListesi()[j].setFilmUcretMaliyet(film.getMusteriListesi()[j].getFilmUcretMaliyet() - film.getUcret());
                        }
                    }
                }
                DosyaIslemleri.dosyayaEkle(film.filmBilgi(), "film silindi");
                getFilmListesi()[i] = null;
            }
        }
    }

    public void musteriSilme(Musteri musteri, String tarih) throws IOException {
        for (int i = 0; i < getMusteriListesi().length; i++) {
            if (getMusteriListesi()[i] != null && getMusteriListesi()[i].equals(musteri)) {
                for (int j = 0; j < getMusteriListesi()[i].getFilmListesi().length; j++) {
                    if (getMusteriListesi()[i].getFilmListesi()[j] != null) {
                        System.out.println("Aktif olarak kiralanmış filminiz bulunmaktadır.Başka bir müşteriye devredilmiştir.");
                        filmTransfer(getMusteriListesi()[i], getMusteriListesi()[i].getFilmListesi()[j], tarih);
                        if (getKiralananFilmler()[j] != null && getKiralananFilmler()[j].getMusteri().equals(getMusteriListesi()[i])) {
                            getKiralananFilmler()[j] = null;
                        }
                        if (getMusteriListesi()[i].getFilmListesi()[j].getMusteriListesi()[j] != null
                                && getMusteriListesi()[i].getFilmListesi()[j].getMusteriListesi()[j].equals(musteri)) {
                            getMusteriListesi()[i].getFilmListesi()[j].getMusteriListesi()[j] = null;
                        }
                    }
                }
                DosyaIslemleri.dosyayaEkle(musteri.musteriBilgi(), "müşteri silindi");
                getMusteriListesi()[i] = null;
                
            }
        }
    }

    // Silinen musterinin aktif kiralanmis filmi varsa baska bir musteriye aktariyorum
    public void filmTransfer(Musteri musteri, Film film, String tarih) throws IOException {
        for (int i = 0; i < getMusteriListesi().length; i++) {
            if (getMusteriListesi()[i] != null && !(getMusteriListesi()[i].equals(musteri))) {
                if (getMusteriListesi()[i].getFilmListesi()[i] != null && !(getMusteriListesi()[i].getFilmListesi()[i].equals(film))) {
                    filmKirala(film, getMusteriListesi()[i], tarih);
                    break;
                } else if (getMusteriListesi()[i].getFilmListesi()[i] == null) {
                    filmKirala(film, getMusteriListesi()[i], tarih);
                    break;
                }
            }
        }
    }

    public void belirliTarihArası(String basTarih, String bitTarih) {

        basTarih = basTarih.replace(".", ""); // Tarihi 'replace' metodunu kullanarak '.' ları silerek bir string e donusturdum.
        bitTarih = bitTarih.replace(".", "");
        int basTrh = Integer.parseInt(basTarih); // 'replace' metodunu kullandiktan sonra olusan stringi sayiya cevirdim.
        int bitTrh = Integer.parseInt(bitTarih);

        for (int i = 0; i < getKiralananFilmler().length; i++) {
            if (getKiralananFilmler()[i] != null && getKiralananFilmler()[i].getIslemTipi().equals("kiralandı")) {
                String tmp = getKiralananFilmler()[i].getTarih().replace(".", "");
                int kiralananTarih = Integer.parseInt(tmp);
                if (kiralananTarih >= basTrh && kiralananTarih <= bitTrh) {
                    System.out.println(getKiralananFilmler()[i].getFilm().getAd() + " filmi "
                            + getKiralananFilmler()[i].getMusteri().getAd() + " isimli müşteriye kiralanmıştır.");
                }
            }
        }
    }
}
