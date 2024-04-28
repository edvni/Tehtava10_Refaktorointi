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
     * Lisää pelaajalle yksi voitto.
     * Pelaajalla voi olla enintään kolme voittoa.
     * Jos pelaajalla on jo kolme voittoa, peli on päättynyt
     * eikä pelaaja ei voi saada enempää voittoja.
     */
    public void lisääVoitto() {
        int maxVoitot = 3;
        if (voitot < maxVoitot) {
            voitot++;
        } else {
            System.out.println("Pelaajalla on jo kolme voittoa! Peli on päättynyt");
        }
    }

    /**
     * Hae pelaajan voitot
     * @return voitot
     */
    public int getVoitot() {
        return voitot;
    }
}
