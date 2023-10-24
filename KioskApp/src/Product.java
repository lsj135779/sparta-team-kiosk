public class Product extends Menu {
    private double price;

    private int count;

    private int id;

    public Product() {
    }

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;

    }
    public void printDesc() {
    }

     public void printDescTotal(){
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
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;

    }
}
