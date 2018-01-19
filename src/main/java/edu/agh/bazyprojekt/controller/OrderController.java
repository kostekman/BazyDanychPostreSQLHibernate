package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.ReadOrdersRq;

import java.util.List;

public interface OrderController {
    void createNewOrder(Order order);
    void alterOrder(Order order);
    Order removeOrder(Order order);
    List<Order> getOrder(ReadOrdersRq rq);
}
