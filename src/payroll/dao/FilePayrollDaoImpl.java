package payroll.dao;

import payroll.model.Payroll;

import java.util.List;

public class FilePayrollDaoImpl implements PayrollDao {

    private final String filePath;

    public FilePayrollDaoImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Payroll payroll) {
        // TODO: Write payroll data to CSV
    }

    @Override
    public List<Payroll> findAll() {
        // TODO: Read CSV and return objects
        return List.of();
    }

    @Override
    public Payroll findByEmployeeId(int employeeId) {
        // TODO: Search by employee ID
        return null;
    }
}
