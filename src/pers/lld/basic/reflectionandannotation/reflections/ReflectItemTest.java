package pers.lld.basic.reflectionandannotation.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectItemTest {

    //Constructor inquryDemo
    public void showConstructors() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class itemClass = ReflectItem.class;

        //获取带String参数的public构造函数
        Constructor constructor = itemClass.getConstructor(String.class);
        ReflectItem item = (ReflectItem) constructor.newInstance("狸猫");
        item.toString();

        //取得指定带int和String参数构造函数,该方法是私有构造private
        Constructor cs2 = itemClass.getDeclaredConstructor();
        //由于是private必须设置可访问
        cs2.setAccessible(true);
        ReflectItem item2 = (ReflectItem) cs2.newInstance();
        item2.toString();

        //获取所有构造包含private
        Constructor<?> cons[] = itemClass.getDeclaredConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            //获取构造函数参数类型
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.println("构造函数["+i+"]:"+cons[i].toString() );
            System.out.print("参数类型["+i+"]:(");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }

    }


    //**需要特别注意的是被final关键字修饰的Field字段是安全的，在运行时可以接收任何修改，但最终其实际值是不会发生改变的。
    public void showFields() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class itemClass = ReflectItem.class;

        //获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
        // 否则抛NoSuchFieldException
        Field nickName = itemClass.getField("nickName");
        System.out.println("nickName" + nickName);

        //获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
        Field fields[] = itemClass.getFields();
        for (Field f:fields) {
            System.out.println("f:"+f.getDeclaringClass());
        }

        Field nameField= itemClass.getDeclaredField("name");
        Constructor constructor = itemClass.getConstructor(String.class);
        ReflectItem item = (ReflectItem) constructor.newInstance("妈妈");

        nameField.setAccessible(true);
        nameField.set(item,"leelee");
        item.toString();



    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            new ReflectItemTest().showFields();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
