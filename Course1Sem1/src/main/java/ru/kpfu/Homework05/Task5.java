package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 18.10.2020
 * Time: 19:32
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: выделение имя файла из строки
 */
public class Task5 {
    public static String getNameFromPath(String path){
        String removedDirectory;
        String removedExtension;
        removedDirectory = path.substring(Math.max(path.lastIndexOf('/')+1,path.lastIndexOf('\\')+1));
        removedExtension = removedDirectory.substring(0,removedDirectory.lastIndexOf('.'));
        return removedExtension;
    }
    public static void main(String[] args) {
        String path = "MyJava.py";
        String anotherPath = "C:\\User\\Owamoyo\\Desktop\\Codeforces\\MyJava.cpp";
        System.out.println("Имя файла: "+getNameFromPath(path));
        System.out.println("Имя файла: "+getNameFromPath(anotherPath));
    }
}
