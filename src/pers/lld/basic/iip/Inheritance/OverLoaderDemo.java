package pers.lld.basic.iip.Inheritance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class OverLoaderDemo {

    public void function(int a){}
    public void function(boolean a){} //类型
    public void function(int... a){}  //int[] a
    public void function(int a, boolean b){} //长度
    public void function(boolean a, int b){} //顺序

//    public int function(int a){return  a}; //报错

    public static void main(String[] args) {
        new OverLoaderDemo().function(1,2,3,4,5,6);
        new OverLoaderDemo().function();

        Class clazz = OverLoaderDemo.class;
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                printParameter(parameter);
            }

            System.out.println("******");
        }
    }

    private static void printParameter(Parameter parameter) {
        //参数名
        System.out.println(parameter.getType().getName());


//        System.out.println("\t\t" + parameter.getName());
//        //是否在源码中隐式声明的参数名
//        System.out.println("\t\t\t implicit:" + parameter.isImplicit());
//        //类文件中，是否存在参数名
//        System.out.println("\t\t\t namePresent:" + parameter.isNamePresent());
//        //是否为虚构参数
//        System.out.println("\t\t\t synthetic:" + parameter.isSynthetic());
//        System.out.println("\t\t\t VarArgs:" + parameter.isVarArgs());
    }



}
