import java.util.ArrayList;
import java.util.Arrays;

public class Beer extends Product {
    public static ArrayList<Product> beers = new ArrayList<Product>();


    public static Product select(int select) {
        int index = select - 1;
        return beers.get(index);
    }

    public Beer() {

    }

    public Beer(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId("beer" + beers.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        beers.add(this);
    }

    public static void clear() {//count 비우는 함수
        for (Product x : beers) {//for문 돌면서 있으면 출력
            x.setCount(0);
        }
    }

    public static int getSize() {
        return beers.size();
    }
}
