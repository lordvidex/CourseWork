package dev.druid.classwork.classwork22;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * Created by IntelliJ IDEA
 * Date: 29.04.2021
 * Time: 4:55 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String directory = "src/dev/druid/classwork/classwork22/";
        // file with n random bytes
        createFileWithNBytes(directory,50);
        // copy file1 to file2
        copyFile1ToFile2(directory,"file1.txt","file2.txt");
        downloadFromUrlIntoFile(directory,"download.txt");

    }

    private static void copyFile1ToFile2(String directory, String file1, String file2) throws IOException {
        OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(directory+file2));
        InputStreamReader fis = new InputStreamReader(new FileInputStream(directory+file1));
        int x;
        while((x = fis.read())!=-1){
            fos.write(x);
        }
        fis.close();
        fos.close();
    }
    public static void downloadFromUrlIntoFile(String directory,String filename) throws IOException {
        InputStream is = new URL("http://www.google.com")
                .openConnection()
                .getInputStream();
        OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(directory+filename));
        int b;
        while((b = is.read())!=-1){
            fos.write((char)(byte)b);
        }
        fos.close();
        is.close();
    }
    public static void createFileWithNBytes(String directory, int n) throws IOException {

        File file1 = new File(directory+"file1.txt");
        OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(file1));
        Random random = new Random();

        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (char)((byte)random.nextInt());
        }
        fos.write(arr);
        fos.close();
    }
}
