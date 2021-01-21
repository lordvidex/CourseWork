package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 19.10.2020
 * Time: 01:48
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: скобки (0 если всё хорошо, -1 если закрывающие скобки не достаточно а
 *              порядок в которой расположена первая ошибочная скобка если есть)
 */
public class Task7 {
    public static int bracketErrorPosition(String str){
        int leftBracketCount = 0;
        int rightBracketCount= 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('){
                leftBracketCount++;
            }else if(str.charAt(i)==')'){
                rightBracketCount++;
            }
            if(rightBracketCount>leftBracketCount){
                return i;
            }
        }
        if(rightBracketCount<leftBracketCount){
            return -1;
        }
        return 0;
    }
    public static void main(String[] args) {
        String firstString = "(ava)(s)d(((sdf))))()";
        String secondString = "alas)()";
        String thirdString = "very((((())";
        String fourthString = "((I am a boy)and(You are a girl))";
        System.out.println(bracketErrorPosition(firstString));
        System.out.println(bracketErrorPosition(secondString));
        System.out.println(bracketErrorPosition(thirdString));
        System.out.println(bracketErrorPosition(fourthString));

    }
}
