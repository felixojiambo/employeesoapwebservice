package com.presta.soapweb.services;

import com.presta.soapweb.models.Employee;

public interface EmployeeService {
    Employee AddEmployee(Employee employee);
     Employee getEmployeeById(long employeeId);
     void updateEmployee(Employee employee);
     void deleteEmployee(long employeeId);
}
