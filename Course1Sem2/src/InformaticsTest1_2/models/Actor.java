package InformaticsTest1_2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 07.06.2021
 * Time: 3:00 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Actor {
    private int id;
    private String fullname;
    private int workExperience;
    private List<Film> films;

    public Actor(int id, String fullname, int workExperience) {
        this.id = id;
        this.fullname = fullname;
        this.workExperience = workExperience;
        this.films = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public String toString() {
        return fullname;
    }

    public List<Film> getFilms() {
        return films;
    }
    public void addFilm(Film f){
        films.add(f);
    }
    public static Actor fromArray(String[] arr) {
        return new Actor(Integer.parseInt(arr[0].trim()), arr[1].trim(), Integer.parseInt(arr[2].trim()));
    }
}
