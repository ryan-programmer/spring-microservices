package com.example.employeeservice.controller;

import com.example.employeeservice.DTO.APIResponseEntity;
import com.example.employeeservice.DTO.EmployeeDTO;
import com.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("createEmployee")
    public ResponseEntity<EmployeeDTO> saveDepartment(@RequestBody  EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseEntity> getEmployeeById(@PathVariable("id") int id){
        APIResponseEntity apiResponseEntity = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseEntity,HttpStatus.OK);

    }

}
