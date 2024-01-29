class Stock {
    private String name;
    private String symbol;
    private double price;
    private int quantity;

    public Stock(String name, String symbol, double price, int quantity) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getSymbol() {
        return symbol;
    }
}
