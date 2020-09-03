package aufgabe.zwei;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexTest {

    @Nested
    class Eine_Complex_implementiert_Comparable_mit_korrekter{
        @Test
        void gleichheit(){
            var complex1 = new Complex(1,2);
            var complex2 = new Complex(1,2);

            assertEquals(0,complex1.compareTo(complex2));
        }

        @Test
        void groesser_als(){
            var complex1 = new Complex(3,2);
            var complex2 = new Complex(1,2);

            int result = complex1.compareTo(complex2);

            assertEquals(1,result);
        }

        @Test
        void kleiner_als(){
            var complex1 = new Complex(1,2);
            var complex2 = new Complex(3,2);

            int result = complex1.compareTo(complex2);

            assertEquals(-1,result);
        }
    }
}