package pers.lld.basic.iip.Inheritance;

public class ToStringDemo {
    public static void main(String[] args) {
        System.out.println(new Charity().toString());
        System.out.println(new Donater().toString());
    }
}


class Charity{
    private int donation = 1000;
    private int num = 30;

    public void donateMoney(boolean isNew, int money){
        num ++;
        donation += money;
    }

    @Override
    public String toString() {
        return "目前捐款人数：" + num + " 总金额：" + donation;
    }
}

class Donater{
    private int wealth = 30000000;
    private int donation = 1000;
    public void donateMoney(int money){
        wealth -= donation;
    }

}