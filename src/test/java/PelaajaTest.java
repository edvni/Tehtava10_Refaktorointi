import KiviPaperiSakset.Pelaaja;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
