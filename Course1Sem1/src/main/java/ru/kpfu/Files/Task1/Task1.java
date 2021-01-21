package ru.kpfu.Files.Task1;

import java.io.*;
import java.util.Objects;
/**
 * Created by IntelliJ IDEA
 * Date: 26.11.2020
 * Time: 17:54
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: программа, которая копирует содержимое самого большого файла
 * из трех в самый маленький и копирует содержимое самого маленького файла в самый большой.
 */
public class Task1 {
    public static void swapLargestAndSmallestFile(String directory) throws IOException {
        File[] images = new File[0];
        File dir = new File(directory);
        File largestFile = null;
        long largestFileSize = 0;
        File smallestFile = null;
        long smallestFileSize = Long.MAX_VALUE;
        FileInputStream fis;
        FileOutputStream fos;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        byte[] bytes;


        //check if this is not a directory to prevent error throws
        if(!dir.isDirectory()){
            return ;
        }

        //add the image files to the array images
        for(File x: dir.listFiles()){
            if(x.getName().endsWith(".jpg")){
                File[] tempFile = new File[images.length+1];
                System.arraycopy(images,0,tempFile,0,images.length);
                tempFile[images.length] = x;
                images = tempFile;
            }
        }

        //if there is only one image.. no need to change anything
        if(images.length<=1){
            return;
        }
        //check for the largest and smallest files
        for(File x: images){
            if(x.length()>largestFileSize){
                largestFileSize=x.length();
                largestFile = x;
            }
            if(x.length()<=smallestFileSize){
                smallestFileSize = x.length();
                smallestFile = x;
            }
        }
        //makes sure the smallestFile and the largestFile are not one and the same
        if(Objects.equals(largestFile, smallestFile)){
            return ;
        }
        System.out.println("Largest file before operation is "+largestFile.getName());
        System.out.println("Smallest file before operation is "+smallestFile.getName());

        //create a new file temp which holds the value of the smallest file
        File tempFile = new File(directory+"/temp.jpg");
        fis = new FileInputStream(smallestFile);
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream(tempFile);
        bos = new BufferedOutputStream(fos);
        bytes = bis.readAllBytes();
        bos.write(bytes);
        fis.close();fos.close();
        bis.close();bos.close();

        //copy the contents of the largest file to the smallest file
        fis = new FileInputStream(largestFile);
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream(smallestFile);
        bos = new BufferedOutputStream(fos);
        bytes = bis.readAllBytes();
        bos.write(bytes);
        System.out.println("Largest file after operation is "+smallestFile.getName());
        fis.close();fos.close();
        bis.close(); bos.close();

        //copy the contents of the tempFile to the largest file
        fis = new FileInputStream(tempFile);
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream(largestFile);
        bos = new BufferedOutputStream(fos);
        bytes = bis.readAllBytes();
        bos.write(bytes);
        System.out.println("Smallest file after operation is "+largestFile.getName());
        fis.close(); fos.close();
        bis.close(); bos.close();
        //delete the tempFile
        tempFile.delete();
    }

    public static void main(String[] args) {
        String directory = "./src/main/java/ru/kpfu/Files/Task1";
        try {
            long start = System.nanoTime();
            swapLargestAndSmallestFile(directory);
            System.out.println(System.nanoTime()-start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
