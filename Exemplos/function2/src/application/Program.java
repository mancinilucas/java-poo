package application;

import entities.Product;
import model.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("Case", 80.00));

        ProductService ps = new ProductService();

        double let = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
        double sum = ps.filteredSum(list, p -> p.getPrice() < 100.0);

        System.out.println(let);
        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
