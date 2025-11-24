
package app;

import service.EmployeeService;
import model.Employee;
import dao.FileEmployeeDaoImpl;
import dao.EmployeeDao;
import utils.LoggerUtil;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LoggerUtil.init();
        EmployeeDao dao = new FileEmployeeDaoImpl("data/employees.csv");
        EmployeeService service = new EmployeeService(dao);

        Scanner sc = new Scanner(System.in);
        System.out.println("=== EEMS (Core Java) - Starter App ===");
        System.out.println("1. Add sample employee, 2. List employees, 0. Exit");
        int c = sc.nextInt(); sc.nextLine();
        if (c == 1) {
            Employee e = new Employee(1, "Saurabh Kushwaha", "saurabh@example.com", "Engineering", "Developer", 45000.0);
            service.addEmployee(e);
            System.out.println("Sample employee added.");
        } else if (c == 2) {
            service.listAll().forEach(System.out::println);
        }
        System.out.println("Exiting.");
    }
}
