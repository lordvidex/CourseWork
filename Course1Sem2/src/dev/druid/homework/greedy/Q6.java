package dev.druid.homework.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * Date: 29.05.2021
 * Time: 5:46 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Q6 {
    private static String solve(Map<Character, List<Integer>> orig,
                                Map<Character, List<Integer>> op,
                                char wildcard) {
        for (var x : orig.entrySet()) {
            Collections.sort(x.getValue());
        }
        for (var x : op.entrySet()) {
            for (int y : x.getValue()) {
                boolean done = false;
                if(orig.containsKey(x.getKey())) {
                    for (Integer z : orig.get(x.getKey())) {
                        if (z > y) {
                            done = true;
                            orig.get(x.getKey()).remove(z);
                            break;
                        }
                    }
                }
                if (!done) {
                    // check the wildcards
                    if(orig.containsKey(wildcard)) {
                        for (Integer z : orig.get(wildcard)) {
                            if (x.getKey() != wildcard || z > y) {
                                orig.get(wildcard).remove(z);
                                done = true;
                                break;
                            }
                        }
                    }
                    if(!done){
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }

    private static int rankFromChar(char rank) {
        switch (rank) {
            case 'T': return 10;
            case 'J' : return 11;
            case 'Q':return 12;
            case 'K' :return 13;
            case 'A' :return 14;
            default : return rank - '0';
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.ni();
        int m = sc.ni();
        char w = sc.nc()[0];
        Map<Character, List<Integer>> map = new HashMap<>();
        Map<Character, List<Integer>> op = new HashMap<>();
        sto(sc, n, map);
        sto(sc, m, op);

        pw.println(solve(map, op, w));
        sc.close();
        pw.close();
    }

    private static void sto(FastScanner sc, int m, Map<Character, List<Integer>> map) {
        for (int i = 0; i < m; i++) {
            char[] x = sc.nc();
            if (!map.containsKey(x[1])) {
                map.put(x[1], new ArrayList<>());
            }
            map.get(x[1]).add(rankFromChar(x[0]));
        }
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
