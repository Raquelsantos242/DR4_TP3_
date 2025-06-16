package infnet.selenium;

import java.util.ArrayList;
import java.util.List;
class Order {
    private final Client client;
    private final List<Item> items = new ArrayList<>();
    private final double discountRate = 0.1;

    public Order(Client client) {
        this.client = client;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private double calculateSubtotal() {
        return items.stream()
                .mapToDouble(Item::getTotalPrice)
                .sum();
    }

    private double calculateDiscount(double subtotal) {
        return subtotal * discountRate;
    }

    private double calculateTotal(double subtotal, double discount) {
        return subtotal - discount;
    }

    private void printHeader() {
        System.out.println("Cliente: " + client.getName());
    }

    private void printItems() {
        items.forEach(item ->
                System.out.println(item.getQuantity() + "x " +
                        item.getProduct() + " - R$" +
                        item.getPrice()));
    }

    private void printSummary(double subtotal, double discount, double total) {
        System.out.println("Subtotal: R$" + subtotal);
        System.out.println("Desconto: R$" + discount);
        System.out.println("Total final: R$" + total);
    }

    public void printInvoice() {
        printHeader();
        printItems();

        double subtotal = calculateSubtotal();
        double discount = calculateDiscount(subtotal);
        double total = calculateTotal(subtotal, discount);

        printSummary(subtotal, discount, total);
    }

    public void sendEmail() {
        EmailService.sendConfirmation(client.getEmail());
    }
}