package dev.druid.classwork.classwork24;

/**
 * Created by IntelliJ IDEA
 * Date: 13.05.2021
 * Time: 12:54 AM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Annotations {
    @Author()
    public static void methodAnonymousAuthor(){}

    @Author(name = "Evans")
    public static void methodSpecific(){}

    @Author(name = "Fiona")
    public static void annotation3(){}

    @Author(name = "Tony Stark")
    public static void annotation4(){
        System.out.println("Hello Tony Stark");
    }

    @Author(name = "Edward James")
    public static void annotation5(){}


    public static void noAnnotation1(){}

    public static void  noAnnotation2(){}

    public static void noAnnotation3(){}

    public static void noAnnotation4(){}

    public static void noAnnotation5(){}

}
