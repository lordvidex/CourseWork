package ru.kpfu.classwork2;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * Date: 17.02.2021
 * Time: 3:58 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyIntegerArrayList implements List<Integer> {
    private static int CAPACITY = 100;
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

    /**
    @return false when count == CAPACITY
     */
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
            result |= add(num);
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        if(index>=count){
            return false;
        }
        // storing the old count, so when the new count increases, we return true
        int oldCount = count;
        int[] store = new int[count-index];

        // move the old elements to the store
        for (int i = index, j = 0; i < count; i++,j++) {
            store[j] = arr[i];
        }
        // reset the index for addition
        count = index;

        // add the elements in the collection specified
        for(Integer x: c){
            add(x);
        }
        for(int x: store){
            add(x);
        }
        return count>oldCount;
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

    @Override
    public Integer get(int index) {
        assert index<count;
        return arr[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        assert index<count;
        int oldElement = arr[index];
        arr[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, Integer element) {
        if(index<count){
            int store = arr[index];
            int shifts = count - index+1;
            count = index;
            for (int i = 0; i < shifts; i++) {
                add(element);
                element = store;
                store = arr[index+i];
            }
        }else if(count==index){
            arr[count++] = element;
        }else{
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public Integer remove(int index) {
        int val = arr[index];
        for (int i = index; i < count-1; i++) {
            arr[i] = arr[i+1];
        }
        return val;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; i++) {
            if(arr[i]==(int)o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = count-1; i >= 0 ; i--) {
            if(arr[i] == (int)o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }
    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        Integer[] list = new Integer[toIndex-fromIndex];
        assert(fromIndex>=0 && toIndex<count);
        int c = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            list[c++] = arr[i];
        }
        return Arrays.asList(list);
    }
}
