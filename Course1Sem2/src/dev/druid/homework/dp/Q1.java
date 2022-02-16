package dev.druid.homework.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA
 * Date: 27.05.2021
 * Time: 3:13 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0011  Зайчик Динамическое программирование 55%  68% 7788
 */
public class Q1 {
    static FastScanner sc;
    static PrintWriter pw;

    public static void solve(int k, int n) {
        BigInteger[] b = new BigInteger[n+1];
        b[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            BigInteger summ = BigInteger.ZERO;
            for (int j = 1; j <= k; j++) {
                if ((i - j) >= 0) {
                    summ = summ.add(b[i-j]);
                }else {
                    break;
                }
            }
            b[i] = summ;
        }
        pw.println(b[n]);
    }

    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        int k = sc.ni();
        int n = sc.ni();
        solve(k, n);

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
