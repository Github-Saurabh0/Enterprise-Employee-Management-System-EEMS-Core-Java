package utils;

import dao.FileEmployeeDaoImpl;
import dao.SerializedEmployeeDaoImpl;
import model.Employee;

import java.util.List;

public class MigrationUtility {

    public static void migrateCsvToSerialized(String csvFile, String serFile) {
        FileEmployeeDaoImpl csvDao = new FileEmployeeDaoImpl(csvFile);
        SerializedEmployeeDaoImpl serDao = new SerializedEmployeeDaoImpl(serFile);

        List<Employee> employees = csvDao.findAll();

        for (Employee e : employees) {
            serDao.save(e);
        }

        System.out.println("Migration Completed: " + employees.size() + " employees moved.");
    }
}
