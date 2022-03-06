package com.example.springbootmvc.repository;

import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
