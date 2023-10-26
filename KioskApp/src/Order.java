import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public ArrayList<Product> instanceMenus;
    private String offer = "";

    private double total=0;

    public Order() {
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
