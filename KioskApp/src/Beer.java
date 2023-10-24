import java.util.ArrayList;
import java.util.Arrays;

public class Beer extends Product {
    private static ArrayList<Beer> beers = new ArrayList<>();
//            Arrays.asList(
//            new Beer("Lager", "강한 탄산감이 있는 청량한 맥주", 6.5),
//                new Beer("Ale", "풍부한 향과 단맛이 나는 높은 바디감의 맥주", 6.5),
//                new Beer("Abita Root Beer", "맥주인 척 하는 탄산음료", 5.4))
//);


    public static Beer select(int select){
        int index = select-1;
        //id 일치하는 상품 count만 올림
        beers.get(index).setCount(beers.get(index).getCount()+1);
        return beers.get(index);
    }

        public Beer() {

        }

        public Beer(String name, String desc, double price) {//새로 생성하는 생성자
            super.setName(name);
            super.setId(beers.size());
            super.setDesc(desc);
            super.setCount(0);
            super.setPrice(price);
            beers.add(this);
        }

    public void printDescTotal() {
        System.out.println(super.getName() + "     | W " + super.getPrice() + " | " +super.getCount()+ "개 | " + super.getDesc());
    }

        public void printDesc() {
            System.out.println(super.getName() + "     | W " + super.getPrice() + " | " + super.getDesc());
        }

        public static void printProduct() {//메뉴 선택시 출력
            System.out.println("[ Drinks MENU ]\n");
            for (int i = 0; i < beers.size(); i++) {//for문 돌면서 있으면 출력
                System.out.println((i + 1) + ". " + beers.get(i).getName() + "   | W " + beers.get(i).getPrice() + " | " + beers.get(i).getDesc());
            }
        }

        public static void printProductCount() {//버거별로 개수랑 같이 주문 화면에 목록 출력
            for (Beer x : beers) {//for문 돌면서 있으면 출력
                if (x.getCount() > 1) {//2개 이상이면 숫자도 출력
                    System.out.println(". " + x.getName() + "   | W " + x.getPrice() + " | " + x.getCount() + " | " + x.getDesc());
                } else if (x.getCount() > 0) {
                    System.out.println(". " + x.getName() + "   | W " + x.getPrice() + " | " + x.getDesc());
                }
            }
        }

        public static void clear() {//count 비우는 함수
            for (Beer x : beers) {//for문 돌면서 있으면 출력
                x.setCount(0);
            }
        }
    public static int getSize(){
        return beers.size();
    }
    }
