package edu.agh.bazyprojekt.controller;

import edu.agh.bazyprojekt.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface EmployeeController {
    void createNewEmployee(Employee employee);
    void alterEmployee(Employee employee);
    Employee removeEmployee(Employee employee);
    List<Employee> getEmployee(Map<String,String> restrictions);
}
