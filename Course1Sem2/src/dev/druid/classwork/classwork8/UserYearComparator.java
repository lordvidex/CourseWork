package dev.druid.classwork.classwork8;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA
 * Date: 11.03.2021
 * Time: 4:52 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class UserYearComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
