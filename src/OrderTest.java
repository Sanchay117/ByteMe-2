import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void testOutOfStockOrder() {
        Customer test_customer = new Customer("test_customer1@gmail.com","TEST_JUNIT","foo",1);
        Food test_food = new Food("Thumbs Up",20,4,"drinks",false);
        Order test_order = new Order(new HashMap<Food,Integer>(){{
            put(test_food, 1);
        }}, "test", "test", "test",test_customer.getEmail() );

        String test_result = test_customer.checkOut(test_order);
        assertEquals("FAILURE: TEST FAILED",test_customer.outOfStockItemOrder,test_result);

    }

}
