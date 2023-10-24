import java.util.ArrayList;
import java.util.Arrays;

public class Icecream extends Product {

    private static ArrayList<Icecream> icecreams = new ArrayList<>();

    public static Icecream select(int select){
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

    public static void printProduct() {//메뉴 선택시 출력
        System.out.println("[ Drinks MENU ]");
        for (int i = 0; i < icecreams.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " + icecreams.get(i).getName() + "   | W " + icecreams.get(i).getPrice() + " | " + icecreams.get(i).getDesc());
        }
    }

    public static void clear() {//count 비우는 함수
        for (Icecream x : icecreams) {//for문 돌면서 있으면 출력
            x.setCount(0);
        }
    }
    public static int getSize(){
        return icecreams.size();
    }
}
