package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeController {
    void createNewEmployee(Employee employee);
    void alterEmployee(Employee employee);
    Employee removeEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getEmployeeByFirstName(Map<String,String> restrictions);
}
