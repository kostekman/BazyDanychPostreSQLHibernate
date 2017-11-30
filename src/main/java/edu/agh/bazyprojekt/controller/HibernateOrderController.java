package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibernateOrderController extends HibernateController implements OrderController {
    @Override
    public void createNewOrder(Order order) {
        saveObjectToDb(order);
    }

    @Override
    public void alterOrder(Order order) {
        createNewOrder(order);
    }

    @Override
    public Order removeOrder(Order order) {
        return (Order)removeObjectFromDb(order);
    }

    public Order getOrderById(int id){
        Session session = sessionFactory.openSession();

        Query<Order> query = session.createQuery("FROM Order o where o.id = :id");
        query.setParameter("id", (short)id);
        Order order = query.stream().findFirst().orElse(null);
        session.close();
        return order;
    }
}
