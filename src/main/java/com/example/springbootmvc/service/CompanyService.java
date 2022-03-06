package com.example.springbootmvc.service;

import com.example.springbootmvc.dto.ApiResponse;
import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public ApiResponse add(Company company) {
        Company save = companyRepository.save(company);
        return new ApiResponse("Saved", true, save);
    }
}
