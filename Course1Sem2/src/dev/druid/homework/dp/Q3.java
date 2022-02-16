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
 * Time: 6:49 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * <<UNSOLVED>>
 *     TODO: solve this!
 * Desc: 0038  Игра - 2 Динамическое программирование 45%  71% 2619
 */
public class Q3 {
    static FastScanner sc;
    static PrintWriter pw;

    private static void solve(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int c = 0;
        long p1 = 0;
        long p2 = 0;
        while (l <= r) {
            if (arr[l] >= arr[r]) {
                if (c % 2 == 0) p1 += arr[l];
                else p2 += arr[l];
                l++;
            } else {
                if (c % 2 == 0) p1 += arr[r];
                else p2 += arr[r];
                r--;
            }
            c++;
        }
        pw.println(p1 > p2 ? "1" : p1 < p2 ? "2" : "0");
    }

    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        int n = sc.ni();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.ni();
        }
        solve(arr);
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
