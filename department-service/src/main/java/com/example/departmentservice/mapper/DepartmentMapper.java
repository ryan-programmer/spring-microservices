package com.example.departmentservice.mapper;

import com.example.departmentservice.DTO.DepartmentDTO;
import com.example.departmentservice.entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO mapDepartmentToDapertmentDTO(Department department){

        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDescription(),
                department.getDepartmentCode()
        );
        return departmentDTO;

    }

    public static Department mapDepartmentDTOtoDepartment(DepartmentDTO departmentDTO){

        Department department = new Department(
          departmentDTO.getId(),
          departmentDTO.getDepartmentName(),
          departmentDTO.getDescription(),
          departmentDTO.getDepartmentCode()
        );

        return  department;

    }
}
