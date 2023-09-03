package com.example.employeeservice.service;

import com.example.employeeservice.DTO.APIResponseEntity;
import com.example.employeeservice.DTO.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    APIResponseEntity getEmployeeById(int id);
}
