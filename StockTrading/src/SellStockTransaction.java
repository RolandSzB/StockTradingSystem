class SellStockTransaction implements Transaction {
    private User user;
    private Stock stock;
    private int quantity;

    public SellStockTransaction(User user, Stock stock, int quantity) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        // Sell stock implementation...
        // Add funds to user and update stock details
        user.removeFromPortfolio(stock);
        stock.setQuantity(stock.getQuantity() - quantity);
    }
}
