import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockPrediction {
    public static void main(String[] args) {
        List<Double> stockPrices = generateRandomStockPrices(100);
        double prediction = predictStockPrice(stockPrices);
        
        System.out.println("Historical Stock Prices:");
        for (double price : stockPrices) {
            System.out.println(price);
        }
        
        System.out.println("\nPredicted Stock Price: " + prediction);
    }

    // Generate random historical stock prices (for demonstration purposes)
    public static List<Double> generateRandomStockPrices(int numPrices) {
        List<Double> stockPrices = new ArrayList<>();
        Random random = new Random();
        
        double initialPrice = 100.0;
        stockPrices.add(initialPrice);
        
        for (int i = 1; i < numPrices; i++) {
            double priceChange = (random.nextDouble() - 0.5) * 5.0; // Simulated price change
            double newPrice = stockPrices.get(i - 1) + priceChange;
            stockPrices.add(newPrice);
        }
        
        return stockPrices;
    }

    // Simple stock price prediction using a moving average
    public static double predictStockPrice(List<Double> stockPrices) {
        int numPrices = stockPrices.size();
        if (numPrices < 2) {
            return 0.0; // Not enough data for prediction
        }
        
        double sum = 0.0;
        for (double price : stockPrices) {
            sum += price;
        }
        
        double average = sum / numPrices;
        double prediction = stockPrices.get(numPrices - 1) + (stockPrices.get(numPrices - 1) - average);
        
        return prediction;
    }
}
