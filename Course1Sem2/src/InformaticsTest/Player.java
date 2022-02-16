package InformaticsTest;

/**
 * Created by IntelliJ IDEA
 * Date: 19.05.2021
 * Time: 4:19 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Player {
    private String name;
    private String id;
    private String role;
    private String country;
    private String yearOfBirth;

    public Player(String name, String id, String role, String country, String yearOfBirth) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getCountry() {
        return country;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public static Player fromArray(String[] arr){
        return new Player(arr[1],arr[0],arr[2],arr[3],arr[4]);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", country='" + country + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                '}';
    }
}
