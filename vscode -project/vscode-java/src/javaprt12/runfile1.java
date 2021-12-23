package javaprt12;

import java.util.ArrayList;
import java.util.HashMap;

public class runfile1{
    public static void main(String[] args) {
        ArrayList<product>list_products=new ArrayList<>();
        HashMap<String ,product>map_products=new HashMap<>();
        System.out.print("Print from list:\n");
        product product1=new product("1","book1","publish1");
        product product2=new product("2","book2","publish2");
        product product3=new product("3","book3","publish3");
        list_products.add(product1);
        list_products.add(product2);
        list_products.add(product3);
        list_products.forEach(e->System.out.print(e));
        map_products.put(product1.getnumber(), product1);
        map_products.put(product2.getnumber(), product2);
        map_products.put(product3.getnumber(), product3);
        System.out.print("Print from map:\n");
        map_products.forEach((number,product)->System.out.print(product));
    }
}