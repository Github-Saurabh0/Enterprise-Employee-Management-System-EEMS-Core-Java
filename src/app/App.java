package app;

import dao.FileEmployeeDaoImpl;
import model.Employee;
import reporting.ReportingService;
import reporting.ReportScheduler;
import service.EmployeeService;
import service.SearchService;
import validation.ValidationException;
import validation.ValidationService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService(
                new FileEmployeeDaoImpl("data/employees.csv")
        );

        SearchService searchService = new SearchService();
        ValidationService validator = new ValidationService();
        ReportingService reportingService = new ReportingService();
        ReportScheduler scheduler = new ReportScheduler(reportingService, service);

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n=== Enterprise Employee Management System ===");
                System.out.println("1. Add Employee");
                System.out.println("2. List Employees");
                System.out.println("3. Export Employee Report");
                System.out.println("4. Schedule Auto CSV Report");
                System.out.println("5. Search Employees");
                System.out.println("6. Sort Employees");
                System.out.println("7. Exit");
                System.out.print("Choose: ");

                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {

                    case 1 -> {
                        try {
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine().trim();
                            validator.validateName(name);

                            System.out.print("Enter Department: ");
                            String dept = sc.nextLine().trim();
                            validator.validateDepartment(dept);

                            System.out.print("Enter Salary: ");
                            String salaryText = sc.nextLine().trim();
                            double salary = validator.parseSalary(salaryText);

                            Employee emp = new Employee(0, name, dept, salary);
                            service.addEmployee(emp);
                            System.out.println("Employee added successfully.");

                        } catch (ValidationException ve) {
                            System.out.println("❌ Error: " + ve.getMessage());
                        }
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
                        int s = Integer.parseInt(sc.nextLine().trim());
                        List<Employee> result = null;

                        try {
                            switch (s) {
                                case 1 -> {
                                    System.out.print("Enter keyword: ");
                                    result = searchService.searchByName(service.getAllEmployees(), sc.nextLine().trim());
                                }
                                case 2 -> {
                                    System.out.print("Enter department: ");
                                    result = searchService.searchByDepartment(service.getAllEmployees(), sc.nextLine().trim());
                                }
                                case 3 -> {
                                    System.out.print("Min salary: ");
                                    double min = validator.parseSalary(sc.nextLine().trim());

                                    System.out.print("Max salary: ");
                                    double max = validator.parseSalary(sc.nextLine().trim());

                                    result = searchService.searchBySalaryRange(service.getAllEmployees(), min, max);
                                }
                                case 4 -> {
                                    System.out.print("Enter year: ");
                                    int y = Integer.parseInt(sc.nextLine().trim());
                                    result = searchService.searchByJoiningYear(service.getAllEmployees(), y);
                                }
                                default -> System.out.println("Invalid.");
                            }
                        } catch (ValidationException ve) {
                            System.out.println("❌ " + ve.getMessage());
                        }

                        if (result != null) result.forEach(System.out::println);
                    }

                    case 6 -> {
                        System.out.println("Sort By: 1.Name  2.Salary  3.Department  4.Joining Date");
                        int s = Integer.parseInt(sc.nextLine().trim());

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

            } catch (NumberFormatException nfe) {
                System.out.println("❌ Invalid number! Try again.");
            } catch (Exception e) {
                System.out.println("❌ Unexpected error: " + e.getMessage());
            }
        }
    }
}
