package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Product;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
public class HibernateProductController extends HibernateController implements ProductController {

    @Override
    public void createNewProduct(Product product) {
        saveObjectToDb(product);
    }

    @Override
    public Product mapJSONToProduct(Map<String, String> json) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        createNewProduct(product);
    }

    @Override
    public Product removeProduct(Product product) {
        return (Product)removeObjectFromDb(product);
    }

    @Override
    public List<Product> getProduct(Map<String, String> restrictions) {

        return findObjects(Product.class, getPredicateProvider(restrictions));
    }

    private BiFunction<CriteriaBuilder, Root<Product>, Predicate> getPredicateProvider(Map<String, String> restrictions) {
        return (cb, root) -> {
            List<Predicate> predicates = restrictions.entrySet()
                    .stream()
                    .map(entry -> createEqualPredicate(entry.getKey(), entry.getValue(), cb, root))
                    .collect(Collectors.toList());

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
