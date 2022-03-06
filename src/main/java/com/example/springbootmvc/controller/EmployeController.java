package com.example.springbootmvc.controller;

import com.example.springbootmvc.dto.DepartmentDTO;
import com.example.springbootmvc.dto.EmployeDTO;
import com.example.springbootmvc.repository.CompanyRepository;
import com.example.springbootmvc.repository.DepartmentRepository;
import com.example.springbootmvc.repository.EmployeRepository;
import com.example.springbootmvc.service.DepartmentService;
import com.example.springbootmvc.service.EmployeService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;


@Controller
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    EmployeService departmentService;
    @Autowired
    EmployeRepository departmentRepository;
    @Autowired
    CompanyRepository companyRepository;

    //zaproslarni tutib ishlatish
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getEmployePage(Model model) {

        model.addAttribute("list", departmentRepository.findAll());
        //listini yuborish
        return "employe/employe";
    }

    @GetMapping("/add")
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getSaveemploye(Model model) {

        model.addAttribute("companyList", companyRepository.findAll());

        return "employe/employe-add";
    }

    @PostMapping("/add")
    public String saveEmploye(Model model, @ModelAttribute EmployeDTO dto) {
        departmentService.add(dto);
        return "redirect:/employe";
    }

    @GetMapping("/delete/{id}") //1 45 24 90
    public String delete(@PathVariable Integer id) {
        departmentRepository.deleteById(id);
        return "redirect:/employe";
    }
    @PostMapping("/edit/{id}")
    public String editSave(@ModelAttribute EmployeDTO dto, @PathVariable Integer id){
//        Optional<Department> byId = departmentRepository.findById(employee.getDepartment().getId());
//        Department department = byId.get();
        departmentService.edit(dto, id);
        return "redirect:/employee";
    }


}
