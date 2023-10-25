import java.util.ArrayList;
import java.util.Arrays;

public class Beer extends Product {


    public Beer() {

    }

    public Beer(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId("beer" + KioskApp.beers.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        KioskApp.beers.add(this);
    }

}
