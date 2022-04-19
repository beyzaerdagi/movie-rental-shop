package odev3;

/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */
public abstract class Film {

    private String ad;
    private int id;
    private double ucret;
    private Musteri[] musteriListesi;

    public Film(String ad, int id, double ucret) {
        this.ad = ad;
        this.id = id;
        this.ucret = ucret;
        this.musteriListesi = new Musteri[100];
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUcret() {
        return ucret;
    }

    public void setUcret(double ucret) {
        this.ucret = ucret;
    }

    public Musteri[] getMusteriListesi() {
        return musteriListesi;
    }

    public void setMusteriListesi(Musteri[] musteriListesi) {
        this.musteriListesi = musteriListesi;
    }

    // Filmi kiralayan musterileri yazdiriyorum
    public abstract void musteriListele();
    
    
    public abstract String filmBilgi();
}
