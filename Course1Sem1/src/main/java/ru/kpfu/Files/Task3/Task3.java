package ru.kpfu.Files.Task3;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by IntelliJ IDEA
 * Date: 26.11.2020
 * Time: 20:40
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: программа которая считает данную матрицу в файле
 * в двумерный массив и вывести на консоль
 */
public class Task3 {
    public static void printMatrix(File file) throws IOException {
        double[][] matrix = new double[0][];
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            double[][] tempArr = new double[matrix.length+1][];
            double[] temp = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
            System.arraycopy(matrix,0,tempArr,0,matrix.length);
            tempArr[matrix.length] = temp;
            matrix = tempArr;
        }
        br.close();fr.close();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        String directory = "./src/main/java/ru/kpfu/Files/Task3";
        File file = new File(directory + "/matrix.txt");
        printMatrix(file);
    }
}
