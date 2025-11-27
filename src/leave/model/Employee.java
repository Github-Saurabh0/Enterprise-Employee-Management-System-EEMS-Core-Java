
package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String email;
    private String department;
    private String role;
    private double salary;
    private LocalDate joiningDate;

    public Employee(int id, String name, String email, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.joiningDate = LocalDate.now();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
    public java.time.LocalDate getJoiningDate() { return joiningDate; }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + department + "," + role + "," + salary + "," + joiningDate;
    }
}
