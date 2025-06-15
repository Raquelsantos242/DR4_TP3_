package infnet.selenium;

import java.util.ArrayList;
import java.util.List;

class Order {
    private String clientName;
    private String clientEmail;
    private final List<Item> items = new ArrayList<>();
    private double discountRate = 0.1;

    public void addItem(Item item) {
        items.add(item);
    }

    public void printInvoice() {
        double subtotal = calculateSubtotal();

        System.out.println("Cliente: " + clientName);
        for (Item item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct()
                    + " - R$" + item.getPrice());
        }
        System.out.println("Subtotal: R$" + subtotal);
        System.out.println("Desconto: R$" + (subtotal * discountRate));
        System.out.println("Total final: R$" + (subtotal * (1 - discountRate)));
    }

    private double calculateSubtotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void sendEmail() {
        // Encapsulamento da dependência externa
        String subject = "Pedido recebido!";
        String body = "Obrigado pela compra.";
        sendEmailInternal(subject, body);
    }

    private void sendEmailInternal(String subject, String body) {
        // Lógica de envio encapsulada
        System.out.println("Enviando e-mail para " + clientEmail +
                "\nAssunto: " + subject +
                "\nCorpo: " + body);
    }

    // Getters e Setters
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
}