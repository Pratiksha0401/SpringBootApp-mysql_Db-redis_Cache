package com.netcore.employeedetailsapplication.service;

import com.netcore.employeedetailsapplication.DTO.EmployeeDTO;
import com.netcore.employeedetailsapplication.entity.EmployeeDetails;

import java.util.List;

public interface IEmployeeService {
    EmployeeDetails addEmployeeDetails(EmployeeDTO employeeDTO);
    EmployeeDetails updateEmployeeDetails(Long id ,EmployeeDTO employeeDTO);
    List<EmployeeDetails> getAllEmployeeDetails();
    EmployeeDetails getEmployeeDetailsById(long id);
    void deleteEmployeeDetails(Long id);
    EmployeeDetails getEmployeeDetailsByIdFromRedis(long id);
    EmployeeDetails updateEmployeeDetailsFromRedis(Long id ,EmployeeDTO employeeDTO);
    void deleteEmployeeFromRedis(Long id);
}
