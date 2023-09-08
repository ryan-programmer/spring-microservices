package com.example.employeeservice.service;

import com.example.employeeservice.DTO.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/v1/departments/{code}")
   DepartmentDTO  getDepartmentById(@PathVariable("code") String code);

}
