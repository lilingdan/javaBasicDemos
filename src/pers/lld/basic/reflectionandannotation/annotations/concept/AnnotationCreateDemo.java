package pers.lld.basic.reflectionandannotation.annotations.concept;

import java.lang.annotation.Annotation;

/**
 * 标注如何声明属性以及调用方法
 */
public class AnnotationCreateDemo {

    /**
     * 注解传参
     */
    @MarkAnnotation                          //标记注解无携参数

    @SingleFieldAnnotationName(name = "Nic") //单值注解，属性名为name
    @SingleFieldAnnotationValue("Nic")       //单值注解，只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内。

    @FullAnnotation(name = "Nic",age = 12)  //完整注解， value="" 形式，多个属性之前用 ，隔开
    @FullAnnotationValue(value = 3,name = "Nic", age = 12)
    @FullAnnotationDefault(value = 2,age = 3) //拥有默认值的属性可以不赋值
    @FullAnnotationFullDefault  //所有属性拥有默认值，当不修改内部属性时，可无携参

    @FullAnnotationAnnoDefault(an = @Necc(isNecessary = true))
    public void getChildDocument(){

    }

}

class ClassDemo{
    int age;
    String name;
}



/**
 *  标记注解，没有成员
 */
@interface MarkAnnotation{

}


/**
 * 单值注解 成员变量为name
 */
@interface SingleFieldAnnotationName{
    String name ();
}

/**
 * 单值注解 成员变量为value
 */
@interface SingleFieldAnnotationValue{
    String value ();
}

/**
 * 单值注解 拥有默认值
 */
@interface SingleFieldAnnotationDefault{
    String name () default "";
}

/**
 * 完整注解
 */
@interface FullAnnotation{
    int age();
    String name();
}

/**
 * 完整注解，成员变量存在Value
 */
@interface FullAnnotationValue{
    int value();
    int age();
    String name();
}

/**
 * 完整注解，拥有默认值
 */
@interface FullAnnotationDefault{
    int value() ;
    int age();
    String name() default "";
}

/**
 * 完整注解，拥有默认值
 */
@interface FullAnnotationFullDefault{
    int value() default -1;
    int age() default -1;
    String name() default "";
}


@interface FullAnnotationAnnoDefault{
    int value() default -1;
    int age() default -1;
    String name() default "";
    Necc an() default @Necc(isNecessary = true);

}

@interface Necc{
    boolean isNecessary ();
}