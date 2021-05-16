package dev.druid.classwork.classwork20;

import dev.druid.classwork.classwork19.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by IntelliJ IDEA
 * Date: 26.04.2021
 * Time: 3:09 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class ColoredVertex<T> extends Vertex<T> {
    public int color;
    public Set<ColoredVertex<T>> children;

    public ColoredVertex(T value) {
        super(value);
        this.children = new HashSet<>();
    }

    public ColoredVertex(T value, int color) {
        this(value);
        this.color = color;
    }

    public static ColoredVertex<Integer>[] colorGraph(Vertex<Integer>[] graph) {
        int[] colors = new int[graph.length];
        colors[0] = 1;
        if (recursivePaint(1, colors, graph)) {
            ColoredVertex<Integer>[] ans = new ColoredVertex[graph.length];
            for (int i = 0; i < graph.length; i++) {
                ans[i] = new ColoredVertex<Integer>(graph[i].value, colors[i]);
            }
            // get children from graph
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i].children.contains(graph[j])) {
                        ans[i].children.add(ans[j]);
                    }
                }
            }
            return ans;
        }
        return null;
    }

    // painting graphs with color of at most 4
    private static boolean recursivePaint(int k, int[] colors, Vertex<Integer>[] graph) {
        for (int c = 1; c <= 4; c++) {
            if (isSafe(k, c, colors, graph)) {
                colors[k] = c;
                if (k + 1 < colors.length) {
                    if (recursivePaint(k + 1, colors, graph))
                        return true;
                    colors[k] = 0;
                } else
                    return true;
            }
        }
        return false;
    }

    private static boolean isSafe(int k, int c, int[] colors, Vertex<Integer>[] graph) {
        for (int i = 0; i < colors.length; i++) {
            if (graph[k].children.contains(graph[i]) && c == colors[i]) {
                return false;
            }
        }
        return true;
    }

    private String printChildren() {
        return "{" +
                this.children.stream()
                        .map(c -> c.value.toString())
                        .collect(Collectors.joining(",")) +
                "}";

    }

    @Override
    public String toString() {
        return "ColoredVertex{" +
                "value= " + value +
                ", children= " + printChildren() +
                " color= " + color +
                '}';
    }
}
