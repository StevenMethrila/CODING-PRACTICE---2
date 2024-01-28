/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.employee;

import com.example.employee.Employee;
import com.example.employee.EmployeeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import com.example.employee.Employee;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();

    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    // Write your code here
    int uniqueId = 7;

    public ArrayList<Employee> getAll() {
        Collection<Employee> c = employeeList.values();
        ArrayList<Employee> arr = new ArrayList<>(c);
        return arr;

    }

    public Employee getById(int empId) {
        Employee employee = employeeList.get(empId);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return employee;
    }

    public Employee AddNewEmployee(Employee employee) {
        employee.setEmployeeId(uniqueId);
        employeeList.put(uniqueId, employee);
        uniqueId += 1;
        return employee;
    }

    public Employee updateEmployee(int empId, Employee employee) {
        Employee existing = employeeList.get(empId);
        if (existing == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (employee.getEmployeeName() != null) {
            existing.setEmployeeName(employee.getEmployeeName());
        }
        if (employee.getEmail() != null) {
            existing.setEmail(employee.getEmail());
        }
        if (employee.getDepartment() != null) {
            existing.setDepartment(employee.getDepartment());
        }
        return existing;
    }

    public void deleteById(int employeeId) {
        Employee employee = employeeList.get(employeeId);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
