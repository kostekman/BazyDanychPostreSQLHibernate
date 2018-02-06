package edu.agh.bazyprojekt.endpoints;


import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders/createOrders")
public class CreateOrdersEndpoint {
    @Autowired
    OrderController orderController;

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody boolean create(@RequestBody HashMap<String ,String> query){
        Order newOrder = orderController.mapJSONToOrder(query);
        orderController.createNewOrder(newOrder);
        return true;
    }

}
