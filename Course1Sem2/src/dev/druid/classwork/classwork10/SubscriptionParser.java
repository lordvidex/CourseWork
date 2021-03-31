package dev.druid.classwork.classwork10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 17.03.2021
 * Time: 4:38 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class SubscriptionParser {
    static List<User> users;
    static HashSet<Integer> beijingResidents;
    static List<int[]> subscriptions;
    public static void main(String[] args) throws IOException {
        // init
        subscriptions = new ArrayList<>();
        beijingResidents = new HashSet<>();

        // parse file
        users = parseUsersFile("/Users/lordvidex/IdeaProjects/CourseWork/Course1Sem2/src/dev/druid/classwork/classwork10/users.csv");
        parseSubscriptionsFile("/Users/lordvidex/IdeaProjects/CourseWork/Course1Sem2/src/dev/druid/classwork/classwork10/subscriptions.txt");


        // add all Beijing Residents
        storeBeijingers();

        // check for subscriptions
        List<Integer> beijingLoversId = subscribedToBeijingers();
        System.out.println(beijingLoversId);
    }

    private static List<Integer> subscribedToBeijingers() {
        HashSet<Integer> ans = new HashSet<>();
        for(int[] x: subscriptions){
            if(beijingResidents.contains(x[1])){
                ans.add(x[0]);
            }
        }
        return new ArrayList<>(ans);
    }

    private static void storeBeijingers() {
        for(User user: users){
            if(user.getCity().equals("Beijing")){
                beijingResidents.add(user.getId());
            }
        }
    }

    private static void parseSubscriptionsFile(String filename) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while((line = br.readLine())!=null){
            String[] arr = line.split(" ");
            subscriptions.add(new int[]{
                    Integer.parseInt(arr[0]),
                    Integer.parseInt(arr[1])
            });
        }
    }
    public static List<User> parseUsersFile(String filename) throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        // minus headers
        br.readLine();

        while((line = br.readLine())!=null){
            users.add(User.fromArray(line.split(",")));
        }
        return users;
    }
}
