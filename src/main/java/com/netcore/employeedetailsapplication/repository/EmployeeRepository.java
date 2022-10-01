package com.netcore.employeedetailsapplication.repository;

import com.netcore.employeedetailsapplication.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails , Long> {
    EmployeeDetails findByName(String name);
}
