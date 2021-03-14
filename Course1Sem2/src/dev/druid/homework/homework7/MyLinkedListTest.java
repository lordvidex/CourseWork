package dev.druid.homework.homework7;
import dev.druid.classwork.classwork7.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * Date: 04.03.2021
 * Time: 2:58 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class MyLinkedListTest {
    @Test
    public void addToHeadWhenEmptyTest(){
        // Given
        MyLinkedList<Integer> a  = new MyLinkedList<>();

        // When
        a.add(20);

        // Then
        Assert.assertEquals(1,a.size());
        Assert.assertEquals(20,(int)a.get(0));
    }
    @Test
    public void clearRemovesItemInList(){
        // Given
        MyLinkedList<Integer> x=  new MyLinkedList<>();
        addStub(x);

        // When
        x.clear();

        //Then
        Assert.assertEquals(0,x.size());
    }
    public void setAssignsValueAtPosition(){
        // Given
        MyLinkedList<Integer> x = new MyLinkedList<>();
        addStub(x);
        // When
        x.set(1,3);
        //Then
        Assert.assertEquals(3,(int)x.get(1));
        Assert.assertEquals(3,x.size());
    }
    public void addStub (MyLinkedList<Integer> x){
        x.add(4);
        x.add(5);
    }
}
