package reporting;

import model.Employee;
import payroll.PayrollRecord;
import utils.CSVExporter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportingService {

    private final CSVExporter exporter = new CSVExporter();

    public File exportEmployeeReport(List<Employee> employees, File file) {

        List<String> rows = new ArrayList<>();
        rows.add("ID,Name,Department,Salary");

        for (Employee e : employees) {
            rows.add(e.getId() + "," +
                    e.getName() + "," +
                    e.getDepartment() + "," +
                    e.getSalary());
        }

        exporter.writeToCSV(rows, file);
        return file;
    }

    public File exportPayrollReport(List<PayrollRecord> records, File file) {

        List<String> rows = new ArrayList<>();
        rows.add("EmpID,Name,Type,BaseSalary,Bonus,NetSalary");

        for (PayrollRecord p : records) {
            rows.add(p.getEmployeeId() + "," +
                    p.getEmployeeName() + "," +
                    p.getType() + "," +
                    p.getBaseSalary() + "," +
                    p.getBonus() + "," +
                    p.getNetSalary());
        }

        exporter.writeToCSV(rows, file);
        return file;
    }
}
