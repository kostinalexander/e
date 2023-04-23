package prosky.em.service;

import org.springframework.stereotype.Service;
import prosky.em.exeption.EmployeeAlreadyAddedException;
import prosky.em.exeption.EmployeeNotFoundException;
import prosky.em.exeption.EmployeeStorageIsFullException;
import prosky.em.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private int counter=1;

private final Map<Integer,Employee> employeeMap  = new HashMap<>();
    public EmployeeServiceImpl(){
        add(new Employee(0 ,"Александр", "Костин", 39999, 2));
        add(new Employee(0 ,"Кост", "Билд", 36599, 2));
        add(new Employee(0 ,"Егор", "Болд", 34999, 4));
        add(new Employee(0 ,"Василич", "Остин", 39999, 2));
        add(new Employee(0 ,"Роман", "Косин", 375799, 3));
        add(new Employee(0 ,"Денис", "Кос", 32219, 3));


    }

    @Override
    public Employee add(Employee employee) { // СОЗДАЛИ ОБЪЕКТ, НУЖНО СОЗДАТЬ ОБЪЕКТ ИЗ ИМЕНИ И ФАМИЛИИ, МЫ СОЗДАЛИ ОБЪЕКТ И ЗАПОЛНИИЛ ЕГО
        boolean isAd = employeeMap.values().stream()
                .anyMatch(e -> e.getFirstName().equals(employee.getFirstName())&& e.getLastName().equals(employee.getLastName()));

        if(isAd){
            throw new EmployeeAlreadyAddedException();
        }
        employee.setId(counter++);
        // присвоили айди, следующий объект получит айди + 1
        employee.setDepartment(employee.getDepartment());
        employee.setSalary(employee.getSalary());
         employeeMap.put(employee.getId(),employee);// put метод map, чтобы добавить
         return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
       for(Employee tmp : employeeMap.values()){
           if(tmp.getFirstName().equals(firstName)&& tmp.getLastName().equals(lastName)){
                  return employeeMap.remove(tmp.getId());
           }
       }throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        for (Employee tmp : employeeMap.values()) {
            if(tmp.getFirstName().equals(firstName)&& tmp.getLastName().equals(lastName)){
                return tmp;
            }
        }
        throw new EmployeeStorageIsFullException();
    }
    @Override
    public Collection<Employee> findAll() {

        return Collections.unmodifiableCollection(employeeMap.values());
    }



//    @Override
//    public Employee findByDepartmentMaxSalary(int department) {
//        double max = Double.MAX_VALUE;
//        var sortByMaxSalary = Comparator.comparing(Employee::getSalary);
//        Employee employeeMaxSalary = null;
//        for (Employee employee : employeeMap.values()) {
//            if(employee.getDepartment()== department && employee.getSalary()>max){
//                max = employee.getSalary();
//                employeeMaxSalary = employee;
//            }
//        }
//        return employeeMaxSalary;
//    }



}
