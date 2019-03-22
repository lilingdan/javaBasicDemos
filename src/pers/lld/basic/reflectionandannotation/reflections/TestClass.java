package pers.lld.basic.reflectionandannotation.reflections;

/**
 * Class对象的生成方式如下：
 *
 * 1.Class.forName("类名字符串")  （注意：类名字符串必须是全称，包名+类名）
 *
 * 2.类名.class
 *
 * 3.实例对象.getClass()
 */
public class TestClass {

    private void forName(){
        try {
            Class testForName = Class.forName("pers.lld.basic.reflectionandannotation.reflections.TestClassType");
            System.out.println("testForName---"+testForName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void dotClass(){
        Class dotClass = TestClassType.class;
        System.out.println("dotClass---"+dotClass);
    }

    private void getByClass(){
        TestClassType type = new TestClassType();
        System.out.println("getByClass---"+type.getClass());
    }

    /**
     * 比较基本数据类型和他包装类的Class
     */
    private void compareClass(){
        Class c1 = Integer.class;
        Class c2 = int.class;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println("c1 == c2):" + (c1 == c2));

        System.out.println("boolean.class ==Boolean.TYPE:"
                + (boolean.class == Boolean.TYPE));
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.compareClass();
        //testClass.dotClass();
        /**
         * 注意，使用这种办法生成Class类对象时，不会使JVM自动加载该类（如String类）。而其他办法会使得JVM初始化该类。
         * dotClass---class pers.lld.basic.reflectionandannotation.reflections.TestClassType
         */
        //testClass.forName();
        /**
         * ----静态的参数初始化---
         * testForName---class pers.lld.basic.reflectionandannotation.reflections.TestClassType
         */
        //testClass.getByClass();
        /**
         * ----静态的参数初始化---
         * ----非静态的参数初始化---
         * ----构造函数---
         * getByClass---class pers.lld.basic.reflectionandannotation.reflections.TestClassType
         */
    }
}
