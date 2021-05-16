package dev.druid.classwork.classwork25;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by IntelliJ IDEA
 * Date: 13.05.2021
 * Time: 4:20 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    static Map<Class, Object> mapper = new HashMap<>();
    static Set<Class> recursableClasses = Set.of(
            Class1.class,
            Class2.class,
            Class3.class,
            Class4.class,
            Class5.class
    );

    public static void main(String[] args) {
        Class<Class1> c = Class1.class;
        try {
            Class1 instantiatedClass1 = (Class1) fillClass(c);
            System.out.println("-----Test-----");
            System.out.println(instantiatedClass1.name);
            System.out.println(instantiatedClass1.secondClass.class3.name);
            System.out.println(instantiatedClass1.secondClass.class4.class5.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object fillClass(Class c) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object o = c.getDeclaredConstructor().newInstance();
        // memoization
        if (mapper.containsKey(c)) {
            return mapper.get(c);
        }

        for (Field f : c.getDeclaredFields()) {
            if(recursableClasses.contains(f.getType())) {
                f.setAccessible(true);
                f.set(o, fillClass(f.getType()));
            }
        }

        mapper.put(c, o);
        return o;
    }
}
