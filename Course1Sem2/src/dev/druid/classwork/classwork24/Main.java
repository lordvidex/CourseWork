package dev.druid.classwork.classwork24;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * Date: 13.05.2021
 * Time: 1:10 AM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    private static String PACKAGE_NAME = "dev.druid.classwork.classwork24.";
    public static void main(String[] args) {
        try {
            Class<Annotations> annotationsClass = (Class<Annotations>)
                    Class.forName(PACKAGE_NAME+"Annotations");
            List<Method> methods = methodsWithAnnotation(annotationsClass,Author.class);
            System.out.println("2A)Methods with @Author annotation: ");
            for(Method m: methods){
                System.out.println(m.getName());
            }

            // Task 2B
            System.out.println("\n2B) Invoking methods with Tony Stark author name");
            List<Method> tonyStarkMethods = methods.stream()
                    .filter(method -> annotationOfAuthorName(method,"Tony Stark"))
                    .collect(Collectors.toList());
            for(Method m: tonyStarkMethods){
                System.out.println(m.getName());
                m.invoke(null);
            }

        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    private static boolean annotationOfAuthorName(Method method,String name){
        return Arrays.stream(method.getAnnotations()).anyMatch(a->((Author) a).name().equals(name));
    }
    public static List<Method> methodsWithAnnotation(Class containingClass, Class annotationClass){
        List<Method> authorMethods = new ArrayList<>();

        Method[] methods = containingClass.getMethods();
        for(Method m: methods){
            if(Arrays.stream(m.getAnnotations())
                    .anyMatch(a -> annotationClass.isAssignableFrom(a.annotationType()))
            ){
                authorMethods.add(m);
            }
        }
        return authorMethods;
    }
}
