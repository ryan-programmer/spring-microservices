package com.example.departmentservice.service;

import com.example.departmentservice.DTO.DepartmentDTO;
import com.example.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO getByDepartmentCode(String id);
}
