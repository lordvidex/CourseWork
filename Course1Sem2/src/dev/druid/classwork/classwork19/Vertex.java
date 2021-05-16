package dev.druid.classwork.classwork19;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA
 * Date: 23.04.2021
 * Time: 1:37 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Vertex<T> {
    public T value;
    public HashSet<Vertex<T>> children;
    public Vertex(T value){
        this.value = value;
        this.children = new HashSet<>();
    }
    public Vertex(T value, HashSet<Vertex<T>> children){
        this.value = value;
        this.children = children;
    }
}
