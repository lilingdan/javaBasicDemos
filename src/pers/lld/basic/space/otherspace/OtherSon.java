package pers.lld.basic.space.otherspace;

import pers.lld.basic.space.onespace.FatherClass;

import java.util.Date;

public class OtherSon extends FatherClass {
    public void call4MehtodFromFather(){

        this.printFatherByProtecetdMethod();
        this.printFatherByPublicMethod();
        //this.printFatherByDefaultMethod();
        //this.printFatherByPrivateMethod();
    }

    public static void main(String... args){
        System.out.print(new Date() + "\n");
        System.out.print("其他包子类只能调用 public 和 protected 的方法\n");
        new OtherSon().call4MehtodFromFather();
    }
}
