package pers.lld.basic.iip.Inheritance;

/**
 * * override(Overwrite)：是子类覆盖基类的方法。
 * * 重写的特点：
 * 1、必须是在继承里，
 * 2、方法名、返回值类型、参数个数和参数类型 都必须相同
 * 3、派生类重写的方法的访问权限不能低于基类的权限
 * 4、派生类抛出的异常应该和基类相等或比基类更小
 */
public class OverwriterFather {
    public OverwriterFather(){
        System.out.println("father init");
    }

    protected void doSomething(){
        System.out.println("father do sth");
    }

    protected void cancelMeeting(){
        System.out.println("father cancel meeting");
    }

    protected OverwriterFather doIt(){
        System.out.println("Father doIt");
        return new OverwriterFather();
    }
}


class Son extends OverwriterFather{
    public Son(){
        super();
        super.doSomething();
    }


    //3
    @Override
    public void cancelMeeting() {
        System.out.println("son cancel meeting");
    }

//    //3反例
//    void cancelMeeting() {
//        System.out.println("son cancel meeting");
//    }


    @Override
    protected void doSomething() {    //返回值、方法名、参数类型及个数相同的重写方式可称之为重构
        System.out.println("son cancel meeting");
    }

    @Override
    protected Son doIt(){        // @Override 方便阅读，格式校验，J2SE 5.0 + 支持返回类型是原来的子类
        System.out.println("son doIt");
        return new Son();
    }

    public static void main(String[] args) {
        new Son().doIt();
    }
}
