package dev.druid.classwork.classwork21;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * Created by IntelliJ IDEA
 * Date: 28.04.2021
 * Time: 4:46 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String directory = "src/dev/druid/classwork/classwork21/";
        // file with n random bytes
        createFileWithNBytes(directory,50);
        // copy file1 to file2
        copyFile1ToFile2(directory,"file1.txt","file2.txt");
        downloadFromUrlIntoFile(directory,"download.txt");
    }
    public static void createFileWithNBytes(String directory, int n) throws IOException{

        File file1 = new File(directory+"file1.txt");
        FileOutputStream fos = new FileOutputStream(file1);
        Random random = new Random();
        byte[] arr = new byte[n];
        random.nextBytes(arr);
        fos.write(arr);
        fos.close();
    }
    public static void copyFile1ToFile2(String directory,String file1,String file2) throws IOException{
        FileInputStream fis = new FileInputStream(directory+file1);
        FileOutputStream fos = new FileOutputStream(directory+file2);
        fos.write(fis.readAllBytes());
        fis.close();
        fos.close();
    }
    public static void downloadFromUrlIntoFile(String directory,String filename) throws IOException {
        URL url = new URL("http://www.google.com");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        FileOutputStream fos = new FileOutputStream(directory+filename);
        fos.write(is.readAllBytes());
        fos.close();
        is.close();
    }
}
