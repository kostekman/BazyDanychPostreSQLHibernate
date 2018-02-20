package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface CustomerController {

    void createNewCustomer(Customer customer);
    void alterCustomer(Customer customer);
    Customer removeCustomer(Customer customer);
    List<Customer> getCustomer(Map<String,String> restrictions);
}
