import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private static int waitingNum = 0;
    public static ArrayList<Product> instanceMenus;
    private static double total = 0;
    private static String offer = "";
    private static String dateTime = "";

    public Order() {}

    public static String checkOrder() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order[" +
                "waitingNum=" + waitingNum +
                ", Menus = ");

        for(Product menu : instanceMenus){
            sb.append(menu.getName());
            sb.append(" ");
        }

        sb.append(", total=" + total +
                ", offer='" + offer + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ']'+'\n');

        return  sb.toString();
    }
    public static void completeOrder(){

    }
    public String getDateTime() {
        return dateTime;
    }

    public static void setInstanceMenus(ArrayList<Product> instanceMenus) {
        Order.instanceMenus = instanceMenus;
    }

    public static ArrayList<Product> getInstanceMenus() {
        return instanceMenus;
    }

    public void setDateTime(String dateTime) { this.dateTime = dateTime;}
    public void setOffer(String offer){this.offer = offer;}
    public void setTotal(double total){
        this.total = total;
    }
    public double getTotal(){
        return this.total;
    }
    public void setWaitingNum(int waitingNum) {this.waitingNum = waitingNum;}
}
