package reporting;

import model.Employee;
import service.EmployeeService;

import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ReportScheduler {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ReportingService reportingService;
    private final EmployeeService employeeService;

    public ReportScheduler(ReportingService reportingService, EmployeeService employeeService) {
        this.reportingService = reportingService;
        this.employeeService = employeeService;
    }

    public void scheduleReportGeneration() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                List<Employee> employees = employeeService.getAllEmployees();
                File file = new File("data/employee_report_auto.csv");
                reportingService.exportEmployeeReport(employees, file);
                System.out.println("[AUTO] Report refreshed: " + file.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("[AUTO] Failed: " + e.getMessage());
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }
}
