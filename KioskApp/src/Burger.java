import java.util.ArrayList;
import java.util.Arrays;

public class Burger extends Product {
    private static ArrayList<Integer> count = new ArrayList<Integer>(Arrays.asList(0, 0, 0,0,0));
    private static ArrayList<String> name = new ArrayList<String>(Arrays.asList("ShackBurger","SmokeShack","Shroom Burger","Cheeseburger","Hamburger"));

    private static ArrayList<String> desc = new ArrayList<String>(Arrays.asList("토마토, 양상추, 쉑소스가 토핑된 치즈버거",
            "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
            "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
            "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
            "비프패티를 기반으로 야채가 들어간 기본버거"));
    private static ArrayList<Double> price = new ArrayList<Double>(Arrays.asList(6.9,8.9,9.4,6.9,5.4));

    public Burger(int select) {
        int index = select - 1;
        super.setName(name.get(index));
        super.setDesc(desc.get(index));
        super.setPrice(price.get(index));
        count.set(index, count.get(index) + 1);
    }

    public void printDescTotal() {
        int productCount = 0;
        for (int i = 0; i < name.size(); i++) {//for문 돌면서 이름 일치하는 상품이 2개 이상 있으면 개수 출력
            if (name.get(i) == super.getName()) {
                productCount = count.get(i);
            }
        }
        if (productCount > 1) {//이름 일치하는 상품이 2개 이상이면 몇개라고 알려줌
            System.out.println(super.getName() + "     | W " + super.getPrice() + " | " + productCount + " | " + super.getDesc());
        } else {//아니면 개수 빼고 출력
            System.out.println(super.getName() + "     | W " + super.getPrice() + " | " + super.getDesc());
        }
    }

    public void printDesc() {
        System.out.println(super.getName() + "     | W " + super.getPrice() + " | " + super.getDesc());
    }

    public static void printProduct() {//메뉴 선택시 출력
        System.out.println("[ Burgers MENU ]\n");
        for (int i = 0; i < count.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " + name.get(i) + "   | W " + price.get(i) + " | " + desc.get(i));
        }
    }

    public static void printProductCount() {//버거별로 개수랑 같이 주문 화면에 목록 출력
        for (int i = 0; i < count.size(); i++) {//for문 돌면서 있으면 출력
            if (count.get(i) > 1) {//2개 이상이면 숫자도 출력
                System.out.println(". " + name.get(i) + "   | W " + price.get(i) + " | " + count.get(i) + " | " + desc.get(i));
            } else if (count.get(i) > 0) {
                System.out.println(". " + name.get(i) + "   | W " + price.get(i) + " | " + desc.get(i));
            }
        }
    }

    public static void clear() {
        count.clear();
    }
}
