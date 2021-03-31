package dev.druid.classwork.classwork10;

/**
 * Created by IntelliJ IDEA
 * Date: 17.03.2021
 * Time: 4:14 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class User {
    private int id;
    private String username;
    private String yearOfBirth;
    private String country;
    private String city;
    private char gender;
    public User(int id){
        this.id = id;
    }

    private User(int id,String username, String city, String yearOfBirth, String country, char gender) {
        this.id = id;
        this.username = username;
        this.city = city;
        this.yearOfBirth = yearOfBirth;
        this.country = country;
        this.gender = gender;
    }

    public static User fromArray(String[] array) {
        return new User(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5].charAt(0));
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }
    public User getUser(){
        return this;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                '}';
    }
}
