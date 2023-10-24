import java.util.ArrayList;
import java.util.Arrays;

public class Drink extends Product {

    public static ArrayList<Product> drinks = new ArrayList<Product>();

    public static Product select(int select){
        int index = select-1;

        return drinks.get(index);
    }
    public Drink(){

    }

    public Drink(String name, String desc, double price){//새로 생성하는 생성자
        super.setName(name);
        super.setId("drink"+drinks.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        drinks.add(this);
    }

    public static void clear() {//count 비우는 함수
        for (Product d : drinks) {//for문 돌면서 있으면 출력
            d.setCount(0);
        }
    }

    public static int getSize(){
        return drinks.size();
    }
}
