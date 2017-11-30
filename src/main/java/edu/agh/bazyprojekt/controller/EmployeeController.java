package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Employee;

public interface EmployeeController {
    void createNewEmployee(Employee employee);
    void alterEmployee(Employee employee);
    Employee removeEmployee(Employee employee);
    Employee getEmployeeById(int id);
}
