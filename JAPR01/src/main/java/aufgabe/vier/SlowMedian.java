package aufgabe.vier;

import java.util.Arrays;

public class SlowMedian {
    public static double median(Double[] values){
    Arrays.sort(values);
    return values[values.length/2];
    }

}
