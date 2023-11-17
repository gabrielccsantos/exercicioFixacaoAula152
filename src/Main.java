import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        DateTimeFormatter fmtBirthDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = read.nextLine();
        System.out.print("Email: ");
        String clientEmail = read.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String clientBirthDate = read.nextLine();

        LocalDate date = LocalDate.parse(clientBirthDate, fmtBirthDate);

        Client client = new Client(clientName, clientEmail, date);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(read.nextLine());

        LocalDateTime moment = LocalDateTime.now();


        Order order = new Order(moment, status, client);

        System.out.print("How many itens to this order? ");
        int itens = read.nextInt();

        read.nextLine();

        for(int i = 0; i < itens; i++){
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            String productName = read.nextLine();
            System.out.print("Product price: ");
            double productPrice = read.nextDouble();
            System.out.print("Quantity: ");
            int quantity = read.nextInt();

            Product product = new Product(productName, productPrice);

            OrderItem orderItem = new OrderItem(quantity,productPrice, product);

            order.addItem(orderItem);

            read.nextLine();
        }

        System.out.println();
        System.out.println(order);

        read.close();
    }
}
