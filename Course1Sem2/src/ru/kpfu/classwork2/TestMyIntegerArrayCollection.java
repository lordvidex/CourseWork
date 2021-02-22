package ru.kpfu.classwork2;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * Created by IntelliJ IDEA
 * Date: 17.02.2021
 * Time: 4:16 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 */

public class TestMyIntegerArrayCollection {

    // Test Driven Development
    @Test
    public void createdCollectionIsEmpty() {
        // Assert
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        Assert.assertTrue(a.isEmpty());
    }

    @Test
    public void addElementToEmptyListMakesItNonEmpty() {
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        a.add(1);
        Assert.assertFalse(a.isEmpty());
    }

    @Test
    public void addElementToEmptyListMakesSizeEquals1() {
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        a.add(1);
        Assert.assertEquals(1, a.size());
    }

    @Test
    public void addAllElements() {
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        Collection<Integer> x = Arrays.asList(1, 2, 3, 4);
        boolean result = a.addAll(x);
        Assert.assertTrue(result);
    }

    @Test
    public void toArrayReturnsCorrectListOfElements(){
        // Giver
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        List list = Arrays.asList(1,2,3,4);
        // When
        a.addAll(list);
        // Then
        Assert.assertArrayEquals(a.toArray(new Integer[0]),list.toArray());
    }

    @Test
    public void removeAllShouldReturnTrueWhenItemExist(){
        // Given
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        List list = Arrays.asList(1,2,3,4);
        a.addAll(Arrays.asList(1,2,5));

        // When
        boolean isRemoved = a.removeAll(list);

        //Then
        Assert.assertTrue(isRemoved);
    }
    @Test
    public void removeAllItemsInListIfItemExist(){
        // Given
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        List list = Arrays.asList(1,2,3,4);
        a.addAll(Arrays.asList(1,2,5));
        // When
        boolean isRemoved = a.removeAll(list);

        //Then
        Object[] expectedList = new Object[]{5};
        Assert.assertArrayEquals(expectedList,a.toArray());
    }

    @Test
    public void removingAllItemsShouldWorkWithMultipleData(){
        // Given
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        List list = Arrays.asList(1,2,3,4,4,5);
        a.addAll(Arrays.asList(1,2,5,4,4,4,6));
        // When
        boolean isRemoved = a.removeAll(list);

        //Then
        Object[] expectedList = new Object[]{6};
        Assert.assertArrayEquals(expectedList,a.toArray());
    }
    @Test
    public void containsAllShouldReturnTrueWhenALLValuesAreFound(){
        // Given
        MyIntegerArrayCollection c = new MyIntegerArrayCollection();
        c.addAll(Arrays.asList(1,2,3,4,5));

        // When
        boolean result = c.containsAll(Arrays.asList(1,2,3));

        //Then
        Assert.assertTrue(result);
    }
    @Test
    public void containsAllShouldReturnFalseWhenOneValueNotFound(){
        // Given
        MyIntegerArrayCollection c = new MyIntegerArrayCollection();
        c.addAll(Arrays.asList(1,2,3,4,5));

        // When
        boolean result = c.containsAll(Arrays.asList(1,2,3,7));

        //Then
        Assert.assertFalse(result);
    }
    @Test
    public void clearShouldRemoveItemsInTheCollection(){
        // Given
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        a.addAll(Arrays.asList(1,2,3,4,5));

        // When
        a.clear();

        // Then
        Assert.assertArrayEquals(new Object[0],a.toArray());
    }
}
