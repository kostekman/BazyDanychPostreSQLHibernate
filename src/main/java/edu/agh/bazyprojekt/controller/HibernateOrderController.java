package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.ReadOrdersRq;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.Validate.notNull;
import static org.springframework.util.Assert.notNull;

@Component
public class HibernateOrderController extends HibernateController implements OrderController {
    @Override
    public void createNewOrder(Order order) {
        saveObjectToDb(order);
    }

    @Override
    public Order mapJSONToOrder(HashMap<String, String> json) {
        Order newOrder = new Order();
        CustomerController customerController = new HibernateCustomerController();
        EmployeeController employeeController = new HibernateEmployeeController();
        ShipperController shipperController = new HibernateShipperController();

        Map<String,String> customerRestrictions = new HashMap<>();
        customerRestrictions.put("customerID",json.get("customerID"));
        newOrder.setCustomer(customerController.getCustomer(customerRestrictions).get(0));

        Map<String,String> employeeRestrictions = new HashMap<>();
        customerRestrictions.put("employeeId",json.get("employeeId") );
        newOrder.setEmployee(employeeController.getEmployee(employeeRestrictions).get(0));

        Map<String,String> shipperRestrictions = new HashMap<>();
        shipperRestrictions.put("shipperId", json.get("shipperId"));
        newOrder.setShippedBy(shipperController.getShipper(shipperRestrictions).get(0));

        newOrder.setFreight(Float.parseFloat(json.get("freight")));
        newOrder.setOrderDate( java.sql.Date.valueOf(LocalDate.now()));
        newOrder.setRequiredDate(java.sql.Date.valueOf(json.get("requiredDate")));
        newOrder.setShipAddress(json.get("shipAddress"));
        newOrder.setShipCity(json.get("shipCity"));
        newOrder.setShipCountry(json.get("shipCountry"));
        newOrder.setShipName(json.get("shipName"));
        newOrder.setShipPostalCode(json.get("shipPostalCode"));
        newOrder.setShipRegion(json.get("shipRegion"));

        return newOrder;
    }

    @Override
    public void alterOrder(Order order) {
        createNewOrder(order);
    }

    @Override
    public Order removeOrder(Order order) {
        return (Order)removeObjectFromDb(order);
    }

    public List<Order> getOrder(Map<String, String> query){
        return findObjects(Order.class, getPredicateProvider(query));
    }

    private BiFunction<CriteriaBuilder, Root<Order>, Predicate> getPredicateProvider(Map<String, String> query ){

        return (cb, root) -> {
            List<Predicate> predicates = query.entrySet()
                    .stream()
                    .map(entry -> createEqualPredicate(entry.getKey(), entry.getValue(), cb, root))
                    .collect(Collectors.toList());

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
