package edu.agh.bazyprojekt.endpoints;

import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.controller.OrderDetailsController;
import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.OrderDetails;
import edu.agh.bazyprojekt.model.OrderRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders/updateOrders")
public class UpdateOrdersEndpoint {
    @Autowired
    OrderController orderController;
    @Autowired
    OrderDetailsController orderDetailsController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    boolean update(@RequestBody Map<String,String> json){

        Map<String,String > orderRestriction = new HashMap<>();
        orderRestriction.put("orderId",json.get("orderId"));
        Order orderToUpdate = orderController.getOrder(orderRestriction).get(0);
        Order newOrderValues = orderController.mergeOrders(orderToUpdate, orderController.mapJSONToOrder(json));

        orderController.alterOrder(newOrderValues);

        return true;
    }
}
