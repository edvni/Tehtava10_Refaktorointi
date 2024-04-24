package KiviPaperiSakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        int erä = 1;
        int tasapelit = 0;
       
        do {
            System.out.println("Erä: " + erä + " =====================\n");

            String p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta);
            String p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta);

            if (p1Valinta.equals(p2Valinta)) {
                tasapelit++;
                System.out.println("\n\t\t\t Tasapeli");
            } else if (p1Valinta.equals("kivi") && p2Valinta.equals("sakset")
                    || p1Valinta.equals("paperi") && p2Valinta.equals("kivi")
                    || p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) {
                p1.lisääVoitto();
                System.out.println("\n\tPelaaja 1 voittaa\n\tPelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            } else {
                p2.lisääVoitto();
                System.out.println("\n\tPelaaja 2 voittaa\n\tPelaaja 2:lla koossa " + p2.getVoitot() + " voittoa");
            }

            erä++; // erä pelattu

            if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
                System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
                System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
                break;
            }
            System.out.println();
        } while (true);
    }
}
