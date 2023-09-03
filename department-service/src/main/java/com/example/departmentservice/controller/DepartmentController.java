package com.example.departmentservice.controller;

import com.example.departmentservice.DTO.DepartmentDTO;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("createUser")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO saveddepartmentDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(saveddepartmentDTO, HttpStatus.CREATED);
    }


    @GetMapping("")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        List<DepartmentDTO> departmentDTO = departmentService.getAllDepartment();
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }


    @GetMapping("{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("code") String code){
        DepartmentDTO departmentDTO = departmentService.getByDepartmentCode(code);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }
}
