package dev.druid.classwork.classwork17;

import dev.druid.classwork.classwork15.Tree;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 12.04.2021
 * Time: 2:51 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            tree.add(random.nextInt(100));
        }
        Tree.printNode(tree.getRoot(),5);
        Scanner sc = new Scanner(System.in);
        tree.remove(sc.nextInt());
        Tree.printNode(tree.getRoot(),2);
    }
}
