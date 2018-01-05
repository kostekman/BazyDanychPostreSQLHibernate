package edu.agh.bazyprojekt;

import edu.agh.bazyprojekt.controller.*;
import edu.agh.bazyprojekt.hibernateUtils.HibernateSessionFactory;
import edu.agh.bazyprojekt.model.*;
import edu.agh.bazyprojekt.model.Employee;
import edu.agh.bazyprojekt.model.Order;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            HibernateController<Employee> employeeHibernateController = new HibernateController<>(session);

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Order> orderCriteriaQuery = criteriaBuilder.createQuery(Order.class);

            Root<Order> orderRoot = orderCriteriaQuery.from(Order.class);
            Join<Order, Customer> customer = orderRoot.join("customer");
            Join<Order, OrderDetails> orderDetails = orderRoot.join("orderDetails");
            Join<OrderDetails, Product> product = orderRoot.joinList("orderDetails").join("product");
            orderCriteriaQuery.where(criteriaBuilder.in(product.get("productName")).value("Chai"));

            TypedQuery<Order> orderTypedQuery = session.createQuery(orderCriteriaQuery);

            Order order = orderTypedQuery.getResultList().get(0);

            for(int i = 0; i < order.getOrderDetails().size(); i++){
                System.out.println(order.getOrderDetails().get(i));
            }

            for(OrderDetails od : order.getOrderDetails()){
                System.out.println(od);
            }


            System.out.println(orderTypedQuery.getResultList().get(0));
        }
    }

}
