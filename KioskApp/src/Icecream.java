import java.util.ArrayList;
import java.util.Arrays;

public class Icecream extends Product {

    private static ArrayList<Icecream> icecreams = new ArrayList<>();
//            Arrays.asList(
//            new Icecream("Classic Hand-Spun Shakes", "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크", 6.5),
//            new Icecream("Floats", "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료", 6.5),
//            new Icecream("Cup & Cones", "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림", 5.4))
//    );

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

    public static void printProductCount() {//버거별로 개수랑 같이 주문 화면에 목록 출력
        for (Icecream x : icecreams) {//for문 돌면서 있으면 출력
            if (x.getCount() > 1) {//2개 이상이면 숫자도 출력
                System.out.println(". " + x.getName() + "   | W " + x.getPrice() + " | " + x.getCount() + " | " + x.getDesc());
            } else if (x.getCount() > 0) {
                System.out.println(". " + x.getName() + "   | W " + x.getPrice() + " | " + x.getDesc());
            }
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
