package ru.kpfu.SecondControlWork;

/**
 * Created by IntelliJ IDEA
 * Date: 26.12.2020
 * Time: 20:35
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
//.........5...............
public interface Measurable {
    double getMeasure();

    static double getAverage(Measurable[] list) {
        double total = 0;
        for (Measurable m : list) {
            total += m.getMeasure();
        }
        return total / list.length;
    }

    static double getMaximum(Measurable[] list) {
        double max = 0;
        for (Measurable m : list) {
            if (m.getMeasure() > max) {
                max = m.getMeasure();
            }
        }
        return max;
    }

    static double getMinimum(Measurable[] list) {
        double min = Double.MAX_VALUE;
        for (Measurable m : list) {
            if (m.getMeasure() < min) {
                min = m.getMeasure();
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }

    default boolean isGreaterThan(Measurable other) {
        return this.getMeasure()>other.getMeasure();
    }
}
