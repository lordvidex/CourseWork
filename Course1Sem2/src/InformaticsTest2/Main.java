package InformaticsTest2;

import InformaticsTest2.models.Group;
import InformaticsTest2.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 03.06.2021
 * Time: 4:00 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: Variant (I)
 * 2. All groups and number of users from Kazan in these groups
 * 3. Users that all Moscow people subscribe to them
 */
public class Main {
    private static Map<String, User> usersMap;
    private static Map<Integer,Group> groups;

    public static void main(String[] args) {
        init();
        task2();
        task3();
    }
    private static void task3(){
        System.out.println("----------- Task 3 -----------");
        System.out.println("Users that are subscribed to by all Moscow users");
        List<User> moscowPeople = usersMap.values().stream()
                .filter(user->user.getCity().equals("Moscow"))
                .collect(Collectors.toList());
        for(User u: usersMap.values()){
            List<User> users = new ArrayList<>(u.getSubscribers());
            // if the user is also from Moscow, this has to be considered
            if(u.getCity().equals("Moscow")){
                users.add(u);
            }

            if(users.containsAll(moscowPeople)){
                System.out.println(u);
            }
        }
    }
    private static void task2(){
        System.out.println("------------Task 2---------");
        for(Map.Entry<Integer,Group> gEntry: groups.entrySet()){
            Group g = gEntry.getValue();
            long count = g.getUsers().stream()
                    .filter(user -> user.getCity().trim().equals("Kazan")).count();
            System.out.printf("Group - %s, Kazan Users - %d%n",g.toString(),count);
        }
    }

    private static void init(){
        // initialise static data structures
        // map is used for users and groups for O(1) retrieval of users from id
        // and also for retrieval of groups from id
        // list is used for groups for easy stream operations
        usersMap = new HashMap<>();
        groups = new HashMap<>();


        try {
            // get users from csv
            fetchUsers("src/InformaticsTest2/res/users.csv");
            // get groups from csv
            fetchGroups("src/InformaticsTest2/res/groups.csv");
            // add membership to groups
            getMemberships("src/InformaticsTest2/res/membership.csv");
            // add subscribers to users from the subscribers.csv file
            getSubscribers("src/InformaticsTest2/res/subscribers.csv");
        }catch(IOException e){
            System.out.println("Error reading files");
            System.exit(-1);
        }
    }

    private static void getSubscribers(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while((line = br.readLine())!= null){
            String[] arr = line.split(",");
            User owner = usersMap.get(arr[1]);
            User sub = usersMap.get(arr[0]);
            if (owner != null && sub != null) {
                owner.addSubsciber(sub);
            }
        }
        br.close();
    }

    private static void getMemberships(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while((line = br.readLine())!= null){
            String[] arr = line.split(",");
            groups.get(Integer.parseInt(arr[1].trim()))
                    .addUserToGroup(usersMap.get(arr[0].trim()));
        }
        br.close();
    }

    private static void fetchUsers(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while((line = br.readLine())!= null){
            User u = User.fromArray(line.split(","));
            usersMap.put(u.getId(),u);
        }
        br.close();
    }
    private static void fetchGroups(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine();
        String line;
        while((line = br.readLine())!= null){
            Group g = Group.fromArray(line.split(","),usersMap);
            groups.put(g.getId(),g);
        }
        br.close();
    }
}
