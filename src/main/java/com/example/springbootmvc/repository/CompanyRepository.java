package com.example.springbootmvc.repository;

import com.example.springbootmvc.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
