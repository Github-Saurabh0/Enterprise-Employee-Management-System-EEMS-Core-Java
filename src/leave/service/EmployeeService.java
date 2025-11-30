package service;

import dao.EmployeeDao;
import model.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao dao;

    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public void addEmployee(Employee e) {
        dao.save(e);
    }

    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    public Employee getEmployeeById(int id) {
        return dao.findById(id);
    }

    public boolean updateEmployee(Employee e) {
        return dao.update(e);
    }

    public boolean deleteEmployee(int id) {
        return dao.delete(id);
    }
}
