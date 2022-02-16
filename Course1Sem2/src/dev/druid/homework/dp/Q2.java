package dev.druid.homework.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA
 * Date: 27.05.2021
 * Time: 3:13 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0029  Компьютерная игра Динамическое программирование 38%  72% 6540
 */
public class Q2 {
    static FastScanner sc;
    static PrintWriter pw;

    public static long solve(int[] arr) {
        long[] memo = new long[arr.length];
        Arrays.fill(memo,0);
        if(arr.length== 1){
            return 0;
        }
        memo[1] = Math.abs(arr[1]-arr[0]);
        for (int i = 2; i < arr.length; i++) {
            memo[i] = Math.min(
                      memo[i-1] + Math.abs(arr[i]-arr[i-1]),
                    memo[i-2]+ 3L *Math.abs(arr[i]-arr[i-2])
            );
        }
        return memo[arr.length-1];
    }

    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        int n = sc.ni();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.ni();
        }
        pw.println(solve(arr));
        sc.close();
        pw.close();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

//        public FastScanner(String filePath) {
//            try {
//                br = new BufferedReader(new FileReader(filePath));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
            return Double.parseDouble(next());
        }

        /**
         * @return an array of characters from the string read using next();
         */
        char[] nc() {
            return next().toCharArray();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
