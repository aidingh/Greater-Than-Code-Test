package com.example.greaterthancodetest.controllers;
import com.example.greaterthancodetest.models.Employee;
import com.example.greaterthancodetest.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Aidin Ghassemloi.
 * EmployeeController class is responsible mapping requests made by the client.
 * Any repository can be instancited in this class if needed.
 * Employee class instanciates a EmployeeService to make an API-call.
 *
 *
 */
@Controller
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService(new RestTemplate());

    /**
     * Function will map the clients request.
     * Function is will display all employees in a table format.
     *
     * @param model Model object will map attributes defined in the HTML-file to attributes defined in model.addAttribute().
     * @return "employee_home": employee_home.html is a reference to the HTML file to be displayed.
     */
    @GetMapping(value = "/employees")
    public String home(Model model) {

        List<Employee> list = employeeService.getEmployees();
        model.addAttribute("list", list);
        return "employee_home";
    }
}
