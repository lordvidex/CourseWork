package dev.druid.classwork.classwork9;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * Date: 15.03.2021
 * Time: 2:27 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class User {
    private String id;
    public static int count = 0;
    private Gender gender;
    private int fav_number;

    private User(String id, Gender gender, int fav_number) {
        this.id = id;
        this.gender = gender;
        this.fav_number = fav_number;
    }

    public static User fromArray(String[] array) {
        count++;
        if (array[11].isEmpty()) {
            array[11] = "0";
            System.out.println("Error at id -> " + array[0] + " Column <<Favorite numbers>>");
        }
        if (array[5] == null) {
            System.out.println("Error at id -> " + array[0] + " Column <<Gender>>");
        }
        return new User(array[0],
                array[5] == null ? null : Gender.mapStringToGender(array[5]),
                Integer.parseInt(array[11]));
    }

    public Gender getGender() {
        return gender;
    }

    public int getFav_number() {
        return fav_number;
    }
}
