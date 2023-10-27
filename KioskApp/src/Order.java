import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public ArrayList<Product> instanceMenus;
    private String offer = "";
    private double total = 0;
    private String time;
    private int waitingNum;
    public Order() {
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
