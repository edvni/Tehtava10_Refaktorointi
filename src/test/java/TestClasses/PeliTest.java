package TestClasses;

import KiviPaperiSakset.Pelaaja;
import KiviPaperiSakset.Peli;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testaa Peli -luokkaa
 */
public class PeliTest {

    private Peli peli;
    private Pelaaja p1;
    private Pelaaja p2;

    /**
     * Alusta testit: luo kaksi pelaajaa ja peli
     */
    @BeforeEach
    public void setUp() {
        p1 = new Pelaaja();
        p2 = new Pelaaja();
        peli = new Peli(p1, p2);
    }

    /**
     * Testaa pelin kulkua alusta loppuun
     */
    @Test
    public void testPeli() {
        assertFalse(peli.onkoPeliOhi());
        peli.pelaa();
        assertTrue(peli.onkoPeliOhi());
    }
}
