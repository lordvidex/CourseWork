package InformaticsTest2.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 03.06.2021
 * Time: 4:15 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class User {
    private String id;
    private String name;
    private String city;
    private final int year;
    private final List<User> subscribers;

    public String getCity() {
        return city;
    }
    public void addSubsciber(User sub){
        this.subscribers.add(sub);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public User(String id, String name, String city, int year) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.year = year;
        this.subscribers = new ArrayList<>();
    }
    public static User fromArray(String[] arr){
        return new User(arr[0].trim(),arr[1].trim(),arr[2].trim(),Integer.parseInt(arr[3].trim()));
    }

    public String getId() {
        return id;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }
    public static final User ANONYMOUS = new User("########","Anonymous","Unknown",2000);
}
