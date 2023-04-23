package prosky.em.service;

import org.springframework.stereotype.Service;
import prosky.em.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    @Override
    public Employee findByDepartmentMaxSalary(int department) {

        return employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(IllegalArgumentException::new); // в противном случае ничего
    }

    @Override
    public Employee findByDepartmentMinSalary(int department) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(IllegalArgumentException::new); // в противном случае ничего
    }

    @Override
    public List<Employee> findByDepartmentAll(int department) {
        return employeeMap.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allDepartments() {
      return   employeeMap.values().stream()
              .collect(Collectors.groupingBy(Employee::getDepartment));
    }

//    @Override
//    public List<Employee> findByDepartmentAll(int department) {
//        List<Employee> employees = new ArrayList<>();
//        for (Employee e : employeeMap.values()) {
//            if (e.getDepartment() == department) {
//                employees.add(e);
//
//            }
//        }
//        return employees;
//    }

}
