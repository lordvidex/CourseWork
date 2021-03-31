package dev.druid.classwork.classwork13;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Date: 25.03.2021
 * Time: 4:51 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class ContinentMapComparator implements Comparator<Map.Entry<Integer,Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}
