package infnet.selenium;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Client client = new Client("João", "joao@email.com");
        Order order = new Order(client);

        order.addItem(new Item("Notebook", 1, 3500.0));
        order.addItem(new Item("Mouse", 2, 80.0));

        order.printInvoice();
        order.sendEmail();
    }
}






