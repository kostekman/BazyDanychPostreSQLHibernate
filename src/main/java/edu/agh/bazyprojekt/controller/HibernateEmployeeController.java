package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        return (Employee)removeObjectFromDb(employee);
    }

    @Override
    public Employee getEmployeeById(int id){
        Session session = sessionFactory.openSession();

        Query<Employee> query = session.createQuery("FROM Employee e where e.id = :id");
        query.setParameter("id", (short)id);
        Employee employee = query.stream().findFirst().orElse(null);
        session.close();
        return employee;
    }
}
