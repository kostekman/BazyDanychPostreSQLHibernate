package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Order;
import edu.agh.bazyprojekt.model.ReadOrdersRq;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Component
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

    public List<Order> getOrder(ReadOrdersRq rq){
        return findObjects(Order.class, getPredicateProvider(rq));
    }

    private BiFunction<CriteriaBuilder, Root<Order>, Predicate> getPredicateProvider(ReadOrdersRq rq){
        if(rq.getBefore().isPresent() || rq.getAfter().isPresent()){
            notNull(rq.getDateField(), "dateField must not be null!");
        }
        return (cb, root) -> {
            List<Predicate> predicates = rq.getRestrictions().entrySet()
                    .stream()
                    .map(entry -> createEqualPredicate(entry.getKey(), entry.getValue(), cb, root))
                    .collect(Collectors.toList());

            rq.getBefore().ifPresent(date -> predicates.add(createLessThanPredicate(rq.getDateField(), date, cb, root)));
            rq.getAfter().ifPresent(date -> predicates.add(createGreaterThanPredicate(rq.getDateField(), date, cb, root)));

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));

        };
    }
}
