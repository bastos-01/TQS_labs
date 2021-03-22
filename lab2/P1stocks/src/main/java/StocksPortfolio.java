import java.util.ArrayList;

public class StocksPortfolio{

    private String name;
    private ArrayList<Stock> stocksList = new ArrayList<>();
    private IStockMarket market;

    public IStockMarket getMarketService(){
        return this.market;
    }

    public void setMarketService(IStockMarket marketService){
        this.market = marketService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalValue(){
        double t = 0;

        for (Stock stock : this.stocksList)
            t = t + (stock.getQuantity() * this.market.getPrice(stock.getName()));

        return t;
    }

    public void addStock(Stock stock){
        this.stocksList.add(stock);
    }


}
