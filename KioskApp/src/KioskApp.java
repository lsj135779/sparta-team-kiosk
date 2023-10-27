import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskApp {
    public static List<Order> orders = new ArrayList<Order>();//현재 주문 저장
    public static List<Order> waitingOrders = new ArrayList<Order>();//대기 주문 저장
    public static ArrayList<Order> completedOrders = new ArrayList<Order>();//완료된 주문 저장
    public static ArrayList<Product> cart = new ArrayList<Product>();//장바구니
    public static ArrayList<Menu> menus = new ArrayList<Menu>();//메뉴들 저장
    private static int waiting = 0;//대기인원 -> orders.size()로 하면 될듯함


    public static int getWaiting() {
        return waiting;
    }

    public static void decreaseWaiting() {
        waiting = waiting - 1;
    }

    public static void increaseWaiting() {
        waiting = waiting + 1;
    }

    public static void selectMenu() {
        int menu;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.\n" +
                    "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                    "[ SHAKESHACK MENU ]\n");

            int i = Menu.printIndex(menus);

            System.out.println("[ ORDER MENU ]\n" +
                    i+". Order       | 장바구니를 확인 후 주문합니다.\n" +
                    (i+1)+". Cancel      | 진행중인 주문을 취소합니다.\n" +
                    (i+2)+". WaitingOrder       | 대기중인 주문목록을 확인합니다.\n" +
                    (i+3)+". RecentOrder      | 최근 3가지 주문목록을 확인합니다.\n" +
                    (i+4)+". Exit      | 주문 앱에서 나갑니다."
            );
            menu = sc.nextInt();

            if ((0 < menu) && (menu <= menus.size())) {//메뉴 안에 있으면
                selectProduct(menu);
            } else if (menu == menus.size()+1) {//Order
                order();
            } else if (menu == (menus.size()+2)) {//Cancel
                cancel();
            } else if (menu == (menus.size()+3)) {//WaitingOrder
                waitingOrder();
            } else if (menu == (menus.size()+4)) {//RecentOrder
                recentOrder();
            }
            else if(menu == (menus.size()+5)){//나가기, while문 break;
                return;
            }else if(menu==0) {//총 판매 상품목록 출력
                printAllProduct();
            }
        }
    }

    public static void waitingOrder(){
        for (Product p : cart) {
            p.printDescTotal();
        }
    }

    public static void recentOrder(){
        if(orders.size()>3) {
            for (int i=orders.size()-1; i> orders.size()-4; i--) {
                Order o = orders.get(i);
                    for (Product p : o.instanceMenus) {
                        p.printDescTotal();
                    }
                }
            }
        else{
            for (Order o : orders) {
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
        for (Order o : orders) {
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
                increaseWaiting();//대기 인원 증가

                System.out.print("요청 사항이 있다면 입력해주세요 : ");
                sc.nextLine();      //nextInt()에 먹힌 Enter키 처리
                String request = sc.nextLine();

                LocalDateTime now = LocalDateTime.now();
                String dateTimeNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                /*주문 객체 만드는 중*/
                ArrayList<Product> orderMenus = new ArrayList<Product>();

                for (Product p : cart) {
                    Product product = new Product(p.getName(), p.getDesc(), p.getPrice(), p.getCount());
                    Order order = new Order();
                    order.instanceMenus = new ArrayList<Product>();
                    order.instanceMenus.add(product);
                    order.setTotal(total);
                    order.setOffer(request);//주문에 요청사항 추가
                    orders.add(order);
                }
                /*주문대기 객체 생성*/
                Order waitingOrder = new Order();
                waitingOrder.instanceMenus = new ArrayList<Product>();
                for (Product p : cart) {
                    Product waitingProduct = new Product(p.getName(), p.getDesc(), p.getPrice(), p.getCount());
                    waitingOrder.instanceMenus.add(waitingProduct);
                }
                waitingOrder.setTotal(total);
                waitingOrder.setOffer(request);
                waitingOrder.setTime(dateTimeNow);
                waitingOrder.setWaitingNum(waiting);
                waitingOrders.add(waitingOrder);

                cart.clear();//static 메뉴선택 끝나서 장바구니 비워줌
                /*개수 카운트 비워줌*/
                for (Menu m : menus) {
                    for (Product p : m.products) {
                        p.setCount(0);
                    }
                }

                System.out.println("주문이 완료되었습니다!\n\n" +
                        "대기번호는 [ " + getWaiting() + " ] 번 입니다.\n" +
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
