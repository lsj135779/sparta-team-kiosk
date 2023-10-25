import java.util.ArrayList;
import java.util.Arrays;

public class Burger extends Product {

    public static ArrayList<Product> burgers = new ArrayList<Product>();

    public static Product select(int select){
        int index = select-1;
        return burgers.get(index);
    }

    public Burger(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId("burger"+burgers.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        burgers.add(this);
    }

    public static int getSize() {
        return burgers.size();
    }
}
