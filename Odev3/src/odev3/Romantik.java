/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev3;

/**
 *
 * @author beyza
 */
public class Romantik extends Film {

    private Musteri[] musteriListesi;

    public Romantik(String ad, int id, double ucret) {
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
