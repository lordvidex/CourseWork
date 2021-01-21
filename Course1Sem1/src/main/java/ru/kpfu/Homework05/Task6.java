package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 18.10.2020
 * Time: 19:53
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: выделение из строки расширение файла
 */
public class Task6 {
    public static String getExtensionFromPath(String str){
        if(!str.contains(".")){
            System.out.println("Not a valid file");
            return "";
        }
        return str.substring(str.lastIndexOf('.')+1);
    }
    public static void main(String[] args) {
        String path = "MyJava.py";
        String anotherPath = "C:\\User\\Owamoyo\\Desktop\\Codeforces\\MyJava.cpp";
        System.out.println("расширение файла: "+getExtensionFromPath(path));
        System.out.println("расширение файла: "+getExtensionFromPath(anotherPath));
    }
}
