package dao;

import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializedEmployeeDaoImpl implements EmployeeDao {

    private final String filePath;

    public SerializedEmployeeDaoImpl(String filePath) {
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
        List<Employee> all = findAll();
        all.add(e);
        return write(all);
    }

    @Override
    public List<Employee> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Employee>) ois.readObject();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Employee findById(int id) {
        return findAll().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean update(Employee e) {
        List<Employee> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == e.getId()) {
                all.set(i, e);
                return write(all);
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Employee> all = findAll();
        all.removeIf(e -> e.getId() == id);
        return write(all);
    }

    private boolean write(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
