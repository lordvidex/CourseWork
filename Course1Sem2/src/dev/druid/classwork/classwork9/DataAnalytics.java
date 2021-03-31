package dev.druid.classwork.classwork9;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * Date: 15.03.2021
 * Time: 2:22 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class DataAnalytics {
    // File array
    private static ArrayList<User> users;

    public static void main(String[] args) {
        // initialize
        users = new ArrayList<>();
        // read in the file
        String fileName =
                "/Users/lordvidex/IdeaProjects/CourseWork/Course1Sem2/src/dev/druid/classwork/classwork9/gender-classifier-DFE-791531.csv";
        try {
            readFile(fileName);
        } catch (IOException | CsvValidationException e) {
            System.out.println("There was an error reading file");
        }

        // get male, female and brand
        int[] genderData = getGenderData();
        System.out.println(Arrays.toString(new String[]{"Male", "Female", "Brand"}));
        System.out.println(Arrays.toString(genderData));

        // average tweets by males and females
        System.out.println(Arrays.toString(new String[]{"Male ", "Female"}));
        double[] averageTweets = getAverageFavoriteTweetForMaleAndFemale();
        System.out.println(Arrays.toString(averageTweets));

        System.out.println(User.count);
    }

    /**
     * 0 -> Average tweets count by males
     * 1 -> Average tweets count by females
     *
     * @return double[] showing average tweets by males and females
     */
    private static double[] getAverageFavoriteTweetForMaleAndFemale() {
        double[] average = new double[]{0, 0};
        int maleCount = 0;
        int femaleCount = 0;
        for (User user : users) {
            if (user.getGender() == null) {
                continue;
            }
            switch (user.getGender()) {
                case Male -> {
                    maleCount++;
                    average[0] += user.getFav_number();
                }
                case Female -> {
                    femaleCount++;
                    average[1] += user.getFav_number();
                }
            }
        }
        if (maleCount != 0) average[0] /= maleCount;
        if (femaleCount != 0) average[1] /= femaleCount;

        return average;
    }

    /**
     * 0 -> male
     * 1 -> female
     * 2 -> brand
     *
     * @return an Array of int of user ids
     */
    private static int[] getGenderData() {
        int[] genders = new int[]{0, 0, 0};
        int errors = 0;
        for (User user : users) {
            if (user.getGender() == null) {
                continue;
            }
            switch (user.getGender()) {
                case Male -> genders[0]++;
                case Female -> genders[1]++;
                case Brand -> genders[2]++;
            }
        }
        return genders;
    }

    private static void readFile(String filename) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new BufferedReader(new FileReader(filename)));
        String[] line;
        reader.readNext();
        while ((line = reader.readNext()) != null) {
            users.add(User.fromArray(line));
        }
        reader.close();
    }
}
