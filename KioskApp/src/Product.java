import java.util.ArrayList;

public class Product extends Menu {
    private double price;

    private int count;

    private String id;

    public Product() {
    }

    public Product(String name, String desc, double price, int count) {
        super(name, desc);
        this.price = price;
        this.count = count;
    }

    //이걸로 숫자 나오는 프린트 함수 다 대체함
    public void printDescTotal() {
        System.out.println(super.getName() + "     | W " + this.getPrice() + " | " +(this.getCount()+1)+ "개 | " + super.getDesc());
    }

    public void printDesc() {
        System.out.println(super.getName() + "     | W " + this.getPrice() + " | " + super.getDesc());
    }

    /*getter,setter*/
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double d){
        this.price = d;
    }


    public int getCount(){
        return this.count;
    }

    public void setCount(int count ){
        this.count = count;

    }
    public void increaseCount(){
        this.count = this.count+1;
    }
    public void decreaseCount(){
        this.count = this.count-1;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;

    }
}
