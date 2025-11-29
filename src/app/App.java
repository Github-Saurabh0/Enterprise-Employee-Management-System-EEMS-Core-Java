package app;

import dao.FileEmployeeDaoImpl;
import model.Employee;
import reporting.ReportingService;
import reporting.ReportScheduler;
import service.EmployeeService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService(
                new FileEmployeeDaoImpl("data/employees.csv")
        );

        ReportingService reportingService = new ReportingService();
        ReportScheduler scheduler = new ReportScheduler(reportingService, service);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Enterprise Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Export Employee Report");
            System.out.println("4. Schedule Auto CSV Report");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(sc.nextLine());

                    Employee emp = new Employee(0, name, dept, salary);
                    service.addEmployee(emp);
                    System.out.println("Employee added successfully.");
                }

                case 2 -> {
                    List<Employee> list = service.getAllEmployees();
                    list.forEach(System.out::println);
                }

                case 3 -> {
                    File output = new File("data/employee_report.csv");
                    reportingService.exportEmployeeReport(service.getAllEmployees(), output);
                    System.out.println("Report generated: " + output.getAbsolutePath());
                }

                case 4 -> {
                    System.out.println("Auto CSV generation started (every 10s)...");
                    scheduler.scheduleReportGeneration();
                }

                case 5 -> {
                    scheduler.stopScheduler();
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
