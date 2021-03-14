package dev.druid.homework.homework8;

import dev.druid.classwork.classwork8.User;
import dev.druid.classwork.classwork8.UserYearComparator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * Date: 14.03.2021
 * Time: 5:08 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class UserYearComparatorTest {
    UserYearComparator comparator = new UserYearComparator();
    @Test
    public void youngerUserShouldBeFirst(){
        // Given
        User user1 = new User("Evans",15);
        User user2 = new User("John", 12);

        // When
        int result = comparator.compare(user1, user2);

        // Then
        Assert.assertTrue(result>0);
    }
    @Test
    public void olderUserShouldComeLast(){
        // Given
        User user1 = new User("Evans",15);
        User user2 = new User("John", 43);

        // When
        int result = comparator.compare(user1, user2);

        // Then
        Assert.assertTrue(result<0);
    }
    @Test
    public void equallyAgedUserShouldBeRankedEqual(){
        // Given
        User user1 = new User("Evans",13);
        User user2 = new User("John", 13);

        // When
        int result = comparator.compare(user1, user2);

        // Then
        Assert.assertEquals(0,result);
    }
}
