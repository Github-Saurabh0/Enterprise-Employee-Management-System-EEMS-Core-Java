package app;

import dao.FileEmployeeDaoImpl;
import model.Employee;
import reporting.ReportingService;
import reporting.ReportScheduler;
import service.EmployeeService;
import service.SearchService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService(
                new FileEmployeeDaoImpl("data/employees.csv")
        );

        SearchService searchService = new SearchService();

        ReportingService reportingService = new ReportingService();
        ReportScheduler scheduler = new ReportScheduler(reportingService, service);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== Enterprise Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Export Employee Report");
            System.out.println("4. Schedule Auto CSV Report");
            System.out.println("5. Search Employees");
            System.out.println("6. Sort Employees");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice;
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

                    // Auto-id and default joining date handled by Employee constructor
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
                    System.out.println("Search By: 1.Name  2.Department  3.Salary Range  4.Joining Year");
                    int s = Integer.parseInt(sc.nextLine());

                    List<Employee> result = null;

                    switch (s) {
                        case 1 -> {
                            System.out.print("Enter name keyword: ");
                            result = searchService.searchByName(service.getAllEmployees(), sc.nextLine());
                        }
                        case 2 -> {
                            System.out.print("Enter department: ");
                            result = searchService.searchByDepartment(service.getAllEmployees(), sc.nextLine());
                        }
                        case 3 -> {
                            System.out.print("Min salary: ");
                            double min = Double.parseDouble(sc.nextLine());
                            System.out.print("Max salary: ");
                            double max = Double.parseDouble(sc.nextLine());
                            result = searchService.searchBySalaryRange(service.getAllEmployees(), min, max);
                        }
                        case 4 -> {
                            System.out.print("Enter year: ");
                            int y = Integer.parseInt(sc.nextLine());
                            result = searchService.searchByJoiningYear(service.getAllEmployees(), y);
                        }
                        default -> System.out.println("Invalid.");
                    }

                    if (result != null) result.forEach(System.out::println);
                }

                case 6 -> {
                    System.out.println("Sort By: 1.Name  2.Salary  3.Department  4.Joining Date");
                    int s = Integer.parseInt(sc.nextLine());

                    List<Employee> sorted = switch (s) {
                        case 1 -> service.sortByName();
                        case 2 -> service.sortBySalary();
                        case 3 -> service.sortByDepartment();
                        case 4 -> service.sortByJoiningDate();
                        default -> null;
                    };

                    if (sorted != null) sorted.forEach(System.out::println);
                }

                case 7 -> {
                    scheduler.stopScheduler();
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
