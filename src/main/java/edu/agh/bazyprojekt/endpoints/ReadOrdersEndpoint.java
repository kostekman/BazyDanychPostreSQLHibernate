package edu.agh.bazyprojekt.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.agh.bazyprojekt.controller.EmployeeController;
import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.model.Employee;
import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.ReadOrdersRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/readOrders")
public class ReadOrdersEndpoint {

    @Autowired
    OrderController orderController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Order> read(@RequestBody ReadOrdersRq query) throws OperationNotSupportedException, JsonProcessingException {
        return orderController.getOrder(query);
    }
}
