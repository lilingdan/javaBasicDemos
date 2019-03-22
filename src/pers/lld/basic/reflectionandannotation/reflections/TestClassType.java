package pers.lld.basic.reflectionandannotation.reflections;

public class TestClassType {
    public static String name = "me";
    //构造函数
    public TestClassType(){
        System.out.println("----构造函数---");
    }

    static {
        System.out.println("----静态的参数初始化---");
    }

    //非静态的参数初始化
    {

        System.out.println("----非静态的参数初始化---");

    }
}

