package pers.lld.basic.iip.polymorphism;

public class GrandPa {
    public String with(GrandPa pa){ return "GrandPa with GrandPa";};
    public String with(Brother brother){ return "GrandPa with Brother";};
}

class Pa extends GrandPa{
    public String with(Pa pa){ return "Pa with Pa";};

    public String with(GrandPa grandPa){ return "Pa with GrandPa";};

    public void hello(){};
}

class Me extends Pa{
}

class Brother extends Pa{
}

class Recorder{
    public static void main(String[] args) {
        GrandPa gp1 = new GrandPa();
        GrandPa gp2 = new Pa();
        Pa pa = new Pa();
        Me me = new Me();
        Brother brother = new Brother();

        System.out.println(gp1.with(pa)); // gp gp
        System.out.println(gp1.with(me));  // gp gp
        System.out.println(gp1.with(brother)); //gp br
        System.out.println(gp2.with(pa)); // gp gp  // pa  gp
        System.out.println(gp2.with(me)); // gp gp  //pa gp
        System.out.println(gp2.with(brother)); //gp br
        System.out.println(pa.with(pa));  //pa pa
        System.out.println(pa.with(me)); //pa pa
        System.out.println(pa.with(brother)); //pa pa  //gp br

//        //应用
//        System.out.println(new Recorder().getVisitorInfo(new GrandPa()));
//        System.out.println(new Recorder().getVisitorInfo(new Me()));


    }
}