package dev.druid.classwork.classwork13;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 25.03.2021
 * Time: 3:59 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    private static final String RES_DIRECTORY = "src/dev/druid/classwork/classwork13/res/";
    static List<CarMaker> carMakers;
    static HashMap<Integer, Car> cars;
    static HashMap<Integer, String> continents;

    public static void main(String[] args) {
        readFiles();
        task1();
        System.out.println("----------------------------------------");
        task2();
        task3();
        task4();
        task5();
    }

    private static void task5() {
        System.out.println("------------ Task 5 ----------------");
        HashMap<CarMaker, List<Integer>> carMakerHP = new HashMap<>();
        for (var x : cars.entrySet()) {
            Car c = x.getValue();
            List<Integer> value = carMakerHP.computeIfAbsent(c.getCarMaker(), k -> new ArrayList<>());
            if (c.getHorsePower() != null) value.add(c.getHorsePower());
        }

        // compute the average for all carMakerHorsePowers
        System.out.println("---------- Task 5a -------------");
        System.out.println("Average horse power per CarMakers:");

        for (var each : carMakerHP.entrySet()) {
            double average = each.getValue().stream().mapToInt(Integer::intValue).average().getAsDouble();
            if (each.getKey() != null)
                System.out.printf("%24s:%f%n", each.getKey().getFullName(), average);
        }

        System.out.println("---------- Task 5b -------------");
        System.out.println("Average horse power per CarModel:");

        // group the car models and the list of horse powers for the cars
        Map<String, List<Integer>> carModelHP = new HashMap<>();
        for (var x : cars.entrySet()) {
            Car c = x.getValue();
            List<Integer> value = carModelHP.computeIfAbsent(c.getCarModel(), k -> new ArrayList<>());
            if (c.getHorsePower() != null) value.add(c.getHorsePower());
        }

        // compute the average for teh carModelHPs
        for (var each : carModelHP.entrySet()) {
            double average = each.getValue().stream().mapToInt(Integer::intValue).average().getAsDouble();
            System.out.printf("%15s:%f%n", each.getKey(), average);
        }
    }

    private static void task4() {
        System.out.println("--------------- Task 4 ------------------");
        final int OLD_CAR_YEAR = 1990;
        // get all cars with years less than 1990
        List<Car> oldCars = new ArrayList<>();
        for (var it : cars.entrySet()) {
            Car c = it.getValue();
            if (c.getYear() < OLD_CAR_YEAR) {
                oldCars.add(c);
            }
        }

        // get a set of carMakers for each of these cars
        Set<CarMaker> carMakers = oldCars
                .stream()
                .map(Car::getCarMaker).filter(Objects::nonNull)
                .collect(Collectors.toSet());
        System.out.println("The Car Makers that manufactured cars before "+OLD_CAR_YEAR+" are: ");
        carMakers.forEach(System.out::println);
    }

    private static void task3() {
        HashMap<Country, Integer> countryMap = new HashMap<>();
        for (CarMaker carMaker : carMakers) {
            Country c = carMaker.getCountry();
            countryMap.put(c, countryMap.getOrDefault(c, 0) + 1);
        }

        System.out.println("--------------------Task 3--------------------");
        System.out.printf("%12s| Count\n", "Country");
        for (var x : countryMap.entrySet()) {
            System.out.printf("%12s|%d%n", x.getKey(), x.getValue());
        }
    }

    private static void task2() {
        System.out.println("!!! TASK 2 IS AN INTERACTIVE TASK!");
        System.out.println("Enter the key of the any continent");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        while (!continents.containsKey(result)) {
            System.out.println("The continent with that key does not exist. Please try again!");
            result = sc.nextInt();
        }

        // continent was found
        List<CarMaker> filter = new ArrayList<>();
        for (CarMaker carMaker : carMakers)
            if (carMaker.getCountry() != null && carMaker.getCountry().getContinentId() == result)
                filter.add(carMaker);
        System.out.println("The CarMakers in " + continents.get(result) + " are:");
        for (CarMaker c : filter) {
            System.out.println("\t" + c);
        }
    }

    private static void task1() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (CarMaker x : carMakers) {
            if (x.getCountry() != null) {
                int continentId = x.getCountry().getContinentId();
                result.put(
                        continentId,
                        result.getOrDefault(continentId, 0) + 1);
            }
        }
        Map.Entry<Integer, Integer> keyValuePair = result.entrySet().stream().max(new ContinentMapComparator()).get();
        System.out.println("-------------------  Task 1  ------------------------");
        System.out.println("The continent with the maximum number of Car Makers is " +
                continents.get(keyValuePair.getKey()) +
                " with a maximum number of " +
                keyValuePair.getValue() +
                " car makers");
    }

    private static void readFiles() {
        // load continents
        continents = new HashMap<>();
        loadContinents(RES_DIRECTORY + "continents.csv");

        // load Countries
        loadCountries(RES_DIRECTORY + "countries.csv");

        // load makers
        carMakers = loadMakers(RES_DIRECTORY + "car-makers.csv");

        // load cars
        cars = new HashMap<>();
        loadCars(RES_DIRECTORY + "cars-data.csv");

        // load car models
        loadCarModels(RES_DIRECTORY + "car-names.csv");

        loadModelToMakerFile(RES_DIRECTORY + "model-list.csv");
    }

    private static void loadModelToMakerFile(String path) {
        Map<String, CarMaker> modelToMaker = new HashMap<>();

        // convert carMakers list to hashmap of id to carMaker
        Map<Integer, CarMaker> carMakerHashMap = carMakers
                .stream()
                .collect(Collectors.toMap(CarMaker::getId, carMaker -> carMaker));

        // fetch data and all to modelToMaker map
        List<String[]> readData = readCSV(path);
        if (readData != null) {
            for (String[] arr : readData) {
                int carMakerId = Integer.parseInt(arr[1]);
                CarMaker cm = carMakerHashMap.get(carMakerId);
                modelToMaker.put(arr[2], cm);
            }
        } else {
            System.out.println("Error reading model-list.csv file");
            System.exit(-1);
        }

        // loop the cars and update the makers
        for (var x : cars.entrySet()) {
            Car c = x.getValue();
            CarMaker cm = modelToMaker.get(c.getCarModel());
            if (cm != null) {
                c.setCarMaker(cm);
            }
        }
    }

    private static void loadCarModels(String path) {
        List<String[]> readData = readCSV(path);
        if (readData != null) {
            for (String[] arr : readData) {
                int carId = Integer.parseInt(arr[0]);
                String carModel = arr[1];
                cars.get(carId).setCarModel(carModel);
            }
        } else {
            System.out.println("Failed to read car-names file");
            System.exit(-1);
        }
    }

    private static void loadCars(String path) {
        List<String[]> readData = readCSV(path);
        if (readData != null) {
            for (String[] each : readData) {
                Car c = Car.fromList(each);
                cars.put(c.getCarId(), c);
            }
        } else {
            System.out.println("Failed to read cars-data file");
            System.exit(-1);
        }
    }

    private static void loadContinents(String path) {
        List<String[]> readData = readCSV(path);
        if (readData != null) {
            for (var x : readData) {
                continents.put(Integer.parseInt(x[0]), x[1]);
            }
        } else {
            System.out.println("Error reading continents file");
        }
    }

    private static List<CarMaker> loadMakers(String path) {
        List<CarMaker> makers = new ArrayList<>();
        List<String[]> readData = readCSV(path);
        if (readData != null) {
            for (var data : readData) {
                makers.add(CarMaker.fromList(data));
            }
        } else {
            System.out.println("Failed to read Car Maker file");
        }
        return makers;
    }

    private static void loadCountries(String path) {
        List<String[]> readData = readCSV(path);
        if (readData != null) {
            Country.loadCountries(readData);
        } else {
            System.out.println("Failed to load Countries");
            System.exit(-1);
        }
    }

    private static List<String[]> readCSV(String path) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(path));
            return csvReader.readAll().stream().skip(1).collect(Collectors.toList());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }
}