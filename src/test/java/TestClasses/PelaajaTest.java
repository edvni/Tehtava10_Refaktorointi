package TestClasses;

import KiviPaperiSakset.Pelaaja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testaa Pelaaja -luokkaa
 */
public class PelaajaTest {

    /**
     * Testaa voittojen lisääminen
     */
    @Test
    public void testLisääVoitto() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.lisääVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    /**
     * Testaa pelaajan valinta
     */
    @Test
    public void testPelaajanValinta() {
        Pelaaja pelaaja = new Pelaaja();
        String valinta = pelaaja.pelaajanValinta();
        boolean kivi = valinta.equals("kivi");
        boolean paperi = valinta.equals("paperi");
        boolean sakset = valinta.equals("sakset");
        assertEquals(true, kivi || paperi || sakset);
    }

    /**
     * Testaa voittojen hakeminen kun voitot on nolla
     */
    @Test
    public void testGetVoitotNone() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
    }

    /**
     * Testaa voittojen hakeminen kun voittoja lisätään yksi
     */
    @Test
    public void testGetVoitotYksi() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisääVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    /**
     * Testaa voittojen hakeminen kun voittoja lisätään kaksi
     */
    @Test
    public void testGetVoitotKaksi() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisääVoitto();
        pelaaja.lisääVoitto();
        assertEquals(2, pelaaja.getVoitot());
    }

    /**
     * Testaa voittojen hakeminen kun voittoja lisätään kolme
     */
    @Test
    public void testGetVoitotKolme() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisääVoitto();
        pelaaja.lisääVoitto();
        pelaaja.lisääVoitto();
        assertEquals(3, pelaaja.getVoitot());
    }
}
