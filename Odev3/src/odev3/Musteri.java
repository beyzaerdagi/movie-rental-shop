package odev3;

/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */
public class Musteri {

    private String ad;
    private String soyad;
    private int id;
    private int yas;
    private double bakiye;
    private double filmUcretMaliyet;
    private Film[] filmListesi;

    public Musteri(String ad, String soyad, int id, int yas, double bakiye) {
        this.ad = ad;
        this.soyad = soyad;
        this.id = id;
        this.yas = yas;
        this.bakiye = bakiye;
        this.filmListesi = new Film[100];
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public Film[] getFilmListesi() {
        return filmListesi;
    }

    public void setFilmListesi(Film[] filmListesi) {
        this.setFilmListesi(filmListesi);
    }

    public double getFilmUcretMaliyet() {
        return filmUcretMaliyet;
    }

    public void setFilmUcretMaliyet(double filmUcretMaliyet) {
        this.filmUcretMaliyet = filmUcretMaliyet;
    }

    // Musterinin bilgilerini yazdiriyorum
    public String musteriBilgi() {
        return "Ad Soyad:" + this.ad + " " + this.soyad + "\t" + "Yas:" + this.yas + "\t"
                + "Bakiye:" + this.bakiye + "\t" + "FilmÜcretMaliyet:" + this.filmUcretMaliyet + "\n";
    }

}
