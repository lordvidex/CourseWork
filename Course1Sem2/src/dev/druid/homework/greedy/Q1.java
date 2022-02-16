package dev.druid.homework.greedy;

import java.util.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA
 * Date: 27.05.2021
 * Time: 10:41 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0449  Плавающие числа Жадный алгоритм 41%  79% 746
 */
public class Q1 {
    static class Pair {
        int left;
        int right;

        public Pair() {
        }

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean enters(int left, int right) {
            if (left > this.right || right < this.left) {
                return false;
            } else if (left >= this.left || right <= this.right) {
                this.left = Math.max(left, this.left);
                this.right = Math.min(right, this.right);
                return true;
            }
            return false;
        }
    }

    private static int solve(int l, int[] arr) {
        Set<Pair> pairs = new HashSet<>();
        Arrays.sort(arr);
        for (int j : arr) {
            boolean fixed = false;
            for (Pair p : pairs) {
                if (p.enters(j - l, j + l)) {
                    fixed = true;
                    break;
                }
            }
            if (!fixed) {
                pairs.add(new Pair(j - l, j + l));
            }
        }
        return pairs.size();
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int l = sc.ni();
        int n = sc.ni();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.ni();
        }
        pw.println(solve(l, arr));

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
