package dev.druid.classwork.classwork16;

import dev.druid.classwork.classwork15.Node;
import dev.druid.classwork.classwork15.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 08.04.2021
 * Time: 4:18 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    // arraylist for second task
    static List<Integer> recursionEven = new ArrayList<>();
    static List<Integer> stackEven = new ArrayList<>();

    public static void main(String[] args) {
        Tree t = new Tree(20);
        //t.printTree();

        System.out.println("Transversing with Queue(BFS): ");
        transverseQueue(t.getRoot());

        System.out.println("\nTask 2: transversing with recursion: ");
        transverseRecursion(t.getRoot());
        // answer
        System.out.println("\nEven numbers in the nodes :");
        System.out.println(listToString(recursionEven));

        transverseStack(t.getRoot());
        // answer
        System.out.println("\nEven numbers in the nodes :");
        System.out.println(listToString(stackEven));
    }

    private static void breakRoot(Node<Integer> root, Stack<Integer> stack) {
        if (root.right != null) {
            breakRoot(root.right, stack);
        }
        stack.push(root.value);
        if (root.left != null) {
            breakRoot(root.left, stack);
        }
    }

    private static void transverseStack(Node<Integer> root) {
        // ЛКП
        System.out.println("\nTask 3: Transversing with stack: ");
        Stack<Integer> stack = new Stack<>();
        breakRoot(root, stack);
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            if (popped % 2 == 0) stackEven.add(popped);
            System.out.print(popped + " ");
        }
    }

    private static void transverseRecursion(Node<Integer> root) {
        // ЛКП
        if (root.left != null) {
            transverseRecursion(root.left);
        }

        if (root.value % 2 == 0) recursionEven.add(root.value);
        System.out.print(root.value + " ");

        if (root.right != null) {
            transverseRecursion(root.right);
        }
    }

    private static void transverseQueue(Node<Integer> root) {
        // BFS
        List<Integer> even = new ArrayList<>();
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<Integer> root1 = queue.remove();
            System.out.print(root1.value + " ");
            if (root1.value % 2 == 0) even.add(root1.value);

            if (root1.left != null) queue.add(root1.left);
            if (root1.right != null) queue.add(root1.right);
        }

        // answer
        System.out.println("\nEven numbers in the nodes :");
        System.out.println(listToString(even));
    }

    private static String listToString(List<Integer> evens) {
        return evens.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
