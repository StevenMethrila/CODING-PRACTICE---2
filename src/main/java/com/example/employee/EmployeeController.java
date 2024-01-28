/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.employee;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.employee.Employee;
import java.util.*;
import com.example.employee.EmployeeService;

@RestController
public class EmployeeController {
    EmployeeService es = new EmployeeService();

    @GetMapping("/employees")
    public ArrayList<Employee> getMethod() {
        return es.getAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getMethodById(@PathVariable("employeeId") int employeeId) {
        return es.getById(employeeId);
    }

    @PostMapping("/employees")
    public Employee postMethod(@RequestBody Employee employee) {
        return es.AddNewEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee putMethod(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee) {
        return es.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteMethod(@PathVariable("employeeId") int employeeId) {
        es.deleteById(employeeId);
    }
}