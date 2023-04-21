package prosky.em.service;

import org.springframework.stereotype.Service;
import prosky.em.exeption.EmployeeAlreadyAddedException;
import prosky.em.exeption.EmployeeNotFoundException;
import prosky.em.exeption.EmployeeStorageIsFullException;
import prosky.em.model.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private int counter=1;
private final Map<Long,Employee> employeeMap  = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName) { // СОЗДАЛИ ОБЪЕКТ, НУЖНО СОЗДАТЬ ОБЪЕКТ ИЗ ИМЕНИ И ФАМИЛИИ, МЫ СОЗДАЛИ ОБЪЕКТ И ЗАПОЛНИИЛ ЕГО
        Employee employee = new Employee(firstName,lastName);
        if (employee.getId()!=null){
            throw new EmployeeAlreadyAddedException();
        }
        employee.setId(counter++); // присвоили айди, следующий объект получит айди + 1
        return employeeMap.put(employee.getId(),employee); // put метод map, чтобы добавить
    }

    @Override
    public Employee remove(String firstName, String lastName) {
       Employee employee =  new Employee(firstName,lastName);
        if(!employeeMap.containsKey(employee.getId())){
            throw new EmployeeNotFoundException();
        } // если существует такой объект, под индефикатором id ТО удали его
        return employeeMap.remove(employee);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee =  new Employee(firstName,lastName);
        if(!employeeMap.containsKey(employee.getId())){ //если ключа нет то исключение
            throw new EmployeeStorageIsFullException();
        }
        return employeeMap.get(employee.getId());// если ключ есть то верни объект с айди таким=то(верни объект с данным ключом)
    }

}
