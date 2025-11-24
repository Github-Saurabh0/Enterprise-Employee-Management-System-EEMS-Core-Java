
package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDao dao;

    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public boolean addEmployee(Employee e) {
        // business validations can go here
        return dao.save(e);
    }

    public List<Employee> listAll() {
        return dao.findAll();
    }
}
