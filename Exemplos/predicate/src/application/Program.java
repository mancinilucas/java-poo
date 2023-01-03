package application;

import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

       List<Product> list = new ArrayList<>();

       list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 400.00));
        list.add(new Product("Case", 80.90));

        /*
        #1
        list.removeIf(p -> p.getPrice() >= 100);
        */

        //#2 Implementação de interface
        list.removeIf(new ProductPredicate());

        for(Product p : list){
            System.out.println(p);
        }
    }
}
