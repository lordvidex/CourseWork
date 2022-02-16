package InformaticsTest;

/**
 * Created by IntelliJ IDEA
 * Date: 19.05.2021
 * Time: 4:22 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Club {
    private String name;
    private String id;
    private String yearOfFoundation;
    private String city;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getYearOfFoundation() {
        return yearOfFoundation;
    }

    public String getCity() {
        return city;
    }

    public Club(String name, String id, String yearOfFoundation, String city) {
        this.name = name;
        this.id = id;
        this.yearOfFoundation = yearOfFoundation;
        this.city = city;
    }

    public static Club fromArray(String[] arr){
        return new Club(arr[1],arr[0],arr[2],arr[3]);
    }

    @Override
    public String toString() {
        return name;
    }
}
