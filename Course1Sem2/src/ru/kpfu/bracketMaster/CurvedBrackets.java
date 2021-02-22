package ru.kpfu.bracketMaster;

/**
 * Created by IntelliJ IDEA
 * Date: 22.02.2021
 * Time: 2:35 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class CurvedBrackets {
    public static boolean isValidBracket(String s){
        int leftBrackets = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                leftBrackets++;
            }else if(c==')'){
                if(leftBrackets==0){
                    return false;
                }else{
                    leftBrackets--;
                }
            }
        }
        return leftBrackets == 0;
    }
    public static void main(String[] args) {
        System.out.println(isValidBracket("(())"));
        System.out.println(isValidBracket(")("));
        System.out.println(isValidBracket("(()"));

    }
}
