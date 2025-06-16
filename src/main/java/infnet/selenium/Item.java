package infnet.selenium;

class Item {
    private final String product;
    private final int quantity;
    private final double price;

    public Item(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}