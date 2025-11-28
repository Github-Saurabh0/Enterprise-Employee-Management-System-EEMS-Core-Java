package payroll.model;

public class PartTimePayroll extends Payroll {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimePayroll(int employeeId, int hoursWorked, double hourlyRate) {
        super(employeeId);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate; // future: night shift bonus, overtime
    }
}
