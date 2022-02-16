package dev.druid.homework.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA
 * Date: 27.05.2021
 * Time: 9:25 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0120  Минимальный путь в таблице Динамическое программирование 32%  92%
 */
public class Q10 {

    private static int solve(int[][] table, int[][] memo) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        memo[i][j] = table[i][j];
                    } else {
                        memo[i][j] = memo[i][j - 1] + table[i][j];
                    }
                } else {
                    if (j == 0) {
                        memo[i][j] = table[i][j] + memo[i - 1][j];
                    } else {
                        memo[i][j] = table[i][j] + Math.min(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
            }
        }
        return memo[memo.length-1][memo[0].length-1];
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.ni();
        int m = sc.ni();
        int[][] table = new int[n][m];
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = sc.ni();
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        pw.println(solve(table, memo));
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
