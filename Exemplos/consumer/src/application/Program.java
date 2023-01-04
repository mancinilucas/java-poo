package application;

import entities.Product;
import util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.0));
        list.add(new Product("Tablet", 400.0));
        list.add(new Product("Case", 80.9));

        //#1 list.forEach(new PriceUpdate());

        //#2 list.forEach(Product::staticPriceUpdate);

        //#3 list.forEach(Product::nonStaticPriceUpdate);

        double rise = 1.1;

        /*
        Consumer<Product> consumer = p -> p.setPrice(p.getPrice() * rise);
        list.forEach(consumer);
        */

        list.forEach(p -> p.setPrice(p.getPrice() * rise));
        list.forEach(System.out::println);

    }
}
