package com.netcore.employeedetailsapplication.service;

import com.netcore.employeedetailsapplication.DTO.EmployeeDTO;
import com.netcore.employeedetailsapplication.entity.EmployeeDetails;
import com.netcore.employeedetailsapplication.exception.EmployeeDetailsException;
import com.netcore.employeedetailsapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDetails addEmployeeDetails(EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetail = employeeRepository.findByName(employeeDTO.getName());
        if(employeeDetail!=null){
            throw  new EmployeeDetailsException("Employee with same name already present");
        }
        EmployeeDetails employeeDetails = new EmployeeDetails(employeeDTO);
        return employeeRepository.save(employeeDetails);
    }

    @Override
    public EmployeeDetails updateEmployeeDetails(Long id, EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetail = this.getEmployeeDetailsById(id);
        employeeDetail.updateEmployeeDetail(employeeDTO);
        return employeeRepository.save(employeeDetail);
    }

    @Override
    public List<EmployeeDetails> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDetails getEmployeeDetailsById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeDetailsException("Employee with id : "+id + " not found"));
    }

    @Override
    public void deleteEmployeeDetails(Long id) {
        EmployeeDetails employeeDetails = this.getEmployeeDetailsById(id);
        employeeRepository.deleteById(id);
    }

    @Override
    @Cacheable(value="employee_details", key="#id")
    public EmployeeDetails getEmployeeDetailsByIdFromRedis(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeDetailsException("Employee with id : "+id + " not found"));
    }

    @Override
    @CachePut(value="employee_details", key="#id")
    public EmployeeDetails updateEmployeeDetailsFromRedis(Long id, EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetails = this.getEmployeeDetailsByIdFromRedis(id);
        employeeDetails.updateEmployeeDetail(employeeDTO);
        return employeeRepository.save(employeeDetails);
    }

    @Override
    @CacheEvict(value="employee_details", key="#id")
    public void deleteEmployeeFromRedis(Long id) {
        EmployeeDetails employeeDetails = getEmployeeDetailsByIdFromRedis(id);
        employeeRepository.deleteById(id);
    }

}
