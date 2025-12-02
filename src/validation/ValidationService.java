package validation;

public class ValidationService {

    public void validateName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new ValidationException("Name cannot be empty.");

        if (!name.matches("^[A-Za-z ]+$"))
            throw new ValidationException("Name can contain only alphabets and spaces.");
    }

    public void validateDepartment(String dept) {
        if (dept == null || dept.trim().isEmpty())
            throw new ValidationException("Department cannot be empty.");
    }

    public void validateSalary(String salaryText) {
        if (!salaryText.matches("^[0-9]+(\\.[0-9]+)?$"))
            throw new ValidationException("Salary must be a valid number.");
    }

    public double parseSalary(String salaryText) {
        validateSalary(salaryText);
        return Double.parseDouble(salaryText);
    }
}
