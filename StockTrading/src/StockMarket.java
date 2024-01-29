import java.util.ArrayList;
import java.util.List;

class StockMarket {
    private static StockMarket instance;
    private List<Stock> availableStocks;
    private List<User> users;
    private List<Transaction> transactionHistory;

    private StockMarket() {
        availableStocks = new ArrayList<>();
        users = new ArrayList<>();
        transactionHistory = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        availableStocks.add(stock);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public List<Stock> getAvailableStocks() {
        return availableStocks;
    }

    public void executeTransaction(Transaction transaction) {
        transaction.execute();
        transactionHistory.add(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    public List<User> getUsers() {
        return users;
    }
}

