package payroll.service;

import payroll.dao.PayrollDao;
import payroll.model.Payroll;

public class PayrollService {

    private final PayrollDao dao;

    public PayrollService(PayrollDao dao) {
        this.dao = dao;
    }

    public void processPayroll(Payroll payroll) {
        double salary = payroll.calculateSalary();
        System.out.println("Generated Salary: " + salary);
        dao.save(payroll);
    }
}
