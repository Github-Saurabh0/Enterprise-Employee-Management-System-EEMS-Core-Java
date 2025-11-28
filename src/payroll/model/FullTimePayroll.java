package payroll.model;

public class FullTimePayroll extends Payroll {

    private double monthlySalary;

    public FullTimePayroll(int employeeId, double monthlySalary) {
        super(employeeId);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary; // future: add PF, BONUS, TAX logic
    }
}
