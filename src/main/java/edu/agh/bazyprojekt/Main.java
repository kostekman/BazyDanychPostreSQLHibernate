package edu.agh.bazyprojekt;

import edu.agh.bazyprojekt.controller.EmployeeController;
import edu.agh.bazyprojekt.controller.HibernateEmployeeController;
import edu.agh.bazyprojekt.controller.HibernateOrderController;
import edu.agh.bazyprojekt.controller.OrderController;
import edu.agh.bazyprojekt.model.Employee;
import edu.agh.bazyprojekt.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        OrderController orderController = new HibernateOrderController();
//        EmployeeController employeeController = new HibernateEmployeeController();
//
//        Employee newEmployee = new Employee();
//        newEmployee.setFirstName("Dawid");
//        newEmployee.setLastName("Krzyszycha");
//        employeeController.createNewEmployee(newEmployee);
//
//        Order order = orderController.getOrderById(3);
//        System.out.print(order);
//        Employee employee = employeeController.getEmployeeByFirstName("Nancy");
//        System.out.print(employee);
    }
}
