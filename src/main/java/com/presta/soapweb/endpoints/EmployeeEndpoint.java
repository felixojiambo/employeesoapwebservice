package com.presta.soapweb.endpoints;
import com.presta.soapweb.models.Employee;
import com.presta.soapweb.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://com.presta.soapweb";

    @Autowired
    private EmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddEmployee")
    @ResponsePayload
    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
        Employee employee = request.getEmployee();
        Employee addedEmployee = employeeService.AddEmployee(employee);
        AddEmployeeResponse response = new AddEmployeeResponse();
        response.setResponse(new ServiceStatus("Success", "Employee added successfully"));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateEmployee")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        Employee employee = request.getEmployee();
        employeeService.updateEmployee(employee);
        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setResponse(new ServiceStatus("Success", "Employee updated successfully"));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteEmployee")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
        Long employeeId = Long.parseLong(request.getID());
        employeeService.deleteEmployee(employeeId);
        DeleteEmployeeResponse response = new DeleteEmployeeResponse();
        response.setResponse(new ServiceStatus("Success", "Employee deleted successfully"));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetEmployeeById")
    @ResponsePayload
    public GetEmployeeByIdResponse getEmployeeById(@RequestPayload GetEmployeeByIdRequest request) {
        Long employeeId = request.getEmployeeId();
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee!= null) {
            GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
            response.setEmployee(employee);
            response.getResponse().setResponse(new ServiceStatus("Success", "Employee retrieved successfully"));
            return response;
        } else {
            GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
            response.getResponse().setResponse(new ServiceStatus("Error", "Employee not found"));
            return response;
        }
    }
}
