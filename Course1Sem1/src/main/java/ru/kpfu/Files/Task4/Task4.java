package ru.kpfu.Files.Task4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA
 * Date: 26.11.2020
 * Time: 21:33
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: программа которая посчитает количество абзацев в md файл
 */
public class Task4 {
    public static void countParagraphs(String mdFilePath) throws IOException {
        File mdFile = new File(mdFilePath);
        int count = 0;
        Pattern pattern;
        Matcher matcher;
        StringBuilder builder= new StringBuilder();
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(mdFile));

        //проверять может быть это md файл
        if(!mdFile.getName().endsWith("md")){
            System.out.println("Not an md file");
            return ;
        }

        while((line  = bufferedReader.readLine())!=null){

            //add new line to an header in case there is no space
            pattern = Pattern.compile("\\s{0,3}#+");
            matcher = pattern.matcher(line);
            if(matcher.find()){
                line = line+"\n";
            }
            builder.append(line);
            builder.append('\n');

        }
        bufferedReader.close();
        String[] splittedString = builder.toString().split("\\n\\s*\\n");
        for(String x: splittedString){
            pattern = Pattern.compile("^\\w");
            matcher = pattern.matcher(x);
            if(matcher.find()){
                count++;
            }
        }
        System.out.println("File "+mdFile.getName()+" has "+count+" paragraphs");
    }
    public static void main(String[] args) {
        String mdFilePath = "./src/main/java/ru/kpfu/Files/Task4/example.md";
        String mdFilePath2 = "./src/main/java/ru/kpfu/Files/Task4/example2.md";
        try {
            countParagraphs(mdFilePath);
            countParagraphs(mdFilePath2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
