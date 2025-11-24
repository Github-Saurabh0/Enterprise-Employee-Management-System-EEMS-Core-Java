
package dao;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileEmployeeDaoImpl implements EmployeeDao {
    private final String filePath;

    public FileEmployeeDaoImpl(String filePath) {
        this.filePath = filePath;
        File f = new File(filePath);
        try {
            f.getParentFile().mkdirs();
            if (!f.exists()) f.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean save(Employee e) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(e.toString());
            bw.newLine();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> out = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",", 7);
                int id = Integer.parseInt(parts[0]);
                double salary = Double.parseDouble(parts[5]);
                // naive parsing — keeps sample simple
                out.add(new Employee(id, parts[1], parts[2], parts[3], parts[4], salary));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return out;
    }

    @Override
    public Employee findById(int id) {
        return findAll().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean update(Employee e) {
        List<Employee> all = findAll();
        boolean found = false;
        for (int i=0;i<all.size();i++) {
            if (all.get(i).getId() == e.getId()) {
                all.set(i, e);
                found = true;
                break;
            }
        }
        if (!found) return false;
        try (FileWriter fw = new FileWriter(filePath,false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Employee emp: all) {
                bw.write(emp.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        List<Employee> all = findAll().stream().filter(e -> e.getId() != id).collect(Collectors.toList());
        try (FileWriter fw = new FileWriter(filePath,false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Employee emp: all) {
                bw.write(emp.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
