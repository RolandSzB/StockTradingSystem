class DayTradingStrategy implements TradingStrategy {
    @Override
    public void execute(User user, Stock stock, int quantity) {
        // Day trading implementation...
        // Assume immediate buy and sell for simplicity
        user.addToPortfolio(stock);
        StockMarket.getInstance().executeTransaction(new SellStockTransaction(user, stock, quantity));
    }
}
