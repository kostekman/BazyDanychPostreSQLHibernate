package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;

public interface OrderController {
    void createNewOrder(Order order);
    void alterOrder(Order order);
    Order removeOrder(Order order);
    Order getOrderById(int id);
}
