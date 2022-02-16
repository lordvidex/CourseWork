package InformaticsTest1_2.models;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * Date: 07.06.2021
 * Time: 3:04 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Film implements Comparable<Film>{
    private int id;
    private String name;
    private int year;
    private Director director;

    public Film(int id, String name, int year, Director director) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public static Film fromArray(String[] arr, HashMap<Integer, Director> directors) {
        return new Film(
                Integer.parseInt(arr[0].trim()),
                arr[1].trim(),
                Integer.parseInt(arr[2].trim()),
                directors.get(Integer.parseInt(arr[3].trim()))
        );
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Film o) {
        return this.year - o.getYear();
    }
}
