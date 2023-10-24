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

            }else if(select ==2){//완료주문 목록 함수 호출


            }else if(select ==3){//상품 생성 함수 호출

            }else if(select ==4){//상품 삭제 함수 호출

            }else if(select ==5){//나가기,while문 break함
                break;
            }
        }

    }
}
