package edu.agh.bazyprojekt.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.agh.bazyprojekt.controller.CustomerController;
import edu.agh.bazyprojekt.model.Customer;
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
@RequestMapping("/customers/readCustomers")
public class ReadCustomersEndpoint {

    @Autowired
    CustomerController customerController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Customer> read(@RequestBody Map<String ,String> query) throws OperationNotSupportedException, JsonProcessingException {
        return customerController.getCustomer(query);
    }
}

