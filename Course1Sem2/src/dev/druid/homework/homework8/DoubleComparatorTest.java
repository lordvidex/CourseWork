package dev.druid.homework.homework8;

import dev.druid.classwork.classwork8.DoubleComparator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * Date: 14.03.2021
 * Time: 4:51 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class DoubleComparatorTest {
    @Test
    public void twoDoublesShouldBeEqualWhenRoundedToEpsilon(){
        // Given
        double epsilon = 0.001;
        DoubleComparator a = new DoubleComparator(epsilon);
        double double1 = 0.004;
        double double2 = 0.0049;
        // When
        int answer = a.compare(double1,double2);
        // Then
        Assert.assertEquals(0,answer);
    }
    @Test
    public void twoDoubleShouldNotBeEqualIfGreaterThanEpsilon(){
        // Given
        double epsilon = 0.001;
        DoubleComparator a = new DoubleComparator(epsilon);
        double double1 = 0.004;
        double double2 = 0.005;
        // When
        int answer = a.compare(double1,double2);
        // Then
        Assert.assertTrue(answer<0);
    }
}
