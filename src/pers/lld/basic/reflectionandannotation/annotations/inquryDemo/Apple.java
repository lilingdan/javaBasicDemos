package pers.lld.basic.reflectionandannotation.annotations.inquryDemo;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@trading
public class Apple extends Fruit{

    @FruitName("Apple")
    @FruitNameOther("App")
    private String appleName;

    @FruitColor(fruitColor= FruitColor.Color.RED)
    protected String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    public String appleProvider;

    String details;

    public Apple(){
        isPoisonous = false;
    }

}

/**
 * 贸易注解
 */

@Retention(RetentionPolicy.RUNTIME)
@interface trading{
    boolean isImported() default false;
}
