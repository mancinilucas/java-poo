package application;

import entities.Product;
import util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

        #2 Implementação de interface
        list.removeIf(new ProductPredicate());

        #3 Referencia a um método static(method reference)
        list.removeIf(Product::staticProductPredicate);



        //#4 Referencia a um método non static(method reference)
        list.removeIf(Product::nonStaticProductPredicate);

         */

        //#5 expressão lambda declarada e inline
        double min = 100.0;

        //#5.1 Declarada
        // Predicate<Product> pred = product -> product.getPrice() >= min;
        // list.removeIf(pred);

        //#5.2 inline
        list.removeIf(product -> product.getPrice() >= min);

        for(Product p : list){
            System.out.println(p);
        }
    }
}
