package prosky.em.service;

import prosky.em.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(Employee employee);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName,String lastName);
    Collection<Employee> findAll();




}
