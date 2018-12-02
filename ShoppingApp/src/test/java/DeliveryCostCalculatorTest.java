import com.trendyol.model.Category;
import com.trendyol.model.DeliveryCostCalculator;
import com.trendyol.model.Product;
import com.trendyol.model.event.ShoppingCart;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DeliveryCostCalculatorTest {

    @Test
    @Parameters({"0,0,2.9", "1,0.5,4.9"})
    public void testCalculateFor(double costPerDelivery, double costPerProduct, double totalDelivery) {
        Category food = new Category("food");
        Product apple = new Product("Apple", 100.0, food);
        Product almond = new Product("Almonds", 150.0, food);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(apple, 3);
        cart.addItem(almond, 1);

        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(costPerDelivery, costPerProduct);
        double actual = deliveryCostCalculator.calculateFor(cart);

        assertEquals(totalDelivery, actual, 00001);
    }

}
