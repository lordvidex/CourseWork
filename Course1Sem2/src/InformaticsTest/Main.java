package InformaticsTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 19.05.2021
 * Time: 4:23 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    private static ArrayList<Data> data;
    private static Map<String, Club> clubs;
    private static Scanner sc;
    private static Map<String, Player> players;
    private static final String ROOT = "src/InformaticsTest/";

    public static void main(String[] args) {
        try {
            readFiles();
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
        task1();
        task2();
        task3();
    }

    private static void task3() {
        System.out.println("Task 3: Enter the city:");
        String city = sc.nextLine().trim();
        Map<String, Set<String>> record = new HashMap<>();
        for (Data d : data) {
            if (clubs.get(d.getClubId()).getCity().equals(city)) {
                if (!record.containsKey(d.getPlayerId())) {
                    record.put(d.getPlayerId(), new HashSet<>());
                }
                record.get(d.getPlayerId()).add(d.getClubId());
            }
        }
        for (var x : record.entrySet()) {
            System.out.println(players.get(x.getKey()).toString() + ": " + x.getValue().size());
        }
    }

    private static void task2() {
        System.out.println("Task 2: Enter the year X");
        String s = sc.nextLine().trim();
        System.out.println("Общую стоимость");
        for (var c : clubs.entrySet()) {
            long ans = data.stream()
                    .filter(d -> d.getClubId().equals(c.getKey()))
                    .filter(d -> d.getContractExpiryDate().equals(s))
                    .count();
            System.out.println(c.getValue().toString() + ": " + ans);
        }
    }

    private static void readFiles() throws IOException {
        data = readData();
        clubs = readClubs();
        players = readPlayers();
    }

    private static Map<String, Player> readPlayers() throws IOException {
        ArrayList<Player> players1 = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ROOT+"res/players.csv"));
        // header
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            players1.add(Player.fromArray(line.split(",")));
        }
        return players1.stream().collect(Collectors.toMap(Player::getId, Function.identity()));
    }

    private static Map<String, Club> readClubs() throws IOException {
        ArrayList<Club> clubList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ROOT+"res/clubs.csv"));
        // header
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            clubList.add(Club.fromArray(line.split(",")));
        }
        return clubList.stream().collect(Collectors.toMap(Club::getId, Function.identity()));
    }

    private static ArrayList<Data> readData() throws IOException {
        ArrayList<Data> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ROOT+"res/data.csv"));
        // header
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            data.add(Data.fromArray(line.split(",")));
        }
        return data;
    }

    private static void task1() {
        sc = new Scanner(System.in);
        System.out.println("Enter the country of the player:");
        String country = sc.nextLine().trim();
        System.out.println("Enter the specified club name(correctly)");
        String club = sc.nextLine().trim();
        Map<String, Long> conditions1and2 = data.stream()
                .filter(data1 -> clubs.get(data1.getClubId()).getName().equals(club))
                .filter(data1 -> players.get(data1.getPlayerId()).getCountry().equals(country))
                .collect(Collectors.groupingBy(Data::getPlayerId, Collectors.counting()));
        List<Player> answer = conditions1and2.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() > 1)
                .map(it -> players.get(it.getKey()))
                .collect(Collectors.toList());
        answer.forEach(System.out::println);
    }
}
