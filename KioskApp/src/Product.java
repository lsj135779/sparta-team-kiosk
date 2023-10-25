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

    public static void printIndex(ArrayList<Product> p) {
        for (int i = 0; i < p.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " +p.get(i).getName() + "   | W " + p.get(i).getPrice() + " | " + p.get(i).getDesc());
        }
    }

    //이걸로 숫자 나오는 프린트 함수 다 대체함
    public void printDescTotal() {
        System.out.println(super.getName() + "     | W " + this.getPrice() + " | " +(this.getCount()+1)+ "개 | " + super.getDesc());
    }

    public void printDesc() {
        System.out.println(super.getName() + "     | W " + this.getPrice() + " | " + super.getDesc());
    }

    public static void clear(ArrayList<Product> products) {//count 비우는 함수
        for (Product x : products) {//for문 돌면서 있으면 출력
            x.setCount(0);
        }
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

//    public String getName() {
//        return name;
//    }
//    public void setName(String name){
//        this.name = name;
//    };
}
