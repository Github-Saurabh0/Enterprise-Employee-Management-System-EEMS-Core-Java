package payroll.model;

public abstract class Payroll {

    protected int employeeId;

    public Payroll(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public abstract double calculateSalary();
}
