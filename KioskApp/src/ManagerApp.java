import java.util.ArrayList;
import java.util.Scanner;

public class ManagerApp {
    public static void run(){
        int select;
        KioskApp kioskApp = new KioskApp();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("SHAKESHACK BURGER MANAGEMENT APP.\n" +
                    "원하는 기능을 골라 입력해주세요.\n" +
                    "1. 대기주문 목록\n" +
                    "2. 완료주문 목록\n" +
                    "3. 상품 생성\n" +
                    "4. 상품 삭제\n" +
                    "5. 나가기"
            );
            select = sc.nextInt();

            if(select == 1){//대기주문 목록 함수 호출
                kioskApp.printWaitingProduct();
            }else if(select ==2){//완료주문 목록 함수 호출
                completeOrderList();
            }else if(select ==3){//상품 생성 함수 호출
                createProduct();

            }else if(select ==4){//상품 삭제 함수 호출
                deleteProduct();
            }else if(select ==5){//나가기,while문 break함
                break;
            }
        }

    }
    public static void createProduct(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[  상품 등록  ]");
        System.out.println("메뉴 이름을 입력해 주세요");
        String menuName = sc.nextLine();
        System.out.println("상품 이름을 입력해 주세요");
        String productName = sc.nextLine();
        System.out.println("상품 설명을 입력해 주세요");
        String productDesc = sc.nextLine();
        System.out.println("상품 가격을 입력해 주세요");
        double price = sc.nextDouble();
        Product.createProduct(menuName, productName, productDesc,price);
    }

    private static void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[32m[ 상품 삭제 ]\n" +
                "삭제할 상품의 ID를 입력해 주세요\u001B[0m"
        );
        String productId = sc.nextLine();
        Boolean removeCheck = Product.deleteProduct(productId);
        if (removeCheck) {
            System.out.println("\u001B[34m해당상품이 삭제되었습니다\u001B[0m");
        } else {
            System.out.println("\u001B[31m해당상품은 상품목록에 없습니다\u001B[0m");
        }
    }

    private static void completeOrderList() {
        ArrayList<Order> completedOrders = KioskApp.completedOrders;
        double total = 0;
        System.out.println("\u001B[32m[ 완료 주문목록 ]\u001B[0m");
        for (Order order : completedOrders) {
            System.out.println("------------------------------");
            System.out.println("\u001B[36m대기 번호 : \u001B[0m" + order.getWaitingNum());
            System.out.print("\u001B[36m주문 상품 목록 : \u001B[0m| ");
            for(Product product : order.instanceMenus){
                System.out.print(product.getName() + " |");
                total = total + product.getPrice() * product.getCount();
            }
            System.out.println("\n\u001B[36m주문 총 가격 : W \u001B[0m" + total);
            total = 0;
            System.out.println("\u001B[36m주문 일시 : \u001B[0m" + order.getTime());
            System.out.println("\u001B[36m요청 사항 : \u001B[0m" + order.getOffer());
            System.out.println("\u001B[36m완료주문 일시 : \u001B[0m" + order.getCompleteTime());
            System.out.println("------------------------------");
        }
    }
}
