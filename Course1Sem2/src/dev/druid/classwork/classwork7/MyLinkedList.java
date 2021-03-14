package dev.druid.classwork.classwork7;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA
 * Date: 04.03.2021
 * Time: 4:33 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyLinkedList<T> implements List<T> {
    private Elem<T> head;
    private Elem<T> tail;
    private int count = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Elem<T> x = head; x != null; x = x.next) {
            if (x.value == o) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    public boolean add(T value) {
        if (count == 0) {
            head = tail = new Elem<T>(value, head);
        } else {
            head = new Elem<T>(value, head);
        }
        count++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        boolean willRemoveHead = false;
        boolean itemRemoved = false;
        if (head.value == o) {
            willRemoveHead = true;
        }
        Elem<T> x = head;
        int i = 0;
        while (x.next != null) {
            if (x.next.value == o) {
                x.next = x.next.next;
                itemRemoved = true;
                count--;
            }
            x = x.next;
        }
        if (willRemoveHead) {
            head = head.next;
            count--;
        }
        return itemRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean itemAdded = false;
        for (T item : c) {
            itemAdded |= add(item);
        }
        return itemAdded;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean itemAdded = false;

        Elem<T> formerHead = head;
        Elem<T> cutTail;
        for (int i = 0; i < index - 1; i++) {
            head = head.next;
        }
        cutTail = head;
        head = head.next;
        for (T x : c) {
            itemAdded |= add(x);
        }
        cutTail.next = head;
        head = formerHead;
        return itemAdded;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean itemRemoved = false;
        for (Object x : c) {
            itemRemoved |= remove(x);
        }
        return itemRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean itemRemoved = false;
        for(Object x: c){
            if(!contains(x)){
                itemRemoved |= remove(x);
            }
        }
        return itemRemoved;
    }

    @Override
    public void clear() {
        head = tail = null;
        count = 0;
    }

    @Override
    public T get(int index) {
        Elem<T> x = head;
        int i = 0;
        while (i < index) {
            x = x.next;
            i++;
        }
        return x.value;
    }

    @Override
    public T set(int index, T element) {
        Elem<T> x = head;
        int i = 0;
        while (i < index) {
            x = x.next;
            i++;
        }
        T temp = x.value;
        x.value = element;
        return temp;
    }

    @Override
    public void add(int index, T element) {
        if (index == 0) {
            add(element);
        } else {
            Elem<T> x = head;
            int i = 0;
            while (i < index - 1) {
                x = x.next;
                i++;
            }
            x.next = new Elem<>(element, x.next);
            count++;
        }
    }

    @Override
    public T remove(int index) {
        T deleted;
        if (index == 0) {
            deleted = head.value;
            head = head.next;
            count--;
        } else {
            Elem<T> x = head;
            for (int i = 0; i < index - 1; i++) {
                x = x.next;
            }
            deleted = x.next.value;
            x.next = x.next.next;
        }
        if (deleted != null) {
            count--;
        }
        return deleted;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (Elem<T> x = head; x != null; x = x.next) {
            if (x.value == o) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int i = 0;
        for (Elem<T> x = head; x != null; x = x.next) {
            if (x.value == o) {
                lastIndex = i;
            }
            i++;
        }
        return lastIndex;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
