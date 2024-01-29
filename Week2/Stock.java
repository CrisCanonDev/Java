package Week2;

public class Stock implements java.io.Serializable {
    private String symbol;
    private String name;
    private double previousPrice;
    private double currentPrice;

    Stock(String newSymbol, String newName, Double newPreviousPrice, Double newCurrentPrice) {
        this.symbol = newSymbol;
        this.name = newName;
        this.previousPrice = newPreviousPrice;
        this.currentPrice = newCurrentPrice;
    }

    public double getChange() {
        return currentPrice - previousPrice;
    }

    public static void main(String[] args) {
        Stock s1 = new Stock("G", "Gold", 30.33, 40.21);
        System.out.println("Stock 1: " + s1.name + " (" + s1.symbol + ")\nPrevious price: " + s1.previousPrice
                + "\nCurrent price: " + s1.currentPrice);
        System.out.println("Price diffence: " + Math.round(s1.getChange() * 100.0) / 100.0);
    }
}
