package com.netcore.employeedetailsapplication.entity;

import com.netcore.employeedetailsapplication.DTO.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private String mobileNo;

    private String department;

    private double salary;

    public EmployeeDetails(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.email = employeeDTO.email;
        this.mobileNo = employeeDTO.mobileNo;
        this.department = employeeDTO.department;
        this.salary = employeeDTO.salary;
    }

    public void updateEmployeeDetail(EmployeeDTO employeeDTO){
        this.name = employeeDTO.name;
        this.email = employeeDTO.email;
        this.mobileNo = employeeDTO.mobileNo;
        this.department = employeeDTO.department;
        this.salary = employeeDTO.salary;
    }
}
