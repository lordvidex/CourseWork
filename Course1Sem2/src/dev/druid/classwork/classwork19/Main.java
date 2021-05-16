package dev.druid.classwork.classwork19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * Date: 23.04.2021
 * Time: 12:57 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    public static void main(String[] args) {
        Edge[] edges = readEdges();
        int[][] adjMatrix = edgesToAdjMatrix(edges);

        // check in terminal
        printAdjMatrix(adjMatrix);

        Vertex<Integer>[] adjList = adjMatrixToAdjList(adjMatrix);

        // check in terminal
        printAdjList(adjList);

        // bfs can be used but a root must be provided e.g. 6
        bfsTransversal(adjList, 5);
        // dfs can be used but a root must be provided e.g. 6
        dfsTransversal(adjList, 5);
    }

    private static void dfsTransversal(Vertex<Integer>[] adjList, int rootPosition) {
        System.out.println("DFS Transversal");
        HashSet<Vertex<Integer>> visited = new HashSet<>();
        Stack<Vertex<Integer>> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        stack.add(adjList[rootPosition]);

        do {
            // when we have unconnected graphs
            if (stack.isEmpty()) {
                for (Vertex<Integer> integerVertex : adjList) {
                    if (!visited.contains(integerVertex)) {
                        stack.push(integerVertex);
                        break;
                    }
                }
            }
            while (!stack.isEmpty()) {
                Vertex<Integer> current = stack.pop();
                if (!visited.contains(current)) {
                    visited.add(current);
                    ans.add(current.value.toString());
                    stack.addAll(current.children);
                }
            }
        } while (adjList.length != visited.size());
        System.out.println(String.join(" -> ", ans));
    }

    private static void bfsTransversal(Vertex<Integer>[] adjList, int rootPosition) {
        System.out.println("BFS Transversal");

        HashSet<Vertex<Integer>> visited = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        queue.add(adjList[rootPosition]);

        List<String> ans = new ArrayList<>();
        do {
            // when we have unconnected graphs
            if (queue.isEmpty()) {
                for (Vertex<Integer> integerVertex : adjList) {
                    if (!visited.contains(integerVertex)) {
                        queue.add(integerVertex);
                        break;
                    }
                }
            }
            while (!queue.isEmpty()) {
                Vertex<Integer> current = queue.poll();
                if (!visited.contains(current)) {
                    ans.add(current.value.toString());
                    visited.add(current);
                    queue.addAll(current.children);
                }
            }
        } while (visited.size() != adjList.length);

        System.out.println(String.join(" -> ", ans));
    }

    private static void printAdjList(Vertex<Integer>[] adjList) {
        System.out.println("Adjancency List:");
        for (Vertex<Integer> v : adjList) {
            System.out.println(v.value);
            for (Vertex<Integer> x : v.children) {
                System.out.println("\t" + x.value);
            }
        }
    }

    public static Vertex<Integer>[] adjMatrixToAdjList(int[][] adjMatrix) {
        Vertex<Integer>[] vertices = new Vertex[adjMatrix.length];
        // init vertices
        for (int i = 0; i < adjMatrix.length; i++) {
            vertices[i] = new Vertex<>(i + 1);
        }

        // connect vertices
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    vertices[i].children.add(vertices[j]);
                }
            }
        }
        return vertices;
    }

    private static void printAdjMatrix(int[][] adjMatrix) {
        System.out.println("Adjacency Matrix: ");
        for (int[] x : adjMatrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static int[][] edgesToAdjMatrix(Edge[] edges) {
        // count the nodes in the edges
        HashSet<Integer> nodes = new HashSet<>();
        for (Edge e : edges) {
            nodes.add(e.getFrom());
            nodes.add(e.getTo());
        }

        // create an adj matrix of n*n where n is the length of nodes
        int[][] adjMatrix = new int[nodes.size()][nodes.size()];
        for (Edge e : edges) {
            adjMatrix[e.getFrom() - 1][e.getTo() - 1] = 1;
            adjMatrix[e.getTo() - 1][e.getFrom() - 1] = 1;
        }
        return adjMatrix;
    }

    public static Edge[] readEdges() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/dev/druid/classwork/classwork19/edges.txt"));
            int size = Integer.parseInt(br.readLine().trim());
            Edge[] edges = new Edge[size];
            for (int i = 0; i < size; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                edges[i] = new Edge(line[0], line[1]);
            }
            return edges;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
