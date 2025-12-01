package service;

import model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<Employee> searchByName(List<Employee> list, String name) {
        return list.stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Employee> searchByDepartment(List<Employee> list, String dept) {
        return list.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                .collect(Collectors.toList());
    }

    public List<Employee> searchBySalaryRange(List<Employee> list, double min, double max) {
        return list.stream()
                .filter(e -> e.getSalary() >= min && e.getSalary() <= max)
                .collect(Collectors.toList());
    }

    public List<Employee> searchByJoiningYear(List<Employee> list, int year) {
        return list.stream()
                .filter(e -> e.getJoiningDate().getYear() == year)
                .collect(Collectors.toList());
    }
}
