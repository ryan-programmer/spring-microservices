package com.example.employeeservice.mapper;


import com.example.employeeservice.DTO.EmployeeDTO;
import com.example.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee){

        EmployeeDTO departmentDTO = new EmployeeDTO(
                employee.getId(),
                employee.getEmployeeName(),
                employee.getDescription(),
                employee.getEmployeeCode(),
                employee.getDepartmentCode()

        );
        return departmentDTO;

    }

    public static Employee mapEmployeeDTOtoEmployee(EmployeeDTO employeeDTO){

        Employee department = new Employee(
                employeeDTO.getId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getDescription(),
                employeeDTO.getEmployeeCode(),
                employeeDTO.getDepartmentCode()
        );

        return  department;

    }
}
