package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        //#1 forma
        //list.sort(new MyComparator());

        /* #2 forma
        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
            }
        };

        list.sort(comp);
        */

        /* #3 forma (lambda/arrow)
        Comparator<Product> comp = (o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());

        list.sort(comp);
        */

        //#4 forma
        list.sort((o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase()));

        for(Product p : list){
            System.out.println(p);
        }

    }
}
