package dev.druid.classwork.classwork18;

/**
 * Created by IntelliJ IDEA
 * Date: 21.04.2021
 * Time: 4:26 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Node {
    Node left;
    Node right;
    String value;
    public Node(String value){
        this.value = value;
    }
    public Node(String value, Node left, Node right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
