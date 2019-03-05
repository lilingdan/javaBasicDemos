package pers.lld.basic.space.onespace;

import java.util.Date;

public class FatherClass {
    public void printFatherByPublicMethod(){
        System.out.print("成功调用FatherClass中的public方法\n");
    }

    protected void printFatherByProtecetdMethod(){
        System.out.print("成功调用FatherClass中的protected方法\n");
    }

    void printFatherByDefaultMethod(){
        System.out.print("成功调用FatherClass中的default方法\n");
    }

    private void printFatherByPrivateMethod(){
        System.out.print("成功调用FatherClass中的private方法\n");
    }

    public void tryCall4Method(){
        printFatherByDefaultMethod();
        printFatherByPrivateMethod();
        printFatherByProtecetdMethod();
        printFatherByPublicMethod();
    }

    public static void main(String... args){
        System.out.print("同类，4种作用域的方法可以任意调用");
        System.out.print(new Date() + "\n");
        new FatherClass().tryCall4Method();
    }
}
