package odev3;
/**
 * @file Odev3
 * @description Film Kiralama Magazasi
 * @date 25.01.2021
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DosyaIslemleri {

    public static void dosyaOku(String dosyaAd) throws FileNotFoundException {

        Scanner in = new Scanner(new File(dosyaAd));
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
        in.close();
    }

    public static void dosyayaEkle(String metin, String islemTipi) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = now.format(dtf);
        String strToAppend = date + "\t" + islemTipi + "\t" + metin;

        FileWriter writer = new FileWriter(new File("C:\\Users\\beyza\\OneDrive\\Documents\\NetBeansProjects\\Odev3\\src\\odev3\\filmKiralamaLogFile.txt"), true);
        writer.append(strToAppend);
        writer.close();
    }
}
