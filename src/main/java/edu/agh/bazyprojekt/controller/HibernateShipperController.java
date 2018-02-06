package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Shipper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class HibernateShipperController extends HibernateController implements ShipperController {

    @Override
    public void createNewShipper(Shipper product) {

    }

    @Override
    public Shipper mapJSONToShipper(Map<String, String> json) {
        return null;
    }

    @Override
    public void updateShipper(Shipper product) {

    }

    @Override
    public Shipper removeShipper(Shipper product) {
        return null;
    }

    @Override
    public List<Shipper> getShipper(Map<String, String> restrictions) {
        return findObjects(Shipper.class, getPredicateProvider(restrictions));
    }

    private BiFunction<CriteriaBuilder, Root<Shipper>, Predicate> getPredicateProvider(Map<String, String> restrictions) {
        return (cb, root) -> {
            List<Predicate> predicates = restrictions.entrySet()
                    .stream()
                    .map(entry -> createEqualPredicate(entry.getKey(), entry.getValue(), cb, root))
                    .collect(Collectors.toList());

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
