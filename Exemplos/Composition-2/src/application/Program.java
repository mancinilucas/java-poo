package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com as informações do cliente: ");
        System.out.print("Nome: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(clientName,clientEmail,birthDate);

        System.out.println("Entre com as informações do pedido:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos itens nesse pedido? ");
        int numberOfProducts = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < numberOfProducts; i++){
            System.out.println("Entre com as informações do item #" + (i + 1));
            System.out.print("Nome do produto: ");
            String productName = sc.nextLine();
            System.out.print("Preço do produto: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();
            System.out.print("Quantidade: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);

        sc.close();
    }
}
