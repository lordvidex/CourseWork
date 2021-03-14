package dev.druid.classwork.classwork8;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA
 * Date: 11.03.2021
 * Time: 4:56 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public record DoubleComparator(double epsilon) implements Comparator<Double> {

    //epsilon = 0.00001
    // a = 1.543214
    // b = 1.543217
    // a should be equal to b
    @Override
    public int compare(Double o1, Double o2) {
        double difference = Math.abs(o1 - o2);
        if (difference < epsilon) {
            return 0;
        }
        return Double.compare(o1, o2);
    }
}
