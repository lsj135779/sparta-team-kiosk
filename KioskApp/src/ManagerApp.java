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
                kioskApp.printAllProduct(); // 민선님이 추가기능으로 총 판매목록 만든거 있어서 여기서 시간만 추가해서 쓰시면 될거같아요
            }else if(select ==3){//상품 생성 함수 호출
                createProduct();

            }else if(select ==4){//상품 삭제 함수 호출

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
}
