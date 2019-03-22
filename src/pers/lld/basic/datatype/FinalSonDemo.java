package pers.lld.basic.datatype;

import javax.swing.plaf.PanelUI;

/**
 * 此类用以说明父类在子类中的final修饰方法都不可以修改
 */
public class FinalSonDemo extends FinalDemo{

    private static final String STATIC_TAG = "FinalDemo.CLASS";


    /**
     * 设置个人名称
     * @param firstName 名
     */
    public void setFirstName(String firstName){
        super.setFirstName(firstName + "·" + "Second") ;
    }


//    //Error1.父类的final 方法禁止子类重写
////    final public String getFullName() {
////        return personFirstName + "·" + familyLastName;
////    }


    public static void main(String[] args){
        FinalSonDemo demo = new FinalSonDemo();

        //inquryDemo.TAG = 200;  //Error2.父的final属性不可重新赋值

        demo.setFirstName("Gaga");
        System.out.print("FinalSonDemo 对象的全名是" + demo.getFullName());

    }


    public static String getClassNam(){return "TAG";}




}
