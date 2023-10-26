import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public ArrayList<Product> products;
    private String name;
    private String desc;

    private String id;

    public static void createMenu(String name, String desc){
        ArrayList<Menu> menus =KioskApp.menus;
        boolean newMenus = true;
        for (int i=0;i<menus.size();i++){
            if(menus.get(i).getName().equals(name)){
                newMenus = false;//새 메뉴가 아님
                System.out.println("이미 존재하는 메뉴입니다.");
            }
        }
        //for문을 도는 동안 같은 메뉴이름인게 안 나왔으면 새 메뉴임
        if(newMenus){
            menus.add(new Menu(name,desc));
        }
    }

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.products = new ArrayList<Product>();
        this.id = "Menu"+products.size();
    }
    public static int printIndex(ArrayList<Menu> m) {
        int i=0;
        for (; i < m.size(); i++) {//for문 돌면서 있으면 출력
            System.out.println((i + 1) + ". " +m.get(i).getName() + " | " + m.get(i).getDesc());
        }
        return i+1;
    }

    /*getter, setter*/
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
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

}
