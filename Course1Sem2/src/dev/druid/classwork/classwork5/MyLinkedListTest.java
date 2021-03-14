package dev.druid.classwork.classwork5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * Date: 01.03.2021
 * Time: 8:44 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyLinkedListTest {
    static MyLinkedList a;
    static MyLinkedList b;

    @Before
    public void setUp(){
        // Given
        a = new MyLinkedList();
        b = new MyLinkedList();
    }
    @Test
    public void addingElementsToMyLinkedListIncreasesCount(){
        // Given
        int expected = 2;
        // When
        a.add(4);
        a.add(5);

        //Then
        Assert.assertEquals(expected,a.size());
    }

    @Test
    public void maxElementsReturnTheMaxValueInLinkedList(){
        // Given
        addStub(a);
        int expected = 5;

        // When
        int maxValue = a.maxValue();

        // Then
        Assert.assertEquals(expected, maxValue);
    }
    @Test
    public void elementSumShouldReturnTheSumOfElementsInLinkedList(){
        // Given
        addStub(a);
        int expected  = 9;
        // When
        long result = a.elementSum();
        //Then
        Assert.assertEquals(expected,result);
    }
    @Test
    public void compareReturnsFalseWhenElementsAreNotEqual(){
        addStub(a);
        Assert.assertNotEquals(a, b);
    }
    @Test
    public void compareReturnsTrueWhenElementsAreTheSame(){
        // When
        addStub(a);
        addStub(b);

        // Then
        Assert.assertEquals(a,b);
    }
    @Test
    public void addToEndTest(){
        //When
        addStub(a);
        a.addToEnd(2);

        // Then
        Assert.assertEquals(2,a.search(0));
    }
    public void addStub (MyLinkedList x){
        x.add(4);
        x.add(5);
    }
}
