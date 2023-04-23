package prosky.em.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prosky.em.model.Employee;
import prosky.em.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findByDepartmentMaxSalary(@RequestParam int department){
        return departmentService.findByDepartmentMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee findByDepartmentMinSalary(@RequestParam int department){
        return departmentService.findByDepartmentMinSalary(department);
    }

    @GetMapping("/all")
    public List<Employee> findByDepartmentAll(@RequestParam int department){
        return departmentService.findByDepartmentAll(department);
    }

    @GetMapping("/alll")
    public Map<Integer, List<Employee>> allDepartments(){
        return departmentService.allDepartments();
    }
}
