package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Component
public class HibernateEmployeeController extends HibernateController implements EmployeeController {
    @Override
    public void createNewEmployee(Employee employee) {
        saveObjectToDb(employee);
    }

    @Override
    public void alterEmployee(Employee employee) {
        createNewEmployee(employee);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        return (Employee) removeObjectFromDb(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.openSession();

        Query<Employee> query = session.createQuery("FROM Employee e where e.id = :id");
        query.setParameter("id", (short) id);
        Employee employee = query.stream().findFirst().orElse(null);
        session.close();
        return employee;
    }

    @Override
    public List<Employee> getEmployeeByFirstName(Map<String, String> restrictions) {
        return findObjects(Employee.class, getPredicateProvider(restrictions));
    }

    private BiFunction<CriteriaBuilder, Root<Employee>, Predicate> getPredicateProvider(Map<String, String> restrictions) {
        return (cb, root) -> {
                    List<Predicate> predicates = restrictions.entrySet()
                            .stream()
                            .map(entry -> createEqualPredicate(entry.getKey(), entry.getValue(), cb, root))
                            .collect(Collectors.toList());

                    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
                };
    }

    }
