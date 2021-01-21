package ru.kpfu.Files.Task5;

import java.io.*;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA
 * Date: 26.11.2020
 * Time: 23:38
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: программа, которая хранит все символы в данном файле
 * в другом созданном файле без повторения и в порядке возрастания.
 */
public class Task5 {
    public static void extractCharacters(String filePath) throws IOException {
        File currFile = new File(filePath);
        String line;
        StringBuilder strBuilder = new StringBuilder();
        TreeSet<Character> treeSet = new TreeSet<>();

        BufferedReader bfr = new BufferedReader(new FileReader(currFile));

        while((line = bfr.readLine())!=null) {
            line.codePoints().forEach((x) -> treeSet.add((char) x));
        }
        bfr.close();
        for (Character character : treeSet) {
            strBuilder.append(character);
        }
        File answer = new File(currFile.getParent()+"/answer.txt");
        FileWriter fw = new FileWriter(answer);
        fw.write(strBuilder.toString());
        fw.close();
    }
    public static void main(String[] args) {
        String filePath = "./src/main/java/ru/kpfu/Files/Task5/sample.txt";
        try {
            //ответ будет в файл <<answer.txt>>
            extractCharacters(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
