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
 * Time: 8:30 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0114  Без двух нулей подряд Динамическое программированиеДа 37%  96% 6398
 */
public class Q8 {
    static FastScanner sc;
    static PrintWriter pw;

    private static int f(int step, int number, int k, int n, int[][] memo) {
        if (step == n) {
            return 1;
        }
        int memoized;
        if (number == 0) {
            memoized = memo[step][0];
        } else {
            memoized = memo[step][1];
        }
        if (memoized != 0) {
            return memoized;
        }

        int ans = 0;
        for (int i = number == 0 ? 1 : 0; i < k; i++) {
            ans+=f(step + 1, i, k, n, memo);
        }
        memo[step][number==0?0:1] = ans;
        return ans;
    }

    private static void solve(int n, int k) {
        int[][] memo = new int[n + 1][];
        for (int i = 0; i < memo.length; i++) {
            memo[i]= new int[2];
        }
        int ans = (k-1)*f(1, 1, k, n, memo);
        pw.println(ans);
    }

    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        int n = sc.ni();
        int k = sc.ni();
        solve(n, k);
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
