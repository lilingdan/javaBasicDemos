package pers.lld.basic.reflectionandannotation.annotations.inquryDemo;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@foodAnnotation
public class Fruit {
    public boolean isPoisonous;
}


/**
 * 食物注解
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface foodAnnotation{
    boolean natural() default true;
}

