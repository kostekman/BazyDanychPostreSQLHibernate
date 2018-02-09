package edu.agh.bazyprojekt.endpoints;

import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.ReadOrdersRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders/deleteOrders")
public class DeleteOrdersEndpoint {
    @Autowired
    OrderController orderController;

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody
    boolean create(@RequestBody Map<String ,String> query){
        orderController
                .getOrder(query)
                .forEach((order) -> orderController.removeOrder(order));

        return true;
    }
}
