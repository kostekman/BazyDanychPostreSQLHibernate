package edu.agh.bazyprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
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

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
