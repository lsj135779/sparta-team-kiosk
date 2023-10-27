import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Product{

    private String name;

    private String desc;

    private double price;

    private int count;

    private String id;

    public Product() {
    }

    public Product(String productName, String productDesc, double price, int count) {
        this.name = productName;
        this.desc = productDesc;
        this.price = price;
        this.count = count;

    }


    //새로 상품 추가할때
    public static void createProduct(String menuName, String productName, String productDesc, double price) {
        ArrayList<Menu> menus =KioskApp.menus;

        Product tempP = new Product(productName,productDesc,price,0);

        boolean newMenus = true;
        for (int i=0;i<menus.size();i++){
            if(menus.get(i).getName().equals(menuName)){
                tempP.setId(menuName + "#" +productName);
                menus.get(i).products.add(tempP);
                newMenus = false;//새 메뉴가 아님
                break;
            }
        }

        //for문을 도는 동안 같은 메뉴이름인게 안 나왔으면 새 메뉴임
        if(newMenus){
            System.out.println("메뉴 설명을 입력해 주세요");
            Scanner sc = new Scanner(System.in);
            String menuDesc = sc.nextLine();
            Menu tempM = new Menu(menuName,menuDesc);
            tempP.setId(menuName + "#" + productName);
            tempM.products.add(tempP);
            menus.add(tempM);
        }
    }

    public static Boolean deleteProduct(String productId) {
        ArrayList<Menu> menus = KioskApp.menus;
        String menuName = productId.split("#")[0];
        String productName = productId.split("#")[1];
        Boolean removeCheck = false;
        for (int i = 0; i < menus.size(); i++) {
            if (Objects.equals(menus.get(i).getName(), menuName)) { // 같은 메뉴
                for (int j = 0; j < menus.get(i).products.size(); j++) {
                    int productIdx;
                    if (Objects.equals(menus.get(i).products.get(j).getName(), productName)) { // 같은 상품
                        productIdx = j;
                        menus.get(i).products.remove(j);
                        removeCheck = true;
                        break;
                    }
                }
                // 메뉴안에 모든 상품이 삭제된 경우 해당 메뉴도 삭제
                if (menus.get(i).products.isEmpty()) {
                    menus.remove(i);
                }
            }
            if (removeCheck) break; // 불필요한 반복문 중지
        }
        return removeCheck;
    }

    public static void printIndex(ArrayList<Product> p) {
        for (int i = 0; i < p.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " +p.get(i).getName() + "   | W " + p.get(i).getPrice() + " | " + p.get(i).getDesc());
        }
    }

    //이걸로 숫자 나오는 프린트 함수 다 대체함
    public void printDescTotal() {
        System.out.println(getName() + "     | W " + this.getPrice() + " | " +(this.getCount()+1)+ "개 | " + getDesc());
    }

    public void printDesc() {
        System.out.println(getName() + "     | W " + this.getPrice() + " | " + getDesc());
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    };
}
