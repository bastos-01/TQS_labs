import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    IStockMarket market;

    @InjectMocks
    StocksPortfolio portfolio;

    @Test
    void getTotalValueTest() {

        Mockito.when( market.getPrice("EBAY")).thenReturn(3.5);
        Mockito.when( market.getPrice("APPLE")).thenReturn(5.0);

        portfolio.addStock(new Stock("EBAY", 3));
        portfolio.addStock(new Stock("APPLE", 4));

        double result = portfolio.getTotalValue();

        //assertEquals(30.5, result);
        assertThat(result, is(30.5));
        Mockito.verify(market, Mockito.times(2)).getPrice(Mockito.anyString());

    }
}