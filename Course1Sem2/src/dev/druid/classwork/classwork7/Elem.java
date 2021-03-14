package dev.druid.classwork.classwork7;

/**
 * Created by IntelliJ IDEA
 * Date: 04.03.2021
 * Time: 4:34 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Elem<T> {
    T value;
    Elem<T> next;
    public Elem(T value){
        this.value = value;
    }
    public Elem(T value, Elem<T> next){
        this.value = value;
        this.next = next;
    }
}
