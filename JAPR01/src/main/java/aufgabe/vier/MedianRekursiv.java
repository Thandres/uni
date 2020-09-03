package aufgabe.vier;

import java.util.*;
import java.util.stream.Collectors;

public class MedianRekursiv {

  public static final Random RANDOM = new Random();

  public static double fastMedian(List<Double> values, int k) {
    var size = values.size();
    if (size == 1) {
      return values.get(0);
    } else {
      int randomIndex = Math.abs(RANDOM.nextInt()) % size;

      var randomVal = values.get(randomIndex);
      Map<Integer, List<Double>> collect =
          values.stream()
                  .collect(Collectors
                          .groupingBy(aDouble -> aDouble.compareTo(randomVal)));
      List<Double> less = collect.get(-1);
      List<Double> equal = collect.get(0);
      List<Double> greater = collect.get(1);
      if (k <= less.size()) {
        return fastMedian(less, k);
      } else if (k <= less.size() + equal.size()) {
        return randomVal;
      } else {
        int newK = k - less.size() - equal.size();
        return fastMedian(greater, newK);
      }
    }
  }

  public static double fastMedian(Double[] values) {
    int k = (values.length + 1) / 2;
    return fastMedian(Arrays.asList(values), k);
  }
}
