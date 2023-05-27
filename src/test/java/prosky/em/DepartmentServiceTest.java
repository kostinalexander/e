package prosky.em;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import prosky.em.model.Employee;
import prosky.em.service.DepartmentServiceImpl;
import prosky.em.service.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest {



    private final EmployeeServiceImpl employeeService = mock(EmployeeServiceImpl.class); // mock == fake

    private final DepartmentServiceImpl departmentService = new DepartmentServiceImpl(employeeService);

    static final Map<Integer, Employee> employeeMap = new HashMap<>();

    @BeforeAll
    public static void setUp() {
        employeeMap.put(1, new Employee(1, "Александр", "Костин", 39999, 2));
        employeeMap.put(2, new Employee(2, "Кост", "Билд", 36599, 2));
        employeeMap.put(3, new Employee(3, "asdad", "sdfdfgdg", 222, 1));
    }


    @Test
    public void testFindByDepartmentAll_positive() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        List<Employee> resultList = departmentService.findByDepartmentAll(2);
        assertEquals(2, resultList.size());
        assertEquals("Александр", resultList.get(0).getFirstName());
        assertEquals("Костин", resultList.get(0).getLastName());
        assertEquals(39999, resultList.get(0).getSalary());
    }

    @Test
    public void testFindByDepartmentAll_negative() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        List<Employee> resultList = departmentService.findByDepartmentAll(33);

        assertEquals(0, resultList.size());
    }


    @Test
    public void testFindByDepartmentMaxSalary_positive() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        Employee employee = departmentService.findByDepartmentMaxSalary(2);
        System.out.println(employee);
        assertEquals(39999, employee.getSalary());
    }


    @Test
    public void testFindByDepartmentMaxSalary_negative() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        Employee employee = departmentService.findByDepartmentMaxSalary(9);
        assertNull(employee);
    }


    @Test
    public void testFindByDepartmentMinSalary_positive() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        Employee employee = departmentService.findByDepartmentMinSalary(2);
        System.out.println(employee);
        assertEquals(36599, employee.getSalary());
    }


    @Test
    public void testFindByDepartmentMinSalary_negative() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        Employee employee = departmentService.findByDepartmentMinSalary(9);
        assertNull(employee);
    }


    @Test
    public void testCountSalaries_positive() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        Integer sumOfSalaries = departmentService.countSalaries(2);
        assertEquals(76598, sumOfSalaries);
    }



    @Test
    public void testCountSalaries_negative() {

        List<Employee> employees = Arrays.asList(
                employeeMap.get(1),
                employeeMap.get(2)
        );

        when(employeeService.findAllByDepartment(2)).thenReturn(employees);
        Integer sumOfSalaries = departmentService.countSalaries(33);
        assertEquals(0, sumOfSalaries);
    }

}

// positive / negative

