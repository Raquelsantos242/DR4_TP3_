package infnet.selenium;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Order order = new Order();
        order.setClientName("João");
        order.setClientEmail("joao@email.com");

        order.addItem(new Item("Notebook", 1, 3500.0));
        order.addItem(new Item("Mouse", 2, 80.0));

        order.printInvoice();
        order.sendEmail();
    }
}






