package com.presta.soapweb.services.impl;
import com.presta.soapweb.models.Employee;
import com.presta.soapweb.repository.EmployeeRepository;
import com.presta.soapweb.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void AddEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
 employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long employeeId) {
employeeRepository.deleteById(employeeId);
    }
}
