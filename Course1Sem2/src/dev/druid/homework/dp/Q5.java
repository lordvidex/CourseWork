package dev.druid.homework.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA
 * Date: 07.06.2021
 * Time: 2:38 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0100  Счастливые билеты Динамическое программирование 68%  71% 1187
 */
public class Q5 {
    private static BigInteger solve(int n){
        BigInteger[][] d = new BigInteger[1000][1000];
        for (int i = 0; i <= 100; i++)
            Arrays.fill(d[i], new BigInteger("0"));

        for (int i = 0; i <= 9; i++)
            d[1][i] = new BigInteger("1");

        for(int i = 2; i <= n / 2; i++)
            for(int j = 0; j <= i * 9; j++)
                for(int k = 0; k <= 9; k++) {
                    BigInteger T;
                    T = d[i][j];
                    if(j - k >= 0)
                        T = T.add(d[i - 1][j - k]);
                    d[i][j] = T;
                }
        BigInteger C = new BigInteger("0");
        for(int j = 0; j <= 9 * (n / 2); j++)
            C = C.add(d[n / 2][j].multiply(d[n / 2][j]));
        return C;
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.ni();
        pw.println(solve(n));
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
