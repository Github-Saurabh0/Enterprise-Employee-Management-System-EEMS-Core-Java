
# Low Level Design (LLD) – Enterprise Employee Management System

## 1. Model Classes
Employee  
Leave  
Payroll (Base Class)  
FullTimePayroll / PartTimePayroll  

## 2. DAO Classes
EmployeeDao  
FileEmployeeDaoImpl  
SerializedEmployeeDaoImpl  
LeaveDao  

## 3. Services
EmployeeService  
LeaveService  
PayrollService  
SearchService  

## 4. Utils
CSVExporter  
LoggerUtil  
EmployeeComparators  
ValidationService  

## 5. Scheduler
ReportScheduler  
