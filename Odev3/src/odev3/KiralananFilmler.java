package odev3;
/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */

// Musterinin kiralama ve iade yaptigi zamanki tarihleri tutmak icin bu sinifi yaptim
public class KiralananFilmler {

    private String tarih;
    private Musteri musteri;
    private Film film;
    private String islemTipi;

    public KiralananFilmler(String tarih, Musteri musteri, Film film,String islemTipi) {
        this.tarih = tarih;
        this.musteri = musteri;
        this.film = film;
        this.islemTipi = islemTipi;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getIslemTipi() {
        return islemTipi;
    }

    public void setIslemTipi(String islemTipi) {
        this.islemTipi = islemTipi;
    }

}
