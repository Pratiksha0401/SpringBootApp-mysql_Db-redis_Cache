package com.netcore.employeedetailsapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}$", message = "Employee Name not Valid")
    @NotBlank(message = "Name must not blank")
    public String name;
    @Pattern(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", message = "Please provide valid email address")
    @NotBlank(message = "email must not blank")
    public String email;
    @Pattern(regexp = "^[+]{0,1}[0-9]{2,3}\\s{0,1}[1-9]{1}[0-9]{9}$", message = "Invalid mobile number")
    @NotBlank(message = "mobile no. must not blank")
    public String mobileNo;
    @NotBlank(message = "Please enter department")
    public String department;
    @Min(value = 500,message = "minimum salary must be 500")
    @Digits(integer = 10, fraction = 2 , message = "must be decimal")
    public double salary;
}
