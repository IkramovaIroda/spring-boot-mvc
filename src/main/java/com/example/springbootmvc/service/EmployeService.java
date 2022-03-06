package com.example.springbootmvc.service;

import com.example.springbootmvc.dto.ApiResponse;
import com.example.springbootmvc.dto.EmployeDTO;
import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.entity.Employe;
import com.example.springbootmvc.repository.CompanyRepository;
import com.example.springbootmvc.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    EmployeRepository departmentRepository;
    @Autowired
    CompanyRepository companyRepository;


    public ApiResponse add(EmployeDTO departmentDTO) {
        Optional<Company> optionalCompany = companyRepository.findById(departmentDTO.getCompanyId());
        if (optionalCompany.isEmpty()) return new ApiResponse("Akaajon bunaqa id yoq", false);
        Company company = optionalCompany.get();

        Employe department = new Employe();
        department.setName(departmentDTO.getName());
        department.setCompany(company);

        Employe save = departmentRepository.save(department);
        return new ApiResponse("Saved", true, save);
    }
    public ApiResponse edit(EmployeDTO dto , Integer id){
        Optional<Company> departmentId = companyRepository.findById(dto.getCompanyId());
        Company department = new Company();
        if (departmentId.isEmpty()) {
            return new ApiResponse("Bunday Id yo'q!!!", false);
        }
        department=departmentId.get();
        Employe employee = new Employe();
        employee.setName(dto.getName());
        employee.setId(id);
        employee.setCompany(department);
        Employe save = departmentRepository.save(employee);
        return new ApiResponse("Saved", true, save);

    }

}
