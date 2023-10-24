import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    public static void main(String args[]){

        int select;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.\n" +
                    "접속할 앱을 선택해 주세요.\n" +
                    "1. 주문         | 주문\n" +
                    "2. 관리  | 매장 관리\n"
            );
            select = sc.nextInt();

            switch(select){
                case 1 : KioskApp.run();
                    break;
                case 2 : ManagerApp.run();
                    break;
                default:
                    System.out.println("다시 선택해 주세요");
            }
        }
    }
}
