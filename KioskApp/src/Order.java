import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public ArrayList<Product> instanceMenus;
    private String offer = "";
    private double total = 0;
    private String time;
    private int waitingNum;
    private String completeTime;
    public Order() {
    }

    public static double printTotal(ArrayList<Order> orders){
        double total = 0;
        for (Order o : orders) {
            double totalPerOrder = 0;
            for (Product p : o.instanceMenus) {
                p.printDescTotal();
                totalPerOrder = totalPerOrder + p.getPrice()*p.getCount();
            }
            total = total + totalPerOrder;
            System.out.println("W "+totalPerOrder+"\n------------------------------");
        }
        return total;
    }

    public int getWaitingNum() {
        return waitingNum;
    }

    public void setWaitingNum(int waitingNum) {
        this.waitingNum = waitingNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompleteTime() {
        return completeTime;
    }
    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getOffer(){
        return this.offer;
    }
    public void setOffer(String offer){
        this.offer = offer;
    }

    public void setTotal(double total){
        this.total = total;
    }
    public double getTotal(){
        return this.total;
    }
}
