package tests;

import dao.FileEmployeeDaoImpl;
import model.Employee;
import org.junit.Test;
import service.EmployeeService;
import validation.ValidationException;

import static org.junit.Assert.*;

public class EmployeeServiceTest {

    @Test
    public void testAddEmployeeSuccess() {
        EmployeeService service = new EmployeeService(
                new FileEmployeeDaoImpl("test/employees_test.csv")
        );

        Employee emp = new Employee(1, "Saurabh", "IT", 45000);

        service.addEmployee(emp);

        assertEquals(1, service.getAllEmployees().size());
    }

    @Test(expected = ValidationException.class)
    public void testAddEmployeeInvalidName() {
        EmployeeService service = new EmployeeService(
                new FileEmployeeDaoImpl("test/test_error.csv")
        );

        Employee emp = new Employee(1, "123Invalid", "IT", 45000);
        service.addEmployee(emp);
    }

    @Test(expected = ValidationException.class)
    public void testAddEmployeeInvalidSalary() {
        EmployeeService service = new EmployeeService(
                new FileEmployeeDaoImpl("test/test_error.csv")
        );

        Employee emp = new Employee(1, "Saurabh", "IT", -10);
        service.addEmployee(emp);
    }
}
