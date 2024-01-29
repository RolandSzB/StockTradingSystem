class LongTermInvestingStrategy implements TradingStrategy {
    @Override
    public void execute(User user, Stock stock, int quantity) {
        // Long-term investing implementation...
        user.addToPortfolio(stock);
    }
}