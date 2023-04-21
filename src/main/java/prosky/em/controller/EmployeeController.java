package prosky.em.controller;

import org.springframework.web.bind.annotation.*;
import prosky.em.model.Employee;
import prosky.em.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName){
        Employee employee = new Employee(firstName,lastName);
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName){
           return employeeService.remove(firstName,lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return  employeeService.find(firstName,lastName);
    }


}
