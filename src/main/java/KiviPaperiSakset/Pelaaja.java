package KiviPaperiSakset;

import java.util.Random;

/**
 *
 * @author Ira Dook
 */
public class Pelaaja {

    int voitot;      // Voittojen lukumäärä

    /**
     * Valitse randomilla kivi, paperi tai sakset
     */
    public String pelaajanValinta() {
        String[] valinnat = {"kivi", "paperi", "sakset"};
        Random random = new Random();
        int index = random.nextInt(valinnat.length);
        return valinnat[index];
    }

    public void setVoitot() {
        voitot++;
    }

    public int getVoitot() {
        return voitot;
    }
}
