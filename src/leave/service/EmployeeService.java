package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
        System.out.println("Employee added successfully!");
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
}
