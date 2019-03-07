package pers.lld.basic.datatype;

import java.util.Random;

/**
 * 此类用以说明，非static 的 final 属性在每个对象被创建时候被赋值
 * 如果需要让所有的对象拥有相同的final 属性，需要添加static 成为类属性，使得这个属性在装载的时候被初始化
 */
public class FinalStaticDemo {
    private static Random random = new Random();
    private static final int finalAndStatic = random.nextInt(10);
    private int tmp = finalAndStatic;
    private final int finalNotStatic = random.nextInt(10);

    private void print2Num(){
        System.out.print("finalAndStatic:" + finalAndStatic + " finalNotStatic:" + finalNotStatic + "\n");
    }

    public static void main(String[] args){
        FinalStaticDemo demo1 = new FinalStaticDemo();
        FinalStaticDemo demo2 = new FinalStaticDemo();

        demo1.print2Num();
        demo2.print2Num();
    }
}
