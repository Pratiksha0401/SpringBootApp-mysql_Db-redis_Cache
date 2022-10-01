package com.netcore.employeedetailsapplication.controller;

import com.netcore.employeedetailsapplication.DTO.EmployeeDTO;
import com.netcore.employeedetailsapplication.DTO.ResponseDTO;
import com.netcore.employeedetailsapplication.entity.EmployeeDetails;
import com.netcore.employeedetailsapplication.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeDetailsController {

    @Autowired
    IEmployeeService iEmployeeService;

    @PostMapping("/mysql")
    public ResponseEntity<ResponseDTO> addEmployeeDetails(@RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDetails employeeDetails = iEmployeeService.addEmployeeDetails(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details Successfully Added",employeeDetails);
        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);
    }


    @GetMapping("/mysql")
    public ResponseEntity<ResponseDTO> getAllEmployeeDetails(){
        List<EmployeeDetails> employeeDetails = iEmployeeService.getAllEmployeeDetails();
        ResponseDTO responseDTO = new ResponseDTO("List Of All Employees",employeeDetails);
        return new ResponseEntity<>(responseDTO , HttpStatus.OK);
    }

    @GetMapping( "/mysql/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeDetailById(@PathVariable long id){
        EmployeeDetails employeeDetails = iEmployeeService.getEmployeeDetailsById(id);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details by Id",employeeDetails);
        return new ResponseEntity<>(responseDTO , HttpStatus.OK);
    }

    @PutMapping("/mysql/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeeDetails(@PathVariable Long id , @RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDetails employeeDetails = iEmployeeService.updateEmployeeDetails(id,employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details Successfully Updated",employeeDetails);
        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);
    }

    @DeleteMapping("/mysql/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeeDetails(@PathVariable Long id){
        iEmployeeService.deleteEmployeeDetails(id);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details deleted successfully", "Deleted id:"+id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping( "/mysql/redis/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeDetailByIdFromRedis(@PathVariable long id){
        EmployeeDetails employeeDetails = iEmployeeService.getEmployeeDetailsByIdFromRedis(id);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details by Id",employeeDetails);
        return new ResponseEntity<>(responseDTO , HttpStatus.OK);
    }

    @PutMapping("/mysql/redis/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeeDetailsFromRedis(@PathVariable Long id , @RequestBody @Valid EmployeeDTO employeeDTO){
        EmployeeDetails employeeDetails = iEmployeeService.updateEmployeeDetailsFromRedis(id,employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details Successfully Updated",employeeDetails);
        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);
    }

    @DeleteMapping("/mysql/redis/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeeDetailsFromRedis(@PathVariable Long id){
        iEmployeeService.deleteEmployeeFromRedis(id);
        ResponseDTO responseDTO = new ResponseDTO("Employee Details deleted successfully", "Deleted id:"+id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
