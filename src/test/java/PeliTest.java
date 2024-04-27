import KiviPaperiSakset.Peli;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeliTest {

    @Test
    public void testPeli() {
        Peli peli = new Peli();
        peli.pelaa();
        assertTrue(peli.onkoPeliOhi());
    }
}
