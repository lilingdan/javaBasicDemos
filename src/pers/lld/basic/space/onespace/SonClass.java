package pers.lld.basic.space.onespace;

import java.util.Date;

public class SonClass extends FatherClass {
    public void call4MehtodFromFather(){
        this.printFatherByDefaultMethod();
        this.printFatherByProtecetdMethod();
        this.printFatherByPublicMethod();
        //this.printFatherByPrivateMethod();
    }

    public static void main(String... args){
        System.out.print(new Date() + "\n");
        System.out.print("其他包子类能调用除了private 之外的方法\n");
        new SonClass().call4MehtodFromFather();
    }
}
