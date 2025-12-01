package utils;

import model.Employee;

import java.util.Comparator;

public class EmployeeComparators {

    public static final Comparator<Employee> SORT_BY_NAME =
            Comparator.comparing(Employee::getName);

    public static final Comparator<Employee> SORT_BY_SALARY =
            Comparator.comparingDouble(Employee::getSalary);

    public static final Comparator<Employee> SORT_BY_JOINING_DATE =
            Comparator.comparing(Employee::getJoiningDate);

    public static final Comparator<Employee> SORT_BY_DEPARTMENT =
            Comparator.comparing(Employee::getDepartment);

    public static final Comparator<Employee> SORT_BY_ROLE =
            Comparator.comparing(Employee::getRole);
}
