package ru.kpfu.classwork2;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * Date: 17.02.2021
 * Time: 3:57 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyIntegerArrayCollection implements Collection<Integer> {
    private int CAPACITY = 1000;
    private int count = 0;
    private int[] arr = new int[CAPACITY];
    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public boolean contains(Object o) {
        Integer val = (Integer) o;
        for (int i = 0; i < count; i++) {
            if(val==arr[i])return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Arrays.stream(arr).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[count];
        for (int i = 0; i < count; i++) {
            objects[i] = arr[i];
        }
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(toArray(),count,a.getClass());
    }

    @Override
    public boolean add(Integer integer) {
        if(count==CAPACITY){
            return false;
        }
        arr[count++] = integer;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(!(o instanceof Integer|| o instanceof Short || o instanceof Byte)){
            return false;
        }else {
            int shift = 0;
            int x = ((Number) o).intValue();
            int[] newArray = new int[CAPACITY];
            for (int i = 0; i < count - shift; i++) {
                while (arr[i + shift] == x) {
                    shift++;
                }
                newArray[i] = arr[i + shift];
            }
            count -= shift;
            arr = newArray;
            return shift>0;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object x: c){
            if(!contains(x)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean result = false;
        for(Integer num: c){
            result = result | add(num);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean anyRemoved = false;
        for(Object x: c){
            anyRemoved = anyRemoved | remove(x);
        }
        return anyRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int[] newArray = new int[CAPACITY];
        int newCount = 0;
        for(Object x: c){
            if(contains(x)){
                newArray[newCount++] = (int) x;
            }
        }
        if(newCount==count){
            return false;
        }else{
            arr = newArray;
            count = newCount;
            return true;
        }
    }

    @Override
    public void clear() {
        this.count = 0;
    }
}
