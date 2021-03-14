package dev.druid.classwork.classwork8;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA
 * Date: 11.03.2021
 * Time: 4:55 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()!=o2.length()){
            return o1.length()-o2.length();
        }
        return o1.compareTo(o2);
    }
}
