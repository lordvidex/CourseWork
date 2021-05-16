package dev.druid.classwork.classwork24;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by IntelliJ IDEA
 * Date: 12.05.2021
 * Time: 5:10 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name() default "Anonymous";
}
