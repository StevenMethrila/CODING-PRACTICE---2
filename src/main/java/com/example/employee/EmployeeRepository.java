// Write your code here
package com.example.employee;

import com.example.employee.Employee;
import java.util.ArrayList;

public interface EmployeeRepository {

    public ArrayList<Employee> getAll();

    public Employee getById(int empId);

    public Employee AddNewEmployee(Employee employee);

    public Employee updateEmployee(int empId, Employee employee);

    public void deleteById(int employeeId);
}