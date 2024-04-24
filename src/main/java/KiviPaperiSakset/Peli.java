package KiviPaperiSakset;

import java.sql.SQLOutput;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        int pelatutPelit = 0;
        int tasapelit = 0;
       
        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            String p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            String p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");

            if (p1Valinta.equals(p2Valinta)) {
                tasapelit++;
                System.out.println("\n\t\t\t Tasapeli \n");
            } else if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")
                    || p1Valinta.equals("paperi") && p2Valinta.equals("kivi")
                    || p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
                p1.setVoitot();
                System.out.println("Pelaaja 1 voittaa");
            } else {
                p2.setVoitot();
                System.out.println("Pelaaja 2 voittaa");
            }

            pelatutPelit++;

            if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
                break;
            }
            System.out.println();
        } while (true);
    }
}
