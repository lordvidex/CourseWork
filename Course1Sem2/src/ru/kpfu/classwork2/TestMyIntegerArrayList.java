package ru.kpfu.classwork2;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 18.02.2021
 * Time: 4:27 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class TestMyIntegerArrayList {
    // Test Driven Development
    @Test
    public void createdCollectionIsEmpty() {
        // Assert
        MyIntegerArrayList a = new MyIntegerArrayList();
        Assert.assertTrue(a.isEmpty());
    }

    @Test
    public void addElementToEmptyListMakesItNonEmpty() {
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.add(1);
        Assert.assertFalse(a.isEmpty());
    }

    @Test
    public void addElementToEmptyListMakesSizeEquals1() {
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.add(1);
        Assert.assertEquals(1, a.size());
    }

    @Test
    public void addAllElements() {
        MyIntegerArrayList a = new MyIntegerArrayList();
        Collection<Integer> x = Arrays.asList(1, 2, 3, 4);
        boolean result = a.addAll(x);
        Assert.assertTrue(result);
    }

    @Test
    public void toArrayReturnsCorrectListOfElements() {
        // Giver
        MyIntegerArrayList a = new MyIntegerArrayList();
        List list = Arrays.asList(1, 2, 3, 4);
        // When
        a.addAll(list);
        // Then
        Assert.assertArrayEquals(a.toArray(new Integer[0]), list.toArray());
    }

    @Test
    public void removeAllShouldReturnTrueWhenItemExist() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        List list = Arrays.asList(1, 2, 3, 4);
        a.addAll(Arrays.asList(1, 2, 5));

        // When
        boolean isRemoved = a.removeAll(list);

        //Then
        Assert.assertTrue(isRemoved);
    }

    @Test
    public void removeAllItemsInListIfItemExist() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        List list = Arrays.asList(1, 2, 3, 4);
        a.addAll(Arrays.asList(1, 2, 5));
        // When
        boolean isRemoved = a.removeAll(list);

        //Then
        Object[] expectedList = new Object[]{5};
        Assert.assertArrayEquals(expectedList, a.toArray());
    }

    @Test
    public void removingAllItemsShouldWorkWithMultipleData() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        List list = Arrays.asList(1, 2, 3, 4, 4, 5);
        a.addAll(Arrays.asList(1, 2, 5, 4, 4, 4, 6));
        // When
        boolean isRemoved = a.removeAll(list);

        //Then
        Object[] expectedList = new Object[]{6};
        Assert.assertArrayEquals(expectedList, a.toArray());
    }

    @Test
    public void containsAllShouldReturnTrueWhenALLValuesAreFound() {
        // Given
        MyIntegerArrayList c = new MyIntegerArrayList();
        c.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // When
        boolean result = c.containsAll(Arrays.asList(1, 2, 3));

        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void containsAllShouldReturnFalseWhenOneValueNotFound() {
        // Given
        MyIntegerArrayList c = new MyIntegerArrayList();
        c.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // When
        boolean result = c.containsAll(Arrays.asList(1, 2, 3, 7));

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void clearShouldRemoveItemsInTheCollection() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // When
        a.clear();

        // Then
        Assert.assertArrayEquals(new Object[0], a.toArray());
    }

    @Test
    public void addAllWithIndexProvidedShouldShiftOldElements() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Object[] expected = new Object[]{1, 20, 21, 22, 2, 3, 4, 5};

        // When
        boolean wasAdded = a.addAll(1, Arrays.asList(20, 21, 22));

        // Then
        Assert.assertTrue(wasAdded);
        Assert.assertArrayEquals(expected, a.toArray());
    }

    @Test
    public void retainAllShouldRetainItemsSpecifiedInTheCollection() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Object[] expected = new Object[]{3, 4};

        // When
        a.retainAll(Arrays.asList(3, 4, 7));

        // Then
        Assert.assertArrayEquals(expected, a.toArray());
    }

    @Test
    public void getShouldReturnItemAtPositionIndex() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1, 2, 3, 4, 5));
        int expectedIndex = 2;
        int expected = 3;

        // When
        int result = a.get(expectedIndex);

        // Then
        Assert.assertEquals(expected, result);
    }

    @Test
    @Description("set should replace Item at given position with new number and return " +
            "the value at the index")
    public void setShouldReplaceItemAtPositionIndexWithElement() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1, 2, 3, 4, 5));
        int objectToBePopped = 2;
        Object[] expected = new Object[]{1, 20, 3, 4, 5};

        // When
        int result = a.set(1,20);

        // Then
        Assert.assertEquals(objectToBePopped,result);
        Assert.assertArrayEquals(expected, a.toArray());
    }

    @Test
    public void addWithAnIndexShouldShiftOldElements() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1,2,3,4,5));
        Object[] expected = new Object[]{1,4,2,3,4,5};

        // When
        a.add(1,4);

        // Then
        Assert.assertArrayEquals(expected,a.toArray());
    }

    @Test
    @Description("should return index of the first element found if they are " +
            "more than one")
    public void indexOfShouldReturnIndexOfFirstElement() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1,2,3,4,5,6,5));
        int expected = 4;

        // When
        int result = a.indexOf(5);

        // Then
        Assert.assertEquals(expected,result);
    }

    @Test
    public void lastIndexOfShouldReturnIndexOfLastElement() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1,2,3,4,5,6,5));
        int expected = 6;

        // When
        int result = a.lastIndexOf(5);

        // Then
        Assert.assertEquals(expected,result);
    }

    @Test
    @Description("should return -1 if number is not found in the array")
    public void indexOfShouldReturnNegative1WhenNotFound() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1,2,3,4,5,6,5));
        int expected = -1;

        // When
        int result = a.indexOf(10);

        // Then
        Assert.assertEquals(expected,result);
    }

    @Test
    public void subListShouldReturnListOfItemsInFromIndexToIndex() {
        // Given
        MyIntegerArrayList a = new MyIntegerArrayList();
        a.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Object[] expected = new Object[]{3,4,5,6,7};
        // When
        List<Integer> result = a.subList(2,7);

        // Then
        Assert.assertArrayEquals(expected,result.toArray());
    }
}
