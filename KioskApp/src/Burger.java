import java.util.ArrayList;
import java.util.Arrays;

public class Burger extends Product {

    private static ArrayList<Burger> burgers = new ArrayList<Burger>();

    //        private static ArrayList<Burger> burgers = new ArrayList<Burger>(Arrays.asList(
//                new Burger("ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6.9),
//                new Burger("SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9),
//                new Burger("Shroom Burger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9.4),
//                new Burger("Cheeseburger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6.9),
//                new Burger("Hamburger","비프패티를 기반으로 야채가 들어간 기본버거",5.4)
//        ));
    public static Burger select(int select){
        int index = select-1;
        //id 일치하는 상품 count만 올림
        burgers.get(index).setCount(burgers.get(index).getCount()+1);
        return burgers.get(index);
    }

    public Burger(String name, String desc, double price) {//새로 생성하는 생성자
        super.setName(name);
        super.setId(burgers.size());
        super.setDesc(desc);
        super.setCount(0);
        super.setPrice(price);
        burgers.add(this);
    }


    public void printDescTotal() {
        System.out.println(super.getName() + "     | W " + super.getPrice() + " | " +super.getCount()+ "개 | " + super.getDesc());
    }

    public void printDesc() {
        System.out.println(super.getName() + "     | W " + super.getPrice() + " | " + super.getDesc());
    }

    public static void printProduct() {//메뉴 선택시 출력
        System.out.println("[ Burgers MENU ]\n");
        for (int i = 0; i < burgers.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " + burgers.get(i).getName() + "   | W " + burgers.get(i).getPrice() + " | " + burgers.get(i).getDesc());
        }
    }

    public static void printProductCount() {//버거별로 개수랑 같이 주문 화면에 목록 출력
        for (Burger x : burgers) {//for문 돌면서 있으면 출력
            if (x.getCount() > 1) {//2개 이상이면 숫자도 출력
                System.out.println(". " + x.getName() + "   | W " + x.getPrice() + " | " + x.getCount() + " | " + x.getDesc());
            } else if (x.getCount() > 0) {
                System.out.println(". " + x.getName() + "   | W " + x.getPrice() + " | " + x.getDesc());
            }
        }
    }

    public static void clear() {//count 비우는 함수
        for (Burger x : burgers) {//for문 돌면서 있으면 출력
            x.setCount(0);
        }
    }

    public static int getSize() {
        return burgers.size();
    }
}
