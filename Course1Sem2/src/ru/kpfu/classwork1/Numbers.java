package ru.kpfu.classwork1;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * Date: 15.02.2021
 * Time: 2:21 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Numbers implements IntegerList {
    private static final int BUFFER_SIZE = 100;
    private int[] numbers;
    private int arraySize;
    private int capacity = BUFFER_SIZE;

    public Numbers() {
        this.arraySize = 0;
        numbers = new int[capacity];
    }


    public int[] getNumbers() {
        return Arrays.stream(numbers).limit(arraySize).toArray();
    }

    @Override
    public void add(int x) {
        if (arraySize < capacity) {
            numbers[arraySize] = x;
        } else {
            capacity+=BUFFER_SIZE;
            int[] newArray = new int[capacity];
            System.arraycopy(numbers, 0, newArray, 0, arraySize);
            newArray[arraySize] = x;
            numbers = newArray;
        }
        arraySize++;
    }

    @Override
    public int size() {
        return arraySize;
    }

    @Override
    public void clear() {
        arraySize = 0;
    }

    @Override
    public boolean contains(int x) {
        for (int i = 0;i<arraySize;i++) {
            if (numbers[i] == x) return true;
        }
        return false;
    }
    @Override
    public void removeAll(int x){
        int shift = 0;
        int[] newArray = new int[capacity];
        for (int i = 0; i < arraySize-shift; i++) {
            while(numbers[i+shift]==x){
                shift++;
            }
            newArray[i] = numbers[i+shift];
        }
        arraySize-=shift;
        numbers = newArray;
    }
}
