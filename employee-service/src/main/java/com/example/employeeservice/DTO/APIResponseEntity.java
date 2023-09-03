package com.example.employeeservice.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseEntity {

    private EmployeeDTO employeeDTO;
    private DepartmentDTO departmentDTO;
}
