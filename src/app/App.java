package app;

import dao.FileEmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService(new FileEmployeeDaoImpl("data/employees.csv"));
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. List Employees");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // fix scanner line break

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(0, name, dept, salary);
                    service.addEmployee(emp);
                }

                case 2 -> {
                    List<Employee> list = service.getAllEmployees();
                    System.out.println("\n--- Employee List ---");
                    for (Employee e : list) {
                        System.out.println(e);
                    }
                }

                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
