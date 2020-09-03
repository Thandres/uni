package aufgabe.eins;
import aufgabe.eins.Bruch;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruchTest {

  @Nested
  class Ein_Bruch {
    @Nested
    class hat_einen_Kontruktor_mit {

      @Test
      void zaehler_und_nenner_ohne_0_im_nenner() {
        int i1 = 2;
        int i2 = 4;

        Bruch result = new Bruch(i1, i2);

        assertThrows(IllegalArgumentException.class,()-> new Bruch(1,0));
      }

      @Test
      void nur_zaehler() {
        int zaehler = 4;

        Bruch result = new Bruch(zaehler);
      }
    }

    @Test
    void kann_mit_anderen_bruechen_addiert_werden() {
      var bruch1 = new Bruch(4);
      var bruch2 = new Bruch(4, 3);

      Bruch result = bruch1.add(bruch2);

      assertNotNull(result);
      assertEquals("Zähler: 16, Nenner: 3", result.toString());
    }

    @Test
    void kann_mit_anderen_bruechen_multipliziert_werden() {
      var bruch1 = new Bruch(8, 10);
      var bruch2 = new Bruch(4, 3);

      Bruch result = bruch1.multiply(bruch2);

      assertNotNull(result);
      assertEquals("Zähler: 16, Nenner: 15", result.toString());
    }

    @Test
    void gibt_seinen_wert_mit_toString_vollstaendig_gekuerzt_aus() {
      int i1 = 2;
      int i2 = 4;
      Bruch bruch = new Bruch(i1, i2);

      String result = bruch.toString();

      assertEquals("Zähler: 1, Nenner: 2", result);
    }
  }
}
