package pers.lld.basic.reflectionandannotation.annotations.concept;


import java.lang.annotation.*;


public class MetadataDemo {


}

/**
 * 1.生命周期 @Retention
 * SOURCE                    CLASS          RUNTIME
 * Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
 *
 * 如何选择：1.如果只是做一些检查性的操作，比如 @Override 和 @SuppressWarnings，使用SOURCE 注解。
 *          2.如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解
 *          3.一般如果需要在运行时去动态获取注解信息(反射)，那只能用 RUNTIME 注解，比如@Deprecated使用
 */


@Retention(RetentionPolicy.RUNTIME)
@interface LifeAnnotation{
    int id();
    long createTime();
    String name();
    long birthday();
    String address();
}

/**
 * 2.文档 @Documented 暂不介绍
 */



/**
 * 3. 可适用对象 @Target
 * ElementType.
 * 1.ANNOTATION_TYPE    注解
 * 2.CONSTRUCTOR    构造方法
 * 3. FIELD    属性
 * 4.LOCAL_VARIABLE     局部变量
 * 5.METHOD    方法
 * 6.PACKAGE    包
 * 7.PARAMETER   方法内的参数
 * 8.TYPE     类型，比如类、接口(包括注解类型)、枚举
 */

@Target(ElementType.CONSTRUCTOR)
@interface ConstructureAnnotation{

}

@Target(ElementType.FIELD)
@interface FieldFruitAnnotation{

}

@Target(ElementType.PARAMETER)
@interface ParamNotNullAnnotation{

}

@Target(ElementType.METHOD)
@interface MethodAnnotation{

}

class AppleClass{

    @FieldFruitAnnotation
    private String appleColor;


    AppleClass(){

    }

    private void getAppleColor(){
        System.out.println(appleColor);
    }


    private void setAppleColor(String applecolor){
        this.appleColor = applecolor;
    }


}



@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FatherAnnotationsS.class)
@interface FatherAnnotations{
    String value() default "";
}


/**
 * 容器
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface FatherAnnotationsS{
    FatherAnnotations[] value();
}


/**
 *  todo
 */
@FatherAnnotations("baba")
//@FatherAnnotationsS({@FatherAnnotations("fatherAnno"),@FatherAnnotations("fatherAnno22222")})
class FatherClass{

}


class SonClass extends FatherClass {
    public static void main(String[] args) {

        //判断是否有注解
        boolean hasAnnotation = SonClass.class.isAnnotationPresent(FatherAnnotations.class);
        if (hasAnnotation) {
            FatherAnnotations testAnnotation = SonClass.class.getAnnotation(FatherAnnotations.class);
            System.out.println("SonClass 存在注释 " + testAnnotation.toString());
        }

    }

}




/**
 *  5.可重复的注解 @Repeatable
 */
//@RepeatCareerIllegal(role = "doctor")
//@RepeatCareerIllegal(role = "artist")

@RepeatCareerLegal(role = "doctor")
@RepeatCareerLegal(role = "cto")
@RepeatCareerLegal(role = "artist")
class RepeatDemoClass{

    private String cs;
}


/**
 * 无效的可重复注解
 */
@interface RepeatCareerIllegal{
    String role() default "";
}


/**
 * 用来保存RepeatCareerLegal注解内容的容器
 */
@interface Careers{
    RepeatCareerLegal[] value();
}

/**
 * 容器是Careers的注解，可重复
 */
@Repeatable(Careers.class)
@interface RepeatCareerLegal{
    String role() default "";
}