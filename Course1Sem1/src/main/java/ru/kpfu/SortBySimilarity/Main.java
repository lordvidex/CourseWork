package ru.kpfu.SortBySimilarity;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * Date: 14.12.2020
 * Time: 12:13
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {

    //map to memoize result in case of duplicate items
    private static final HashMap<String, Integer> map = new HashMap<>();


    /**
     * Метод который возвращает число одинаковых букв
     * в двух заданных строках
     *
     * @param check: reference string containing the pivot
     * @param match: string that is checked
     * @return matches of type int
     */
    private static int computeMatches(String check, String match) {
        check = check.toLowerCase();
        match = match.toLowerCase();
        int count = 0;
        int minlength = Math.min(check.length(), match.length());
        for (int i = 0; i < minlength; i++) {
            if (check.charAt(i) == match.charAt(i)) count++;
        }
        map.put(match, count);
        return count;
    }

    /**
     * @param ref  Reference string that is usually the pivot string
     * @param left first string
     * @param right second string
     * @return <true/> if left >= right or <false/> otherwise
     */
    private static boolean moreMatched(String ref, String left, String right) {
        int leftCount, rightCount;
        if (map.containsKey(left)) {
            leftCount = map.get(left);
        } else {
            leftCount = computeMatches(ref, left);
        }
        if (map.containsKey(right)) {
            rightCount = map.get(right);
        } else {
            rightCount = computeMatches(ref, right);
        }
        return leftCount>=rightCount;
    }

    //method for swapping two positions in the Array *arr*
    private static void swap(String[] arr,int left, int right){
        if(left==right)return ;
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * @param ref reference string
     * @param arr the array of strings to be sorted
     * @param left start position
     * @param right end position
     * @return [ch+1] of type int, the pivotPos where values to the left are
     * greater and values to the right have lesser number of matches than the pivot.
     */
    public static int getPivotPos(String ref, String[] arr, int left, int right) {
        String pivot = arr[right];
        int ch = left - 1;
        for (int i = left; i < right; i++) {
            if (moreMatched(ref, arr[i], pivot)) {
                swap(arr, i, ++ch);
            }
        }
        swap(arr, right, ch + 1);
        return ch + 1;
    }
    public static String[] quickSortBySimilarity(String ref, String[] arr){
        String[] newarr = new String[arr.length];
        System.arraycopy(arr,0,newarr,0,arr.length);
        quickSortEngine(ref,newarr);
        return newarr;
    }
    public static void quickSortEngine(String ref, String[] arr) {
        quickSortEngine(ref, arr, 0, arr.length - 1);
    }

    public static void quickSortEngine(String ref, String[] arr, int left, int right) {
        if (left < right) {
            int pivotPos = getPivotPos(ref, arr, left, right);
            quickSortEngine(ref, arr, left, pivotPos - 1);
            quickSortEngine(ref, arr, pivotPos + 1, right);
        }
    }

    public static void main(String[] args) {
        String reference = "asdf";
        String[] strArray = new String[]{"ssfd", "fda", "a", "asdf", "ASfd"};

        String[] sortedArray = quickSortBySimilarity(reference, strArray);

        System.out.println("Start String: "+reference);
        System.out.printf("Before sorting: %s%n", Arrays.toString(strArray));
        System.out.printf("After sorting: %s%n",Arrays.toString(sortedArray));
    }
}
