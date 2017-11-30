package edu.agh.bazyprojekt;

import edu.agh.bazyprojekt.controller.EmployeeController;
import edu.agh.bazyprojekt.controller.HibernateEmployeeController;
import edu.agh.bazyprojekt.controller.HibernateOrderController;
import edu.agh.bazyprojekt.controller.OrderController;

public class Main {

    public static void main(String[] args) {
        OrderController orderController = new HibernateOrderController();

        EmployeeController employeeController = new HibernateEmployeeController();
    }
}
