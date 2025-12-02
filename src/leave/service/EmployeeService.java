package service;

import dao.EmployeeDao;
import model.Employee;
import validation.ValidationException;
import validation.ValidationService;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao dao;
    private final ValidationService validator = new ValidationService();

    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public void addEmployee(Employee e) {
        if (e == null) throw new ValidationException("Employee cannot be null.");

        validator.validateName(e.getName());
        validator.validateDepartment(e.getDepartment());

        if (e.getSalary() <= 0)
            throw new ValidationException("Salary must be greater than 0.");

        dao.save(e);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAll();
    }
}
