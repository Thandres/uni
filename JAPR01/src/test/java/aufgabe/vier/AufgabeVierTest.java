package aufgabe.vier;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AufgabeVierTest {


    @Test
    void fastMedian_liefert_das_gleiche_ergebnis(){
        int size = 1001;
        Random random = new Random();
        Double[] values = new Double[size];
        for(int i = 0; i<size;i++){
            values[i]= random.nextDouble();
        }
        assertEquals(SlowMedian.median(values),MedianRekursiv.fastMedian(values));
    }
}