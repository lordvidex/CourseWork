package dev.druid.classwork.classwork5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA
 * Date: 01.03.2021
 * Time: 3:16 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyLinkedList {
    Elem head;
    private int count = 0;
    Elem tail;

    public void add(int value) {
        if (count == 0) {
            head = tail = new Elem(value, head);
        } else {
            head = new Elem(value, head);
        }
        count++;
    }

    public void addToEnd(int value) {
        if (count == 0) {
            head = tail = new Elem(value, head);
        } else {
            tail = tail.next = new Elem(value, null);
        }
        count++;
    }

    public void addAt(int value, int position) {
        if (position > count) throw new IndexOutOfBoundsException();
        Elem x = head;
        int i = 0;
        while (i < position) {
            i++;
            x = x.next;
        }
        x.next = new Elem(x.value, x.next);
        x.value = value;
        count++;
    }

    public int deleteHead() {
        int value = head.value;
        head = head.next;
        count--;
        return value;
    }

    public int deleteTail() {
        int temp;
        // etch case {if itemCount is 1 or 0}
        if (count == 0) {
            throw new IndexOutOfBoundsException();
        } else if (count == 1) {
            temp = head.value;
            head = null;
        } else {
            Elem x = head;
            while (x.next.next != null) {
                x = x.next;
            }
            temp = x.next.value;
            x.next = null;
        }
        count--;
        return temp;
    }

    public int deleteAt(int position) {
        if (position > count)
            throw new IndexOutOfBoundsException();

        //Etchcase {when position == 0}
        if(position==0) return deleteHead();
        else {
            // loop until position - 1
            // set the pointer of position-1.next to position.next
            // return the removed value at position.next
            Elem x = head;
            for (int i = 0; i < position - 1; i++) {
                x = x.next;
            }
            int temp = x.next.value;
            x.next = x.next.next;
            return temp;
        }
    }

    public int search(int position) {
        Elem x = head;
        int i = 0;
        while (i < position) {
            x = x.next;
            i++;
        }
        return x.value;
    }

    public int size() {
        return count;
    }

    /**
     * @return the maximum value in the linkedlist
     * and returns Integer.MIN_VALUE if the linkedlist is empty
     */
    public int maxValue() {
        int max = Integer.MIN_VALUE;
        for (Elem x = head; x != null; x = x.next) {
            if (x.value > max) max = x.value;
        }
        return max;
    }

    public long elementSum() {
        long sum = 0;
        for (Elem x = head; x != null; x = x.next) {
            sum += x.value;
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList that = (MyLinkedList) o;

        // fast return false if they don't have the same size
        if (count != that.count) {
            return false;
        }
        // once an element does not match return false
        for (Elem x = head, y = that.head;
             x != null && y != null;
             x = x.next, y = y.next) {
            if (x.value != y.value) return false;
        }
        return true;
    }
}
