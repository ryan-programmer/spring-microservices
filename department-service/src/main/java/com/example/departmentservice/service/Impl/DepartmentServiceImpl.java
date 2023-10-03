package com.example.departmentservice.service.Impl;

import com.example.departmentservice.DTO.DepartmentDTO;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.mapper.DepartmentMapper;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapDepartmentDTOtoDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDTO savedDepartmentDTO = DepartmentMapper.mapDepartmentToDapertmentDTO(savedDepartment);
        return savedDepartmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
       List<Department> department = departmentRepository.findAll();
      return department.stream().map(DepartmentMapper::mapDepartmentToDapertmentDTO)
              .collect(Collectors.toList());

    }

    @Override
    public DepartmentDTO getByDepartmentCode(String code) {
            Department department =  departmentRepository.findByDepartmentCode(code);
        return  DepartmentMapper.mapDepartmentToDapertmentDTO(department);

    }
}
