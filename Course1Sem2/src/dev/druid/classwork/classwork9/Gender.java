package dev.druid.classwork.classwork9;

/**
 * Created by IntelliJ IDEA
 * Date: 15.03.2021
 * Time: 2:32 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public enum Gender {
    Male, Female, Brand;

    public static Gender mapStringToGender(String gender){
        return switch (gender) {
            case "male" -> Gender.Male;
            case "female" -> Gender.Female;
            case "brand" -> Gender.Brand;
            default -> null;
        };
    }
}
