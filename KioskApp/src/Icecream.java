import java.util.ArrayList;
import java.util.Arrays;

public class Icecream extends Product {


    public Icecream() {

    }

    public Icecream(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId("Icecream" + KioskApp.icecreams.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        KioskApp.icecreams.add(this);
    }

}
