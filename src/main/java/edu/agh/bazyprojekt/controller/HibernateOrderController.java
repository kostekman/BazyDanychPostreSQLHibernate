package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


@Component
public class HibernateOrderController extends HibernateController implements OrderController {
    @Override
    public void createNewOrder(Order order) {
        saveObjectToDb(order);
    }

    @Override
    public Order mapJSONToOrder(Map<String, String> json) {
        Order newOrder = new Order();
        CustomerController customerController = new HibernateCustomerController();
        EmployeeController employeeController = new HibernateEmployeeController();
        ShipperController shipperController = new HibernateShipperController();

        if ( json.get("customerID") != null){

            Map<String,String> customerRestrictions = new HashMap<>();
            customerRestrictions.put("customerID", json.get("customerID") );
            newOrder.setCustomer(customerController.getCustomer(customerRestrictions).get(0));
        }

        if ( json.get("employeeId") != null){
            Map<String,String> employeeRestrictions = new HashMap<>();
            employeeRestrictions.put("employeeId", json.get("employeeId") );
            newOrder.setEmployee(employeeController.getEmployee(employeeRestrictions).get(0));
        }

        if ( json.get("shipperId") != null){
            Map<String,String> shipperRestrictions = new HashMap<>();
            shipperRestrictions.put("shipperId", json.get("shipperId") );
            newOrder.setShippedBy(shipperController.getShipper(shipperRestrictions).get(0));
        }

        if ( json.get("freight") != null) newOrder.setFreight(Float.parseFloat(json.get("freight")));
        if ( json.get("orderDate") != null) newOrder.setOrderDate( java.sql.Date.valueOf(json.get("orderDate")));
        if ( json.get("requiredDate") != null)  newOrder.setRequiredDate(java.sql.Date.valueOf(json.get("requiredDate")));
        if ( json.get("shipAddress") != null) newOrder.setShipAddress(json.get("shipAddress"));
        if ( json.get("shipCity") != null) newOrder.setShipCity(json.get("shipCity"));
        if ( json.get("shipCountry") != null) newOrder.setShipCountry(json.get("shipCountry"));
        if ( json.get("shipName") != null) newOrder.setShipName(json.get("shipName"));
        if ( json.get("shipPostalCode") != null) newOrder.setShipPostalCode(json.get("shipPostalCode"));
        if ( json.get("shipRegion") != null) newOrder.setShipRegion(json.get("shipRegion"));

        return newOrder;
    }

    @Override
    public void alterOrder(Order newValues) {
        createNewOrder(newValues);

    }


    @Override
    public Order removeOrder(Order order) {
        return (Order)removeObjectFromDb(order);
    }

    public List<Order> getOrder(Map<String, String> query){
        return findObjects(Order.class, getPredicateProvider(query));
    }

    @Override
    public Order mergeOrders(Order oldOrder, Order newOrder) {
        if (newOrder.getOrderDate() != null ) oldOrder.setOrderDate(newOrder.getOrderDate());
        if (newOrder.getRequiredDate() != null ) oldOrder.setRequiredDate(newOrder.getRequiredDate());
        if (newOrder.getShippedDate() != null) oldOrder.setShippedDate(newOrder.getShippedDate());
        if (newOrder.getFreight() != null) oldOrder.setFreight(newOrder.getFreight());
        if (newOrder.getShipName() != null ) oldOrder.setShipName(newOrder.getShipName());
        if (newOrder.getShipAddress() != null ) oldOrder.setShipAddress(newOrder.getShipAddress());
        if (newOrder.getShipCity() != null) oldOrder.setShipCity(newOrder.getShipCity());
        if (newOrder.getShipRegion() != null) oldOrder.setShipRegion(newOrder.getShipRegion());
        if (newOrder.getShipPostalCode() != null) oldOrder.setShipPostalCode(newOrder.getShipPostalCode());
        if (newOrder.getShipCountry() != null) oldOrder.setShipCountry(newOrder.getShipCountry());
        return oldOrder;
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
