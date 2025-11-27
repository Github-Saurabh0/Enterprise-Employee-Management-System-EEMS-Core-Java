
package dao;

import model.Employee;
import java.util.List;

public interface EmployeeDao {
    boolean save(Employee e);
    List<Employee> findAll();
    Employee findById(int id);
    boolean update(Employee e);
    boolean delete(int id);
}
