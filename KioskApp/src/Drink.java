import java.util.ArrayList;
import java.util.Arrays;

public class Drink extends Product {


    public Drink(){

    }

    public Drink(String name, String desc, double price){//새로 생성하는 생성자
        super.setName(name);
        super.setId("drink"+KioskApp.drinks.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        KioskApp.drinks.add(this);
    }



}
