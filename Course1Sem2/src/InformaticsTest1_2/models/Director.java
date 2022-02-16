package InformaticsTest1_2.models;

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
public class Director {
    private String fullname;
    private int id;

    @Override
    public String toString() {
        return fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public int getId() {
        return id;
    }

    public Director(String fullname, int id) {
        this.fullname = fullname;
        this.id = id;
    }
    public static Director fromArray(String[] arr){
        return new Director(arr[1].trim(),Integer.parseInt(arr[0].trim()));
    }
}
