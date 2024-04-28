package TestClasses;

import KiviPaperiSakset.Pelaaja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testaa Pelaaja -luokkaa
 */
public class PelaajaTest {

    /**
     * Testaa voittojen lisääminen Pelaaja -oliolle
     * Voittojen määrän tulee olla yksi lisäämisen jälkeen
     */
    @Test
    public void testLisääVoitto() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.lisääVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    /**
     * Testaa Pelaaja -olion valintametodia
     * Valinnan tulee olla joko "kivi", "paperi" tai "sakset"
     * Testi ei ole täysin luotettava, koska valinta on satunnainen
     * ja voi olla mikä tahansa kolmesta vaihtoehdosta
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
     * Testaa voittojen lisääminen Pelaaja -oliolle kun voittoja on alle kolme
     */
    @Test public void testLisääVoittoKunVoitotAlleKolme() {
        Pelaaja pelaaja = new Pelaaja();
        int maxVoitot = 3;
        for (int i = 0; i < maxVoitot - 1; i++) {
            pelaaja.lisääVoitto();
            assertEquals(i + 1, pelaaja.getVoitot());
        }
    }

    /**
     * Testaa voittojen lisääminen Pelaaja -oliolle kun voittoja on kolme
     */
    @Test
    public void testLisääVoittoKunVoitotKolme() {
        Pelaaja pelaaja = new Pelaaja();
        int maxVoitot = 3;
        for (int i =  0; i < maxVoitot; i++) {
            pelaaja.lisääVoitto();
        }
        pelaaja.lisääVoitto();
        assertEquals(maxVoitot, pelaaja.getVoitot());
    }

    /**
     * Testaa Pelaaja -olion voittojen hakeminen kun voitot on nolla
     * Voittojen määrän tulee olla nolla
     */
    @Test
    public void testGetVoitotNone() {
        Pelaaja pelaaja = new Pelaaja();
        assertEquals(0, pelaaja.getVoitot());
    }

    /**
     * Testaa Pelaaja -olion voittojen hakeminen kun voitot on yksi
     * Voittojen määrän tulee olla yksi
     */
    @Test
    public void testGetVoitotYksi() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisääVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    /**
     * Testaa Pelaaja -olion voittojen hakeminen kun voitot on kaksi
     * Voittojen määrän tulee olla kaksi
     */
    @Test
    public void testGetVoitotKaksi() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisääVoitto();
        pelaaja.lisääVoitto();
        assertEquals(2, pelaaja.getVoitot());
    }

    /**
     * Testaa Pelaaja -olion voittojen hakeminen kun voitot on kolme
     * Voittojen määrän tulee olla kolme
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
