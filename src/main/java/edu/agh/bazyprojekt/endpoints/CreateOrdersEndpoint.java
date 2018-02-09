package edu.agh.bazyprojekt.endpoints;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.agh.bazyprojekt.controller.HibernateOrderDetailsController;
import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.controller.OrderDetailsController;
import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.OrderDetails;
import edu.agh.bazyprojekt.model.OrderRequestBody;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders/createOrders")
public class CreateOrdersEndpoint {
    @Autowired
    OrderController orderController;
    @Autowired
    OrderDetailsController orderDetailsController;


    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody boolean create(@RequestBody OrderRequestBody orderRequestBody){

        System.out.println(orderRequestBody.getOrderInfo());
        System.out.println(orderRequestBody.getOrderDetails());
        Order newOrder = orderController.mapJSONToOrder( orderRequestBody.getOrderInfo() );
        orderController.createNewOrder(newOrder);

        for (OrderDetails orderDetails :
                orderRequestBody.getOrderDetails()) {
            orderDetails.setOrderId(newOrder.getOrderId());
            orderDetailsController.createNewOrderDetails(orderDetails);
        }


        return true;
    }

}
