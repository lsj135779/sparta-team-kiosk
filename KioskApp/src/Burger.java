import java.util.ArrayList;
import java.util.Arrays;

public class Burger extends Product {



    public Burger(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId("burger"+KioskApp.burgers.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        KioskApp.burgers.add(this);
    }


}
