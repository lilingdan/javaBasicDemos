package pers.lld.basic.reflectionandannotation.annotations.useDemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * 开发人员提交的工具类
 */
public class NoBug {

    @CheckException
    public void jiafa(){
        System.out.println("1+1="+1+1);
    }
    @CheckException
    public void jiefa(){
        System.out.println("1-1="+(1-1));
    }
    @CheckException
    public void chengfa(){
        System.out.println("3 x 5="+ 3*5);
    }
    @CheckException
    public void chufa(){
        System.out.println("6 / 0="+ 6 / 0);
    }

}

@Retention(RetentionPolicy.RUNTIME)
@interface CheckException {

}

class TestTool{
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        NoBug testobj = new NoBug();

        Class clazz = testobj.getClass();

        Method[] method = clazz.getDeclaredMethods();

        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;

        for ( Method m: method ) {
            // 只有被 @Jiecha 标注过的方法才进行测试
            if ( m.isAnnotationPresent( CheckException.class )) {
                try {
                    m.setAccessible(true);
                    m.invoke(testobj, null); //testobj对象中带有无参数的method方法

                } catch (Exception e) {
                    // TODO Auto-generated catch block
//                    e.printStackTrace();

                    System.out.println(m.getName() + "报错" );

//                    System.out.println();
//
//
//                    errornum++;
//                    log.append(m.getName());
//                    log.append(" ");
//                    log.append("has error:");
//                    log.append("\n\r  caused by ");
//                    //记录测试过程中，发生的异常的名称
//                    log.append(e.getCause().getClass().getSimpleName());
//                    log.append("\n\r");
//                    //记录测试过程中，发生的异常的具体信息
//                    log.append(e.getCause().getMessage());
//                    log.append("\n\r");
                }
            }
        }


//        log.append(clazz.getSimpleName());
//        log.append(" has  ");
//        log.append(errornum);
//        log.append(" error.");
//
//        // 生成测试报告
//        System.out.println(log.toString());

    }
}