package pers.lld.basic.reflectionandannotation.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TestAnnotation()
public class Test {

    @Check(value="hi")
    int a;

    @Perform
    public void testMethod(){}

    public static void main(String[] args) {
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);

        if (hasAnnotation){
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);

            System.out.println("id:" + testAnnotation.id());
            System.out.println("message:" + testAnnotation.message());

        }

        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);

            Check check = a.getAnnotation(Check.class);
            if (check != null){
                System.out.println("check value " + check.value());
            }

            Method testMethod = Test.class.getDeclaredMethod("testMethod");
            if (testMethod != null){
                // 获取方法中的注解
                Annotation[] ans = testMethod.getAnnotations();
                for(int i = 0; i < ans.length; i++){
                    System.out.println("method testMethod annotation:" + ans[i]);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
