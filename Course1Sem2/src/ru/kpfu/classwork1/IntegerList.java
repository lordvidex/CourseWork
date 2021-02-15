package ru.kpfu.classwork1;

/**
 * Created by IntelliJ IDEA
 * Date: 15.02.2021
 * Time: 2:16 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public interface IntegerList {
    /**
    * adds int value to the array
    */
    public void add(int x);
    /**
     * @return the size of the array
     */
    public int size();

    /**
     * clears the array by creating a new array of integers with no items
     */
    public void clear();
    /**
     * @param x value to search for in the array
     * @return {@code true}- if <param>x</param> is contained in the array otherwise {@code false}
     */
    public boolean contains(int x);

    public void removeAll(int x);

}
