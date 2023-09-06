package com.example.employeeservice.service.Impl;


import com.example.employeeservice.DTO.APIResponseEntity;
import com.example.employeeservice.DTO.DepartmentDTO;
import com.example.employeeservice.DTO.EmployeeDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.mapper.EmployeeMapper;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.APIClient;
import com.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;


    @Override
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapEmployeeDTOtoEmployee(employeeDTO);
        Employee savedDepartment = employeeRepository.save(employee);
        EmployeeDTO savedDepartmentDTO = EmployeeMapper.mapEmployeeToEmployeeDTO(savedDepartment);
        return savedDepartmentDTO;
    }

    @Override
    public APIResponseEntity getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).get();
//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:9091/api/v1/departments/"+employee.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();
        DepartmentDTO departmentDTO = new DepartmentDTO();

//------WebClient HTTP Request -----------------

//             departmentDTO = webClient.get().uri("http://localhost:9091/api/v1/departments/" + employee.getDepartmentCode())
//                    .retrieve()
//                    .bodyToMono(DepartmentDTO.class)
//                    .block();
//-------------------------------------------------

//------Open Feign -------
       departmentDTO =  apiClient.getDepartmentById(employee.getDepartmentCode());
//--------------------
        EmployeeDTO employeeDTO =  EmployeeMapper.mapEmployeeToEmployeeDTO(employee);

        APIResponseEntity apiResponseEntity = new APIResponseEntity();
        apiResponseEntity.setEmployeeDTO(employeeDTO);
        apiResponseEntity.setDepartmentDTO(departmentDTO);

        return apiResponseEntity;
    }
}
