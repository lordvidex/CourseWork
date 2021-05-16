package dev.druid.classwork.classwork20;

import dev.druid.classwork.classwork19.Vertex;

import javax.swing.plaf.ColorUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 26.04.2021
 * Time: 2:46 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    static List<Character> vowels = List.of(new Character[]{'a', 'e', 'i', 'o', 'u'});

    public static void main(String[] args) {
        abcTask();
        ColoredVertex<Integer>[] example = ColoredVertex.colorGraph(
                dev.druid.classwork.classwork19.Main.adjMatrixToAdjList(
                        dev.druid.classwork.classwork19.Main.edgesToAdjMatrix(
                                dev.druid.classwork.classwork19.Main.readEdges())));

        if(example!=null){
            for(ColoredVertex<Integer> x: example){
                System.out.println(x);
            }
        }
    }

    private static void abcTask() {
        String[] choices = new String[]{"a", "b", "c"};
        ArrayList<String> answer = new ArrayList<>();
        solve(choices, "", answer);

        for (String x : answer) {
            System.out.println(x);
        }
    }

    private static boolean threeConsonant(String string) {
        if (string.length() < 3) return false;
        for (int i = 1; i <= 3; i++) {
            if (vowels.contains(string.charAt(string.length() - i))) return false;
        }
        return true;
    }

    private static boolean check(String string) {

        if (string.isEmpty() || string.length() == 1) {
            return true;
        } else return (string.charAt(string.length() - 1) != 'a'
                || string.charAt(string.length() - 2) != 'a')
                && !threeConsonant(string);
    }

    private static void solve(String[] choices, String string, ArrayList<String> answer) {
        if (string.length() == 5) answer.add(string);
        else {
            for (String choice : choices) {
                if (check(string + choice)) {
                    solve(choices, string + choice, answer);
                }
            }
        }
    }
}
