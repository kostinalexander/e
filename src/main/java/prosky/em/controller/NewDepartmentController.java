package prosky.em.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prosky.em.model.Employee;
import prosky.em.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
public class NewDepartmentController {


    private DepartmentService departmentService;

    public NewDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // GET http://localhost:8080/department/{id}/salary/sum — возвращает сумму зарплат по департаменту.


    @GetMapping("/department/{id}/salary/sum")
    public Integer getData(@PathVariable int id) {

        // List<Employee> list; // 20

        return departmentService.countSalaries(id);
    }
    @GetMapping("/department/{id}/salary/max")
    public Employee findByDepartmentMaxSalary(@PathVariable int id){
        return departmentService.findByDepartmentMaxSalary(id);
    }



    @GetMapping("/department/{id}/salary/min") ////
    public Employee findByDepartmentMinSalary(@PathVariable int id){
        return departmentService.findByDepartmentMinSalary(id);
    }


    @GetMapping("/department/{id}/employees")
    public List<Employee> findByDepartmentAll(@PathVariable int id){
        return departmentService.findByDepartmentAll(id);
    }

    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> allDepartments(){
        return departmentService.allDepartments();
    }
}
