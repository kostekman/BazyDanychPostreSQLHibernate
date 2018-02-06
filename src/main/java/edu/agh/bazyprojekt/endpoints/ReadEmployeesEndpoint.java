package edu.agh.bazyprojekt.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.agh.bazyprojekt.controller.EmployeeController;
import edu.agh.bazyprojekt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees/readEmployees")
public class ReadEmployeesEndpoint {

    @Autowired
    EmployeeController employeeController;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Employee> read(@RequestBody Map<String ,String> query) throws OperationNotSupportedException, JsonProcessingException {
        return employeeController.getEmployee(query);
    }
}
