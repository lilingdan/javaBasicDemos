package pers.lld.basic.space.otherspace;

import pers.lld.basic.space.onespace.FatherClass;

import java.util.Date;

public class DifferentPackageStrangerClass {
    public void call4MehtodFromStrangerFather(){
        FatherClass father = new FatherClass();
        father.printFatherByPublicMethod();
        //father.printFatherByProtecetdMethod();
        //father.printFatherByDefaultMethod();
        //father.printFatherByPrivateMethod();
    }

    public static void main(String... args){
        System.out.print(new Date() + "\n");
        System.out.print("不同包不同类只能调用public 方法\n");
        new DifferentPackageStrangerClass().call4MehtodFromStrangerFather();
    }
}
