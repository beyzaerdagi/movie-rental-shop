package odev3;
/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */
public class Gerilim extends Film {

    private Musteri[] musteriListesi;

    public Gerilim(String ad, int id, double ucret) {
        super(ad, id, ucret);
        this.musteriListesi = new Musteri[100];
    }

    @Override
    public void musteriListele() {

        for (int i = 0; i < this.getMusteriListesi().length; i++) {
           if (this.getMusteriListesi()[i] != null) {
                System.out.println(getMusteriListesi()[i].musteriBilgi());
                System.out.println("-------------------");
            }
        }
    }

    @Override
    public Musteri[] getMusteriListesi() {
        return musteriListesi;
    }

    @Override
    public void setMusteriListesi(Musteri[] musteriListesi) {
        this.musteriListesi = musteriListesi;
    }

    @Override
    public String filmBilgi() {
         return "Ad:" + this.getAd() + "\t" + "İd:" + this.getId() + "\t" + "Ücret:" + this.getUcret() + "\n";
    }
}
