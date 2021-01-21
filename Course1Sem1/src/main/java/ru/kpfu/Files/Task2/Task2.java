package ru.kpfu.Files.Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Created by IntelliJ IDEA
 * Date: 26.11.2020
 * Time: 17:54
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: программа, которая сортирует числа,
 * полученные из 3-х различных текстовых файлов, и сохраняет их в новом файле
 */
public class Task2 {
    public static void mergeFileNumbers(String directory) throws IOException {
        Integer[] list = new Integer[0];
        Scanner sc;
        File currFile = new File(directory);
        if(!currFile.isDirectory()){
            return ;
        }
        for(File x: currFile.listFiles()){
            if(x.getName().equals("answer.txt"))continue;
            sc = new Scanner(x);
            while(sc.hasNextInt()){
                Integer[] temp = new Integer[list.length+1];
                System.arraycopy(list,0,temp,0,list.length);
                temp[list.length] = sc.nextInt();
                list = temp;
            }
            sc.close();
        }
        Arrays.sort(list, Comparator.reverseOrder());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            if(i!=0)builder.append(" ");
            builder.append(list[i]);
        }
        String ans = builder.toString();
        File answer = new File(directory+"/answer.txt");
        FileWriter fileWriter = new FileWriter(answer);
        fileWriter.write(ans);
        fileWriter.close();
    }
    public static void main(String[] args) {
        String directory = "./src/main/java/ru/kpfu/Files/Task2";
        try {
            mergeFileNumbers(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
