package prosky.em.service;

import prosky.em.model.Employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName,String lastName);

}
