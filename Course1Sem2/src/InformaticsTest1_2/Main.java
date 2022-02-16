package InformaticsTest1_2;

import InformaticsTest1_2.models.Actor;
import InformaticsTest1_2.models.Director;
import InformaticsTest1_2.models.Film;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
public class Main {
    private static final String RES_DIRECTORY = "src/InformaticsTest1_2/res/";
    private static HashMap<Integer, Director> directors;
    private static HashMap<Integer, Actor> actors;
    private static HashMap<Integer, Film> films;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // read files from csv to classes
        init();

        //Выдать список фильмов, которые снял некоторый режиссер (параметр запроса) до некоторого года (параметр запроса)
        System.out.println("-------Task 1--------");
        System.out.println("Enter directorId and year with a space in between");
        int directorId = sc.nextInt();
        int year = sc.nextInt();
        task1(directorId, year);

        //Для каждой пары режиссер-актер выдать количество совместных фильмов
        task2();

        //Выдать список актеров, которые после Х года (параметр запроса) снимались только у одного режиссера
        System.out.println("----------Task 3-----------");
        System.out.println("Enter year parameter");
        year = sc.nextInt();
        task3(year);

    }
    private static void task3(int year){
        // loop + stream
        actors.values().stream().filter(actor -> {
            Set<Director> directors = new HashSet<>();
            for(Film f: actor.getFilms()){
                if(f.getYear()>year){
                    directors.add(f.getDirector());
                }
            }
            return directors.size() == 1;
        }).forEach(System.out::println);
    }
    private static void task2() {
        System.out.println("---------Task 2--------");

        for (Actor a : actors.values()) {
            HashMap<Director, Integer> map = new HashMap<>();
            for (Film f : a.getFilms()) {
                map.put(f.getDirector(), map.getOrDefault(f.getDirector(), 0) + 1);
            }
            for (var x : map.entrySet()) {
                System.out.printf("%s - %s: %d%n", a.toString(), x.getKey().toString(), x.getValue());
            }
        }
    }

    private static void task1(int directorId, int year) {
        films.values().stream()
                .filter(film -> film.getDirector().getId() == directorId && film.getYear() <= year)
                .forEach(System.out::println);
    }

    private static void init() {
        // initialise data structures
        directors = new HashMap<>();
        actors = new HashMap<>();
        films = new HashMap<>();


        // read directors
        try {
            fetchDirectors();
            fetchActors();
            fetchFilms();
            attachParticipations();
        } catch (IOException e) {
            System.out.println("Failed to fetch source files");
            System.exit(-1);
        }
    }

    private static void fetchDirectors() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(RES_DIRECTORY + "directors.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            Director d = Director.fromArray(line.split(","));
            directors.put(d.getId(), d);
        }
    }

    private static void fetchActors() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(RES_DIRECTORY + "actors.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            Actor a = Actor.fromArray(line.split(","));
            actors.put(a.getId(), a);
        }
    }

    private static void fetchFilms() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(RES_DIRECTORY + "films.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            Film f = Film.fromArray(line.split(","), directors);
            films.put(f.getId(), f)
            ;
        }
    }

    private static void attachParticipations() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(RES_DIRECTORY + "participations.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            Actor a = actors.get(Integer.parseInt(arr[1].trim()));
            a.addFilm(films.get(Integer.parseInt(arr[0].trim())));
        }
    }
}
