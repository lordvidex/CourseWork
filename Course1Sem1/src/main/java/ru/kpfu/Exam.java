package ru.kpfu;

/**
 * Created by IntelliJ IDEA
 * Date: 09.01.2021
 * Time: 10:38
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Exam {
    public static String parseCode(String code){
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<code.length();i++){
            //checks if the first digit is a '.' add 0
            if(code.charAt(i)=='.'){
                ans.append(0);
            }else if(code.charAt(i)=='-'){
                //if the first digit is a '-' it is either a `1` or a `2`
                if(i<code.length()-1&&code.charAt(i+1)=='.'){
                    ans.append(1); //-. is 1
                    i++;
                }else if(i<code.length()-1&&code.charAt(i+1)=='-'){
                    ans.append(2); //-- is 2
                    i++;
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String code = "-..-.--";
                //".-.--";
        System.out.println(parseCode(code));
    }
}
