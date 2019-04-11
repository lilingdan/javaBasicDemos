package pers.lld.basic.reflectionandannotation.annotations.inquryDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 　方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass):
 *         返回改程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
 * 　　方法2：Annotation[] getAnnotations():
 *         返回该程序元素上存在的所有注解。
 * 　　方法3：boolean is AnnotationPresent(Class<?extends Annotation> annotationClass):
 *         判断该程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.
 * 　　方法4：Annotation[] getDeclaredAnnotations()：
 *         返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。
 *         （如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响。
 *
 *
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){

        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvicer="供应商信息：";

        // 以下两端代码用于区分getAnnotations/getDeclaredAnnotations

        System.out.println("调用getAnnotations：");  //   方法2
        Annotation[] annos = clazz.getAnnotations();
        for (Annotation annotation: annos){
            System.out.println(" 类：" + clazz.getName() + "，注解：" + annotation.toString());
        }

        System.out.println("\n调用getDeclaredAnnotations：");  //   方法4
        Annotation[] anno2s = clazz.getDeclaredAnnotations();
        for (Annotation annotation: anno2s){
            System.out.println(" 类：" + clazz.getName() + "，注解：" + annotation.toString());
        }



        Field[] fields = clazz.getDeclaredFields();//获得某个类的所有申明的字段，但是不包括父类的申明字段。
        for(Field field :fields){

            if (field.getName() == "appleName"){
                Annotation[] annotations = field.getDeclaredAnnotations();  //方法4 自身，所有注解，不继承
                for (Annotation annotation: annotations){
                    System.out.println("成员变量appleName 自身，所有注解，不继承：" + annotation.toString());
                }


            }

            if(field.isAnnotationPresent(FruitName.class)){  //方法1
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class); //方法3
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer=" 供应商编号："+fruitProvider.id()+" 供应商名称："+fruitProvider.name()+" 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
            else {
                System.out.println(" 字段 " + field.getName() + " 未携带任何标注");
            }
        }
    }

    public static void main(String[] args) {

        FruitInfoUtil.getFruitInfo(Apple.class);

    }


}
