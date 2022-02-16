package InformaticsTest2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Date: 03.06.2021
 * Time: 4:14 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Group {
    private int id;
    private String name;
    private User creator;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public int getId() {
        return id;
    }
    public void addUserToGroup(User u){
        this.users.add(u);
    }

    @Override
    public String toString() {
        return name;
    }

    public Group(int id, String name, User creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.users = new ArrayList<>();
    }

    public static Group fromArray(String[] arr, Map<String, User> usersMap) {
        User creator = usersMap.getOrDefault(arr[2].trim(), User.ANONYMOUS);
        return new Group(Integer.parseInt(arr[0].trim()), arr[1].trim(), creator);
    }
}
