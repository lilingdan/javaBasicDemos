package pers.lld.basic.datatype;

/**
 * 此类为FinalSonDemo父类，包含final 属性/方法，main 方法中包含final 变量
 * 用以说明final修饰变量的规定
 */
public class FinalDemo {
    private final String ERROR; //Error1.final修饰类的属性要在定义时就赋值(或必须在调用构造方法时)
    public final String TAG = "FinalDemo";
    private static final String STATIC_TAG = "FinalDemo.CLASS";

    FinalDemo(){
        ERROR = "give content when construct ";
    }


    private String familyLastName= "Dan";
    private String personFirstName = "";
    /**
     * 设置个人名称
     * @param firstName 名
     */
    public void setFirstName(String firstName){
        personFirstName = firstName;
    }

    /**
     * 完整姓名的展示方法
     * @return 姓名
     */
    final public String getFullName() {
        return personFirstName + "·" + familyLastName;
    }

    public static void main(String[] args){

        final float PI;
        PI = 3.14f;
        //PI = 3.1415f;  //Error2.final修饰的局部变量只能赋值一次
        System.out.print(STATIC_TAG + " PI " + PI);


        FinalDemo demo = new FinalDemo();
        demo.setFirstName("Jack");
        System.out.print("demo的全名是" + demo.getFullName());

    }


}
