package dev.druid.classwork.classwork18;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class ExpressionTree {
    Node root;
    ExpressionTree(Node root){
        this.root = root;
    }
    public ArrayList<String> postFixRecord(){
        ArrayList<String> arr = new ArrayList<>();
        Node x = root;
        transverse(x,arr);
        return arr;
    }

    private void transverse(Node x, ArrayList<String> arr) {
        if(x.left!=null){
            transverse(x.left,arr);
        }
        if(x.right!=null){
            transverse(x.right,arr);
        }
        arr.add(x.value);
    }
    public boolean isNumber(String s){
        return s.matches("[0-9]+");
    }
    public double evaluatePostFix(List<String> postFix){
        Stack<Double> aryaStark = new Stack<>();
        for (String fix : postFix) {
            if (isNumber(fix)) {
                aryaStark.push(Double.parseDouble(fix));
            } else {
                double n1 = aryaStark.pop();
                double n2 = aryaStark.pop();
                aryaStark.push(eval(n1, fix, n2));
            }
        }
        assert(aryaStark.size()==1);
        return aryaStark.pop();
    }
    private double eval(double n1, String op, double n2){
        return switch (op) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> n1;
        };
    }
}
