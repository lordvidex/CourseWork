package ru.kpfu.FindFiles;

/**
 * Created by IntelliJ IDEA
 * Date: 23.09.2020
 * Time: 12:00
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: программа поиска
 */
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {
    static File[] files = new File[0];

    /** recursive finding of all files
    * @NOTE  file returns null when user has no file permission unless code is run
    * with administrative privileges
     */
    public static void getAllFiles(String path) {
        File fl = new File(path);
        //if(!fl.canRead())return;
        File[] temp = new File[files.length+1];
        System.arraycopy(files,0,temp,0,files.length);
        temp[files.length] = fl;
        files = temp;
        if (fl.isDirectory()) {
            for (File fls : fl.listFiles()) {
                getAllFiles(fls.getAbsolutePath());
            }
        }
    }

    public static File[] findFiles(String path, String find) {
        File[] answer  = new File[0];
        getAllFiles(path);
        find = find.replaceAll("\\.", "\\\\.");
        find = find.replaceAll("\\*", ".*");
        Pattern pattern = Pattern.compile(find);
        Matcher matcher;
        for (File file : files) {
            matcher = pattern.matcher(file.getName());
            if (matcher.find()) {
                File[] newFile = new File[answer.length+1];
                System.arraycopy(answer, 0, newFile, 0, answer.length);
                newFile[answer.length] = file;
                answer = newFile;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String path = ".";
        for (File file : findFiles(path, "*.java")) {
            System.out.println(file.getName());
        }
    }
}
