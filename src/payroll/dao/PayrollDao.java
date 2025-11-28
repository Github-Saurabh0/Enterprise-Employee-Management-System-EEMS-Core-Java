package payroll.dao;

import payroll.model.Payroll;
import java.util.List;

public interface PayrollDao {

    void save(Payroll payroll);

    List<Payroll> findAll();

    Payroll findByEmployeeId(int employeeId);
}
