package pers.lld.basic.reflectionandannotation.reflections;

public class ReflectItem {
    private final String name;
    public  String nickName = "缺失";
    private int age = 0;

    private ReflectItem(){
        this.name = "我";
        this.nickName = "嘎嘎";
        this.age = 28;
    }

    public ReflectItem(String name){
        this.name = name;
    }

    public ReflectItem(String name,int age){
        this.name = name;
        this.age = age;
    }

    public ReflectItem(String name,String nickName, int age){
        this.name = name;
        this.nickName = isVaildNickName(nickName)? nickName: "缺失";
        this.age = age;
    }

    @Override
    public String toString() {
        String ret = "姓名:" +  this.name + "  昵称:" + this.nickName +"  年龄:" + this.age;
        System.out.println(ret);
        return ret;
    }

    private boolean isVaildNickName(String name){
        return !name.contains("ISIS");
    }


}
