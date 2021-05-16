package dev.druid.classwork.classwork18;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 21.04.2021
 * Time: 4:28 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    public static void main(String[] args) {
        // make an expression tree - from sample
        ExpressionTree expressionTree =  new ExpressionTree(makeTree());

        // get post fix record
        List<String> postFix = expressionTree.postFixRecord();
        double answer = expressionTree.evaluatePostFix(postFix);
        System.out.println("The answer is: "+answer);
    }

    private static Node makeTree() {
        Node nl = new Node("*",new Node("2"),new Node("5"));
        return new Node("+",nl,new Node("3"));
    }
}
