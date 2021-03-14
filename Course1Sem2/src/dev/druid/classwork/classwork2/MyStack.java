package dev.druid.classwork.classwork2;

/**
 * Created by IntelliJ IDEA
 * Date: 22.02.2021
 * Time: 2:59 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyStack {
    private int CAPACITY = 1000;
    private char[] arr;
    private int size;

    public MyStack(){
        arr = new char[CAPACITY];
        size = 0;

    }
    public int size(){
        return size;
    }
    public void push(char value){
        if(size==CAPACITY){
            CAPACITY*=2;
            char[] newChar = new char[CAPACITY];
            System.arraycopy(arr,0,newChar,0,size);
            arr = newChar;
        }
        arr[size++] = value;
    }
    public char pop(){
        return arr[--size];
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
