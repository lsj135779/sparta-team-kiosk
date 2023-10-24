public class Product extends Menu {
    private double price;

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



    public double getPrice() {
        return this.price;
    }
    public void setPrice(double d){
        this.price = d;
    }
}
