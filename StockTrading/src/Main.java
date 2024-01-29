import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = StockMarket.getInstance();
        Scanner scanner = new Scanner(System.in);

        Stock appleStock = new Stock("Apple Inc.", "AAPL", 150.0, 10);
        Stock googleStock = new Stock("Alphabet Inc.", "GOOGL", 2000.0, 5);

        stockMarket.addStock(appleStock);
        stockMarket.addStock(googleStock);

        System.out.println("Welcome to the Console Stock Trading System!");

        while (true) {
            System.out.println("\n1. View Available Stocks");
            System.out.println("2. Register User");
            System.out.println("3. Buy Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableStocks(stockMarket);
                    break;
                case 2:
                    registerUser(stockMarket, scanner);
                    break;
                case 3:
                    buyStock(stockMarket, scanner);
                    break;
                case 4:
                    viewPortfolio(stockMarket, scanner);
                    break;
                case 5:
                    viewTransactionHistory(stockMarket);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAvailableStocks(StockMarket stockMarket) {
        System.out.println("\nAvailable Stocks:");
        for (Stock stock : stockMarket.getAvailableStocks()) {
            System.out.println(stock.getName() + " (" + stock.getSymbol() + "): $" + stock.getPrice());
        }
    }

    private static void registerUser(StockMarket stockMarket, Scanner scanner) {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        User user = new User(username);
        stockMarket.registerUser(user);
        System.out.println("User registered successfully!");
    }

    private static void buyStock(StockMarket stockMarket, Scanner scanner) {
        viewAvailableStocks(stockMarket);
        System.out.print("\nEnter stock symbol to buy: ");
        String symbol = scanner.nextLine();
        Stock selectedStock = findStockBySymbol(stockMarket, symbol);

        if (selectedStock != null) {
            System.out.print("Enter quantity to buy: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            User user = getUser(stockMarket, scanner);
            if (user != null) {
                stockMarket.executeTransaction(new BuyStockTransaction(user, selectedStock, quantity));
                System.out.println("Stock bought successfully!");
            }
        } else {
            System.out.println("Invalid stock symbol. Please try again.");
        }
    }

    private static void viewPortfolio(StockMarket stockMarket, Scanner scanner) {
        User user = getUser(stockMarket, scanner);
        if (user != null) {
            System.out.println("\n" + user.getUsername() + "'s Portfolio:");
            for (Stock stock : user.getPortfolio()) {
                System.out.println(stock.getName() + " (" + stock.getSymbol() + "): Quantity - " + stock.getQuantity());
            }
        }
    }

    private static void viewTransactionHistory(StockMarket stockMarket) {
        System.out.println("\nTransaction History:");
        List<Transaction> transactionHistory = stockMarket.getTransactionHistory();
        for (Transaction transaction : transactionHistory) {
            System.out.println("Transaction: " + transaction.getClass().getSimpleName());
        }
    }

    private static Stock findStockBySymbol(StockMarket stockMarket, String symbol) {
        for (Stock stock : stockMarket.getAvailableStocks()) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null;
    }

    private static User getUser(StockMarket stockMarket, Scanner scanner) {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        for (User user : stockMarket.getUsers()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        System.out.println("User not found. Please register first.");
        return null;
    } }