package dev.druid.homework.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA
 * Date: 31.05.2021
 * Time: 10:35 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc: 0739  Дана строка Жадный алгоритм 37%  53% 88
 * TC -> 9
 */
public class Q7 {
    private static void swap(int from, int to, char[] ch, int[] arr) {
        char tch = ch[from];
        int tpos = arr[from];
        int dist = Math.abs(from - to);

        ch[from] = ch[to];
        arr[from] = arr[to] - dist;
        ch[to] = tch;
        arr[to] = tpos - dist;
    }

    private static String solve(String s, int k) {
        char[] ch = s.toCharArray();
        int[] arr = new int[ch.length];
        Arrays.fill(arr, k);

        for (int i = ch.length - 1; i > 0; i--) {
            for (int l = 0; l < k; l++) {
                char min = ch[i];
                int minpos = i;
                for (int j = 1; j <= arr[i]; j++) {
                    if ((i + j) < ch.length && ch[i + j] < min && arr[i + j] >= j) {
                        min = ch[i + j];
                        minpos = i + j;
                    }
                }
                // max exists, swap and update counter arrays
                if (min != ch[i]) {
                    swap(minpos, i, ch, arr);
                }

                char max = ch[i];
                int maxpos = i;
                for (int j = 1; j <= arr[i]; j++) {
                    if ((i - j) >= 0 && arr[i - j] >= j && ch[i - j] > max) {
                        max = ch[i - j];
                        maxpos = i - j;
                    }
                }
                // max exists, swap and update counter arrays
                if (max != ch[i]) {
                    swap(maxpos, i, ch, arr);
                }
            }
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);

        int k = sc.ni();
        String s = sc.next();
        pw.println(solve(s, k));
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
