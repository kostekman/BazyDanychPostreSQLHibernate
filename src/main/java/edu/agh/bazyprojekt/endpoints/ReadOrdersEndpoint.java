package edu.agh.bazyprojekt.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import edu.agh.bazyprojekt.model.ReadOrdersRq;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders/readOrders")
public class ReadOrdersEndpoint {

    @Autowired
    OrderController orderController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Order> read(@RequestBody Map<String, String> query) throws OperationNotSupportedException, JsonProcessingException {
        return orderController.getOrder(query);
    }
}
