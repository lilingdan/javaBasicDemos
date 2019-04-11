package pers.lld.basic.iip.Inheritance;

public class OverLoaderDemo {

    public void function(int a){}
    public void function(boolean a){} //类型
    public void function(int... a){}
    public void function(int a, boolean b){} //长度
    public void function(boolean a, int b){} //顺序
    public int function(int a){return  a}; //报错

}
