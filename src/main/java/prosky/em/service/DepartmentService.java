package prosky.em.service;

import prosky.em.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findByDepartmentMaxSalary(int department);
    Employee findByDepartmentMinSalary(int department);
    List<Employee> findByDepartmentAll(int department);

    Map<Integer, List<Employee>> allDepartments();
}
