package KiviPaperiSakset;

import java.util.Random;

/**
 * Pelaaja -luokka kivi, paperi, sakset -peliin
 * @author Ira Dook
 */
public class Pelaaja {

    private int voitot;      // Voittojen lukumäärä

    /**
     * Valitse randomilla kivi, paperi tai sakset
     * @return valinta
     */
    public String pelaajanValinta() {
        String[] valinnat = {"kivi", "paperi", "sakset"};
        Random random = new Random();
        int index = random.nextInt(valinnat.length);
        return valinnat[index];
    }

    /**
     * Lisää pelaajalle yksi voitto
     */
    public void lisääVoitto() {
        voitot++;
    }

    /**
     * Hae pelaajan voitot
     * @return voitot
     */
    public int getVoitot() {
        return voitot;
    }
}
