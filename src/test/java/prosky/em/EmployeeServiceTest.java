package prosky.em;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import prosky.em.exeption.EmployeeNotFoundException;
import prosky.em.exeption.EmployeeStorageIsFullException;
import prosky.em.exeption.InvalidInputExeption;
import prosky.em.model.Employee;
import prosky.em.service.DepartmentServiceImpl;
import prosky.em.service.EmployeeService;
import prosky.em.service.EmployeeServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

public class EmployeeServiceTest {


    static  Map<Integer, Employee> employeeMap = new HashMap<>();

   @BeforeAll
   public static void setUp() {
       employeeMap.put(1, new Employee(1, "Александр", "Костин", 39999, 2));
       employeeMap.put(2, new Employee(2, "Кост", "Билд", 36599, 2));
    }

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void testFindEmployeeByFirstNameAndLastName_positive() {
        Employee employee = employeeService.find("Александр", "Костин");
        Assertions.assertEquals(employeeMap.get(1), employee);
    }
    @Test
    public void testFindEmployeeByFirstNameAndLastName2_positive() {
        Employee employee = employeeService.find("Кост", "Билд");
        Assertions.assertEquals(employeeMap.get(2), employee);
    }
    @Test
    public void testFindEmployeeByFirstNameAndLastName_negative(){
        Assertions.assertThrows(EmployeeStorageIsFullException.class,()->employeeService.find("klgk","ладв"));
    }


    @Test
    public void testRemoveEmployee_positive(){
        Employee employee = employeeService.remove("Кост", "Билд");
        Assertions.assertEquals(employeeMap.get(2),employee);
    }

    @Test
    public void testRemoveEmployee_negative(){
        Assertions.assertThrows(EmployeeNotFoundException.class,()->employeeService.remove("аваулуд","плдкпалд"));
    }
    @Test
    public void testAddEmployee(){
        Employee new_employee = new Employee(3,"Denis", "Krykow",32922,4);
        Employee employee =  employeeService.add(new_employee);
        System.out.println(employeeMap);
           Assertions.assertEquals(employeeMap.get(3),employee);
    }





}

