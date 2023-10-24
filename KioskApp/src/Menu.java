public class Menu {
    private String name;
    private String desc;

    public Menu() {
    }

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void printDesc() {
    }
    public void printDescTotal(){}
    public double getPrice() {
        return 0;
    }

    public void setPrice(){}

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;

    }

    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }

}
