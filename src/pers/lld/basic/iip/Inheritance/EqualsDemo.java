package pers.lld.basic.iip.Inheritance;

public class EqualsDemo {
    public static void main(String[] args) {
        System.out.println(new Sample().equals(new Sample()));
        System.out.println(new EqualSample().equals(new EqualSample()));
    }
}

class Sample{
    private String name = "gaga";
}

class EqualSample{
    private String name = "enen";
    private int age =  10;

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof EqualSample){
            if (this.name.equals(((EqualSample) obj).name)){
                return true;
            }
        }
        return false;
    }


}
