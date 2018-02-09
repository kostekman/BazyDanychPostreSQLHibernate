package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.OrderDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderDetailsController {

    void createNewOrderDetails(OrderDetails orderDetails);
    OrderDetails mapJSONToOrderDetails(HashMap<String,String> json);
    void alterOrderDetails(OrderDetails orderDetails);
    OrderDetails removeOrderDetails(OrderDetails orderDetails);
    List<OrderDetails> getOrderDetails(Map<String, String> query);
}
