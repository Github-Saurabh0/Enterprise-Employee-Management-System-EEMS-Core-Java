package service;

import dao.EmployeeDao;
import model.Employee;
import utils.EmployeeComparators;

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
        return dao.getAll();
    }

    // NEW: Sorting utilities
    public List<Employee> sortByName() {
        List<Employee> list = dao.getAll();
        list.sort(EmployeeComparators.SORT_BY_NAME);
        return list;
    }

    public List<Employee> sortBySalary() {
        List<Employee> list = dao.getAll();
        list.sort(EmployeeComparators.SORT_BY_SALARY);
        return list;
    }

    public List<Employee> sortByJoiningDate() {
        List<Employee> list = dao.getAll();
        list.sort(EmployeeComparators.SORT_BY_JOINING_DATE);
        return list;
    }

    public List<Employee> sortByDepartment() {
        List<Employee> list = dao.getAll();
        list.sort(EmployeeComparators.SORT_BY_DEPARTMENT);
        return list;
    }

    public List<Employee> sortByRole() {
        List<Employee> list = dao.getAll();
        list.sort(EmployeeComparators.SORT_BY_ROLE);
        return list;
    }
}
