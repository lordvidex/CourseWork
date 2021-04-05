package dev.druid.classwork.classwork14;

import dev.druid.classwork.classwork13.CarMaker;
import dev.druid.classwork.classwork13.Country;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 05.04.2021
 * Time: 2:28 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    public static void task0() {
        System.out.println("------------- Task 0 -----------------");
        HashMap<Character, Integer> alphabets = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter any string: ");
        String input = sc.nextLine();
        for (char x : input.toCharArray()) {
            if (Character.isLetter(x) && Character.isLowerCase(x))
            alphabets.put(x, alphabets.getOrDefault(x, 0) + 1);
        }

        System.out.print("Map: ");
        for (Map.Entry<Character, Integer> entry : alphabets.entrySet()) {
            System.out.printf("%c: %d, ", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        task0();
        dev.druid.classwork.classwork13.Main.readFiles();
        task1();
        task2();
    }

    private static void task1() {
        System.out.println("------------- Task 1 -----------------");
        System.out.println("Makers in each country: ");
        // makers in each country
        Map<Country, Integer> makersInEachCountry = new HashMap<>();

        // car makers loaded from the last module
        List<CarMaker> carMakers = dev.druid.classwork.classwork13.Main.carMakers;

        // insert into map
        for (CarMaker c : carMakers) {
            Country country = c.getCountry();
            if (country != null) {

                makersInEachCountry.put(
                        country,
                        makersInEachCountry.getOrDefault(country, 0) + 1);
            }
        }

        // output
        for (var entry : makersInEachCountry.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static void task2() {
        // map that contains CarMaker and the average HP of cars they produce
        Map<CarMaker,Double> averageCarMakerHPs = dev.druid.classwork.classwork13.Main.getCarMakerHPAverage();
        System.out.println("------------ Task 2 ------------");
        System.out.printf("%24s:%s%n","CarMaker","Average HP");

        for (var entry : averageCarMakerHPs.entrySet())
            System.out.printf("%24s:%f%n", entry.getKey().getFullName(), entry.getValue());
    }
}
