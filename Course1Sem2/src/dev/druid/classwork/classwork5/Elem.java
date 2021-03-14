package dev.druid.classwork.classwork5;

/**
 * Created by IntelliJ IDEA
 * Date: 01.03.2021
 * Time: 3:17 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Elem {
    int value;
    Elem next;
    public Elem(int value){
        this.value = value;
    }
    public Elem(int value, Elem next){
        this.value = value;
        this.next = next;
    }
}
