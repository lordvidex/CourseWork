package dev.druid.classwork.classwork2;

import java.util.List;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * Date: 22.02.2021
 * Time: 2:38 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class AllBrackets {
    public static boolean isValidBrackets(String s){
        List<Character> opens =  Arrays.asList('(','[','<','{');
        List<Character> closes = Arrays.asList(')',']','>','}');
        MyStack stack = new MyStack();
        for(char c: s.toCharArray()){
            // check the opens for c
            int index = opens.indexOf(c);
            if(index!=-1){
                stack.push(c);
                continue;
            }
            // check the closes for c
            index = closes.indexOf(c);
            if(index!=-1){
                // return false immediately if stack is empty
                if(stack.isEmpty()){
                    return false;
                }
                char match = stack.pop();
                if(opens.indexOf(match)!=index){
                   return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValidBrackets("([])"));
        System.out.println(isValidBrackets("(())[]{}{{{afasd}}}"));
        System.out.println(isValidBrackets("(()}[]"));
        System.out.println(isValidBrackets(")(()"));
    }
}
