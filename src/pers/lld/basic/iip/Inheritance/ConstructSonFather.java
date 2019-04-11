package pers.lld.basic.iip.Inheritance;

public class ConstructSonFather {
    public static void main(String[] args) {
        LittleSon boy = new LittleSon();
    }

}

class GrandPa{
    public GrandPa(){
        System.out.println("GrandPa no param");
    }

}

class Father extends GrandPa{
    public Father(){
        System.out.println("Father no param");
    }
}

class LittleSon extends Father{
    public LittleSon(){
        System.out.println("LittleSon no param");
    }
}
