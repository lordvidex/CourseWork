package dev.druid.homework.homework8;

import dev.druid.classwork.classwork8.StringComparator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * Date: 14.03.2021
 * Time: 5:02 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class StringComparatorTest {
    private final StringComparator x = new StringComparator();

    @Test
    public void shorterStringsShouldBeLess() {
        // Given

        String string1 = "43121";
        String string2 = "2242344";

        // When
        int result = x.compare(string1, string2);

        //Then
        Assert.assertTrue(result < 0);
    }
    @Test
    public void stringsWithTheSameLengthShouldCompareNormally(){
        // Given
        String string1 = "4321";
        String string2 = "4302";
        String string3 = "123";
        String string4 = "994";

        // When
        int result1 = x.compare(string1,string2);
        int result2 = x.compare(string3,string4 );

        // Then
        Assert.assertTrue(result1>0);
        Assert.assertTrue(result2<0);

    }
}
