package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderController {
    void createNewOrder(Order order);
    Order mapJSONToOrder(Map<String,String> json);
    void alterOrder(Order order);
    Order removeOrder(Order order);
    List<Order> getOrder(Map<String, String> query);
}
