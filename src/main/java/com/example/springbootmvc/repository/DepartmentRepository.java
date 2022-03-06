package com.example.springbootmvc.repository;

import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
