import java.util.Scanner;

public class ManagerApp {
    public static void run(){
        int select;
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
                for(int i=0;i<KioskApp.orders.size();i++){
                    System.out.println(KioskApp.orders.get(i).checkOrder());
                }

            }else if(select ==2){//완료주문 목록 함수 호출

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

//    public static int confirm(String s){ //이렇게 입력할 거냐고 물어보는 함수 나중에 구현, String /double 오버로딩
//
//
//
//    }
}
