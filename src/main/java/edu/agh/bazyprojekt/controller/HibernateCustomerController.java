package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Customer;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
public class HibernateCustomerController extends HibernateController implements  CustomerController{
    @Override
    public void createNewCustomer(Customer customer) {

    }

    @Override
    public void alterCustomer(Customer customer) {

    }

    @Override
    public Customer removeCustomer(Customer customer) {
        return null;
    }

    private BiFunction<CriteriaBuilder, Root<Customer>, Predicate> getPredicateProvider(Map<String, String> restrictions) {
        return (cb, root) -> {
            List<Predicate> predicates = restrictions.entrySet()
                    .stream()
                    .map(entry -> createEqualPredicate(entry.getKey(), entry.getValue(), cb, root))
                    .collect(Collectors.toList());

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    @Override
    public List<Customer> getCustomer(Map<String, String> restrictions) {
        return findObjects(Customer.class, getPredicateProvider(restrictions));
    }
}
