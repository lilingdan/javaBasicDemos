package pers.lld.basic.space.onespace;

import java.util.Date;

public class SamePackageStrangerClass {
    public void call4MehtodFromStrangerFather(){
        FatherClass father = new FatherClass();
        father.printFatherByPublicMethod();
        father.printFatherByProtecetdMethod();
        father.printFatherByDefaultMethod();
        //father.printFatherByPrivateMethod();
    }

    public static void main(String... args){
        System.out.print(new Date() + "\n");
        System.out.print("同包不同类不能调用private方法\n");
        new SamePackageStrangerClass().call4MehtodFromStrangerFather();
    }
}
