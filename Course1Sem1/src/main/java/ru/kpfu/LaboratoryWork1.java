package ru.kpfu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 07.10.2020
 * Time: 22:38
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: solving systems of linear equations using Gauss method
 *
 */

public class LaboratoryWork1 {
    public static String convertFloatToFraction(double fraction){
        if(fraction<0){
            return "-"+convertFloatToFraction(-fraction);
        }
        double tolerance = 1E-6;
        double h1 = 1, h2 = 0, k1=0,k2=1;
        double b = fraction;
        do{
            double a = Math.floor(b);
            double temp = h1;
            h1 = h1*a+h2;h2=temp;
            temp = k1;
            k1 = k1*a+k2; k2 = temp;
            b = 1/(b-a);
        }while(Math.abs(fraction-h1/k1)>tolerance*fraction);
        return (long)h1+"/"+(long)k1;
    }

    public static double[] reduceMatrixRow(double[] row, double factor){
        for (int i = 0; i < row.length; i++) {
            row[i]/=factor;
        }
        return row;
    }

    public static double[] addMatrixRow(double[] homeRow, double[] additiveRow){
        for (int i = 0; i < homeRow.length; i++) {
            homeRow[i] += additiveRow[i];
        }
        return homeRow;
    }

    public static double[] addMatrixRow(double[] homeRow, double[] additiveRow, double factor){
        for (int i = 0; i < homeRow.length; i++) {
            homeRow[i] += factor*additiveRow[i];
        }
        return homeRow;
    }

    public static double[] transformMatrix(double [][] matrix){
        double[] answer = new double[matrix.length];
        //check if we don't have 0 in principal diagonal
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[j][i] != 0) {
                        matrix[i] = addMatrixRow(matrix[i], matrix[j]);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = reduceMatrixRow(matrix[i],matrix[i][i]);
            for (int j = 0; j < matrix.length; j++) {
                if((j!=i)&&matrix[j][i]!=0){
                    matrix[j] = addMatrixRow(matrix[j],matrix[i],-1*matrix[j][i]/matrix[i][i]);
                }
            }
        }
        System.out.println("\nпреобразование в Форму единичного матрицы \n");
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%4.2f ", doubles[j]);
            }
            System.out.println();
        }
        for (int i = 0; i < matrix.length; i++) {
            answer[i] = matrix[i][matrix.length];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [][] matrix = new double [n][n+1];
        // @TEST: double [][] matrix = {{0,1,2,1},{1,0,3,2},{2,1,0,3},}; //ANSWER: {5/4,1/2,1/4};


        //generation of numbers in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int)((-1*Math.max(5,n))+Math.random()*(Math.max(5,n)*2));
            }
        }

        //generation of answers to linear equations
        System.out.println("Матрица Системы: \n");
        for (int i = 0; i < n; i++) {
            matrix[i][n] = (int)(Math.random()*n*n);
            for (int j = 0; j < n + 1; j++) {
                System.out.printf(j!=n?"%2.0f ":"|%2.0f",matrix[i][j]);
            }
            System.out.println();
        }

        double[] transformedMatrix = transformMatrix(matrix);
        String[] fractionForm = new String[transformedMatrix.length];
        for (int i = 0; i < transformedMatrix.length; i++) {
            fractionForm[i] = convertFloatToFraction(transformedMatrix[i]);
        }
        System.out.printf("Решения Системы: %s",Arrays.toString(fractionForm));
    }
}
