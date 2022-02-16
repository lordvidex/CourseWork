package dev.druid.homework.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 02.06.2021
 * Time: 11:59 AM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p> TODO: -> 3
 * Desc: 0806  Белоснежка и n гномов Жадный алгоритм 46%  63% 180
 */
public class Q8 {
    static class Gnome implements Comparable<Gnome>{
        int pos;
        long a;
        long b;
        Gnome(int pos, int a, int b){
            this.pos = pos;
            this.a  = a;
            this.b= b;
        }

        @Override
        public int compareTo(Gnome o) {
            return (int) -((this.a+this.b)-(o.a+o.b));
        }
    }
    private static String solve(Gnome[] arr){
        Arrays.sort(arr);
        long rest = arr[0].b;
        for (int i = 1; i < arr.length; i++) {
            rest-=arr[i].a;
            if(rest<=0){
                return "-1";
            }
        }
        return Arrays.stream(arr).map(g->String.valueOf(g.pos+1))
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.ni();
        Gnome[] arr = new Gnome[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Gnome(i,sc.ni(),sc.ni());
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