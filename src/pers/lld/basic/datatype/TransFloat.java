package pers.lld.basic.datatype;

public class TransFloat {
    private char charS = 12;
    private int intS = (int)charS;

    private Integer integerDemo = new Integer(3);

    private void addOne(Integer integer){
        integer += 1;
    }

    public static void main(String[] args){
        TransFloat transDemo = new TransFloat();
        transDemo.addOne(transDemo.integerDemo);
        System.out.println(transDemo.integerDemo);
    }
}
