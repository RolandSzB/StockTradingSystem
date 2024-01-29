class StockTradingContext {
    private TradingStrategy tradingStrategy;

    public StockTradingContext(TradingStrategy tradingStrategy) {
        this.tradingStrategy = tradingStrategy;
    }

    public void executeStrategy(User user, Stock stock, int quantity) {
        tradingStrategy.execute(user, stock, quantity);
    }
}
