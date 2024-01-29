class BuyStockTransaction implements Transaction {
    private User user;
    private Stock stock;
    private int quantity;

    public BuyStockTransaction(User user, Stock stock, int quantity) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        // Buy stock implementation...
        // Deduct funds from user and update stock details
        user.addToPortfolio(stock);
        stock.setQuantity(stock.getQuantity() + quantity);
    }
}
