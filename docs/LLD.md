
# Low Level Design (LLD) - EEMS (skeleton)

Key Classes (examples)
- model.Employee {id, name, email, department, role, salary, joiningDate}
- dao.FileEmployeeDaoImpl implements EmployeeDao { uses CSV file 'data/employees.csv' }
- service.EmployeeService { business rules for add/update/delete/search }
- payroll.PayrollEngine { calculatePayslip(Employee) }
