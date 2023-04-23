package prosky.em.controller;

import org.springframework.web.bind.annotation.*;
import prosky.em.model.Employee;
import prosky.em.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam Employee employee){
        return employeeService.add(employee);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName){
           return employeeService.remove(firstName,lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return  employeeService.find(firstName,lastName);
    }
      @GetMapping
public Collection<Employee>findAll(){
        return employeeService.findAll();
      }



}
