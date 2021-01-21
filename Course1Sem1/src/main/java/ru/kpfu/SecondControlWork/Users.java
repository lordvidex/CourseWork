package ru.kpfu.SecondControlWork;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA
 * Date: 26.12.2020
 * Time: 17:35
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * **********************************
 * 1. Считать файл csv в массив, каждая строка (кроме первой) которого является объектом типа User (см. задание 2).
 * Реализовать методы load, save, saveAs.
 * Реализовать метод getUserById, получающий объект типа User, по id (id != номер строки).
 */
//.........1..........
public class Users {
    //constants
    private final String parentDirectory = "./src/main/java/ru/kpfu/SecondControlWork/";
    private final String DELIMETER = ";";

    //filename passed to constructor
    private final String filename;

    //filename of new data to be saved when data is changed
    private String currentDataTrayFileName;

    //users read from the first file when data is loaded
    private User[] users;

    //users stored when data is changed
    //e.g. when @findUserWithParam() is called
    private User[] dataTray;

    public Users(String filename) {
        this.filename = filename;
        load();
    }

    public User[] getUsers() {
        return users;
    }

    //function that loads data from the default file into the
    //array `users`
    private void load() {
        ArrayList<User> usersList = new ArrayList<>();
        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(parentDirectory + filename));
            System.out.println("..........................Loading file.........................");
            User.HEADER = bufferedReader.readLine().split(DELIMETER);
            while ((line = bufferedReader.readLine()) != null) {
                usersList.add(new User(line.split(DELIMETER)));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.users = usersList.toArray(new User[0]);
        this.dataTray = this.users;
        this.currentDataTrayFileName = "MOCK_DATA.csv";
    }

    //save is the same as saveAs() but with an already known
    //filename
    public void save() {
        saveAs(currentDataTrayFileName);
    }

    //function that write data from the array of Users to the
    //file specified by `newFilename`
    public void saveAs(String newFilename) {

        File newFile = new File(parentDirectory + newFilename);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
            //System.out.println("............................saving file........................");
            bw.write(String.join(DELIMETER, User.HEADER) + '\n');
            //sout.. for debug
            System.out.println(String.join(DELIMETER, User.HEADER));
            for (User user : dataTray) {
                bw.write(String.join(DELIMETER, user.getDataArr()) + '\n');
                //sout.. for debug
                System.out.println(String.join(DELIMETER, user.getDataArr()));
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write to file" + newFile.getAbsolutePath() + "\nChange the path specified manually...");
        }
    }


    public User getUserById(int id) {
        for (User currentUser : users) {
            if (currentUser.getId() == id) return currentUser;
        }
        return null;
    }

    //METHODS THAT CHANGE DATA STATE

    //finds @param `needle` in @param `haystack` and stores the gotten data
    //in the dataTray array with a generated name stored in `currentDataTrayFileName
    public void findUsersWithParam(String haystack, String needle) {
        currentDataTrayFileName = "UsersWithParam" + needle + "In" + haystack + ".csv";
        ArrayList<User> userFilter = new ArrayList<>();
        for (User user : users) {
            if (user.isNeedleInHaystack(needle, haystack)) {
                userFilter.add(user);
            }
        }
        dataTray = userFilter.toArray(new User[0]);
    }
}
