import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class KioskApp {
    public static List<Order> waitingOrders = new ArrayList<Order>();//대기 주문 저장
    public static ArrayList<Order> completedOrders = new ArrayList<Order>();//완료된 주문 저장
    public static ArrayList<Product> cart = new ArrayList<Product>();//장바구니
    public static ArrayList<Menu> menus = new ArrayList<Menu>();//메뉴들 저장

    public static void selectMenu() {
        int menu;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.\n" +
                    "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                    "[ SHAKESHACK MENU ]\n");

            int i = Menu.printIndex(menus);

            System.out.println("[ ORDER MENU ]\n" +
                    i + ". Order       | 장바구니를 확인 후 주문합니다.\n" +
                    (i + 1) + ". Cancel      | 진행중인 주문을 취소합니다.\n" +
                    (i + 2) + ". Recent Orders       | 주문 현황을 확인합니다.\n" +
                    (i + 3) + ". Exit      | 주문 앱에서 나갑니다."
            );
            menu = sc.nextInt();

            if ((0 < menu) && (menu <= menus.size())) {//메뉴 안에 있으면
                selectProduct(menu);
            } else if (menu == menus.size() + 1) {//Order
                order();
            } else if (menu == (menus.size() + 2)) {//Cancel
                cancel();
            } else if (menu == (menus.size() + 3)) {//주문 현황
                recentOrder();
                waitingOrder();
            } else if (menu == (menus.size() + 4)){//나가기, while문 break;
                return;
            }else if(menu==0) {//총 판매 상품목록 출력
                printAllProduct();
            }
        }
    }

    public static void waitingOrder(){
        System.out.println(
                "[ 현재 대기중인 주문 ]");
        if(waitingOrders.size()==0){
            System.out.println(
                    "  현재 대기중인 주문이 없습니다.  ");
        }
        else{
            for (Order o : waitingOrders) {
                for(Product p : o.instanceMenus) {
                    p.printDescTotal();
                }
            }
        }
    }

    public static void recentOrder(){//완료된 최근주문 3개 출력
        System.out.println(
                "[ 최근 완료 주문 ]");
        if(completedOrders.size()>3) {
            for (int i=completedOrders.size()-1; i> completedOrders.size()-4; i--) {
                Order o = completedOrders.get(i);
                    for (Product p : o.instanceMenus) {
                        p.printDescTotal();
                    }
                }
            }
        else if(completedOrders.size()==0){
            System.out.println(
                    "  최근 완료 주문이 없습니다.  ");
        }
        else{
            for (Order o : completedOrders) {
                for (Product p : o.instanceMenus) {
                    p.printDescTotal();
                }
            }
        }
    }

    public static void printAllProduct(){
        double total = 0;
        System.out.println(
                "[ 총 판매 목록 ]");
        for (Order o : waitingOrders) {
            for (Product p : o.instanceMenus) {
                p.printDescTotal();
                total = total + p.getPrice()*p.getCount();
            }
        }
        for (Order o : completedOrders) {
            for (Product p : o.instanceMenus) {
                p.printDescTotal();
                total = total + p.getPrice()*p.getCount();
            }
        }
        System.out.println("[ Total ]\nW " + total);
    }
    public static void printWaitingProduct(){
        double total = 0;
        System.out.println(
                "[ 대기 주문 목록 ]");
        for (Order o : waitingOrders){
            System.out.println("------------------------------");
            System.out.println("대기 번호 : " + o.getWaitingNum());
            System.out.print("주문 상품 목록 : |");
            for(Product p : o.instanceMenus){
                System.out.print(p.getName() + "|");
                total = total + p.getPrice() * p.getCount();
            }
            System.out.println("\n[ Total ] W " + total);
            total = 0;
            System.out.println("요청 사항 : " + o.getOffer());
            System.out.println("주문 일시 : " + o.getTime());
            System.out.println("------------------------------");
        }
        // 대기주문 목록에서 완료처리하는 과정
        Boolean completeOrderCheck = completeOrder();
        if (completeOrderCheck) System.out.println("\u001B[34m주문을 완료처리했습니다\u001B[0m");
        else System.out.println("\u001B[31m존재하지 않는 주문번호입니다\u001B[0m");
    }

    private static Boolean completeOrder () {
        Scanner sc = new Scanner(System.in);
        int waitingNum;
        System.out.println("\u001B[32m완료할 주문의 대기 번호를 입력해주세요\u001B[0m");
        waitingNum = sc.nextInt();
        Boolean check = false;
        for (int i = 0; i < waitingOrders.size(); i++) {
            if (Objects.equals(waitingNum, waitingOrders.get(i).getWaitingNum())) {
                LocalDateTime now = LocalDateTime.now();
                String dateTimeNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                waitingOrders.get(i).setCompleteTime(dateTimeNow); // 완료처리한 시간 추가
                completedOrders.add(waitingOrders.get(i)); // 완료처리할 대기주문을 완료 주문목록에 추가
                waitingOrders.remove(i); // 대기주문 목록에서는 삭제
                check = true;
                break;
            }
        }
        return check;
    }

    public static void selectProduct(int menu) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.\n" +
                    "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n\n");

            Menu m = menus.get(menu-1);
            System.out.println("[ "+m.getName()+" MENU ]");
            Product.printIndex(m.products);

            int select = sc.nextInt();
            Product product;

            if ((0 < select) && (select <= m.products.size())){
                product = selectP(menu,select);
            }else{
                continue;
            }

            product.printDescTotal();//개수출력
            confirmMenu(product);

            return;
        }
    }

    public static Product selectP(int menu, int product){
        return menus.get(menu-1).products.get(product-1);
    }

    public static void confirmMenu(Product product) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                    "1. 확인        2. 취소");
            int confirm = sc.nextInt();
            if (confirm == 1) {
                product.increaseCount();//산다 하면 물품 개수만 올려준다 동일한 이름으로 생성 x
                boolean newMenu = true;
                for (Product p : cart) {
                    if(p.getId()==product.getId()){
                        newMenu = false;
                        break;
                    }
                }
                if(newMenu == true){
                    cart.add(product);
                }
                System.out.println(product.getName() + " 가 장바구니에 추가되었습니다.");
                return;
            }else if(confirm == 2){
                return;
            }
        }
    }

    public static void order() {

        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("아래와 같이 주문 하시겠습니까?\n" +
                    "[ Orders ]");
            double total = 0;
            for (Product p : cart) {
                p.printDescTotal();
                total = total + p.getPrice()*p.getCount();
            }

            System.out.println("[ Total ]\nW " + total + "\n" +
                    "1. 주문      2. 메뉴판");
            int x = sc.nextInt();
            if (x == 1) {//주문

                System.out.print("요청 사항이 있다면 입력해주세요 : ");
                sc.nextLine();      //nextInt()에 먹힌 Enter키 처리
                String request = sc.nextLine();

                LocalDateTime now = LocalDateTime.now();
                String dateTimeNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                for (Product p : cart) {
                    Product product = new Product(p.getName(), p.getDesc(), p.getPrice(), p.getCount());
                    Order order = new Order();
                    order.instanceMenus = new ArrayList<Product>();
                    order.instanceMenus.add(product);
                    order.setTotal(total);
                    order.setOffer(request);//주문에 요청사항 추가
                    order.setTime(dateTimeNow);
                    waitingOrders.add(order);//대기주문에 추가
                }

                cart.clear();//static 메뉴선택 끝나서 장바구니 비워줌
                /*개수 카운트 비워줌*/
                for (Menu m : menus) {
                    for (Product p : m.products) {
                        p.setCount(0);
                    }
                }

                System.out.println("주문이 완료되었습니다!\n\n" +
                        "대기번호는 [ " + waitingOrders.size() + " ] 번 입니다.\n" +
                        "(3초후 메뉴판으로 돌아갑니다.)");
                //3초 기다려야됨

                return;
            } else if (x == 2) {
                return;
            }
        }
    }

    public static void cancel() {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("주문을 취소 하시겠습니까?\n" +
                    "1. 확인      2. 메뉴판");
            int x = sc.nextInt();
            if (x == 1) {//주문취소
                System.out.println("취소가 완료되었습니다!\n\n");
                //3초 기다려야됨
                cart.clear();//static 메뉴선택 취소해서 장바구니 비워줌
                /*개수 카운트 비워줌*/
                for (Menu m : menus) {
                    for (Product p : m.products) {
                        p.setCount(0);
                    }
                }
                return;
            } else if (x == 2) {
                return;
            }
        }
    }

}
