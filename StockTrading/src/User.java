import java.util.ArrayList;
import java.util.List;

class User implements StockObserver {
    private String username;
    private List<Stock> portfolio;

    public User(String username) {
        this.username = username;
        this.portfolio = new ArrayList<>();
    }

    public void addToPortfolio(Stock stock) {
        portfolio.add(stock);
    }
    public void removeFromPortfolio(Stock stock) {
        portfolio.remove(stock);
    }
    @Override
    public void update(Stock stock) {
        System.out.println(username + ": Stock price update - " + stock.getName() + ": $" + stock.getPrice());
    }
    public String getUsername() {
        return username;
    }

    public List<Stock> getPortfolio() {
        return portfolio;
    }
}
