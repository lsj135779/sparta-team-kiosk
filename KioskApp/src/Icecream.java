import java.util.ArrayList;
import java.util.Arrays;

public class Icecream extends Product {

    public static ArrayList<Product> icecreams = new ArrayList<Product>();

    public static Product select(int select){
        int index = select-1;
        //id 일치하는 상품 count만 올림
        return icecreams.get(index);
    }

    public Icecream() {

    }

    public Icecream(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId("Icecream"+icecreams.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        icecreams.add(this);
    }

    public static void clear() {//count 비우는 함수
        for (Product x : icecreams) {//for문 돌면서 있으면 출력
            x.setCount(0);
        }
    }
    public static int getSize(){
        return icecreams.size();
    }
}
