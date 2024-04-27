package KiviPaperiSakset;

/**
 * Kivi, paperi, sakset -peli
 * @author Ira Dook
 */
public class Peli {

    private static final int PELI_LOPPUU_VOITOT = 3; // Tarvittava voittojen määrä jotta peli loppuu.

    private final Pelaaja p1;
    private final Pelaaja p2;
    private int erä;
    private int tasapelit;

    /**
     * Peli konstruktori
     */
    public Peli(Pelaaja p1, Pelaaja p2) {
        this.p1 = p1;
        this.p2 = p2;
        erä = 1;
        tasapelit = 0;
    }

    /**
     * Pelaa kivi, paperi, sakset -peli
     */
    public void pelaa() {
        do {
            System.out.println("Erä: " + erä + " =====================\n");

            String p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1Valinta);
            String p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2Valinta);

            kukaVoitti(p1Valinta, p2Valinta);

            erä++;

            if (onkoPeliOhi()) {
                System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");
                System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
                break;
            }
            System.out.println();
        } while (true);
    }

    /**
     * Kuka voitti erän
     * @param p1Valinta pelaajan 1 valinta
     * @param p2Valinta pelaajan 2 valinta
     */
    private void kukaVoitti(String p1Valinta, String p2Valinta) {
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
    }

    /**
     * Onko peli ohi
     * @return true jos jompikumpi pelaajista on saavuttanut tarvittavan määrän voittoja
     */
    public boolean onkoPeliOhi() {
        return p1.getVoitot() >= PELI_LOPPUU_VOITOT || p2.getVoitot() >= PELI_LOPPUU_VOITOT;
    }
}
