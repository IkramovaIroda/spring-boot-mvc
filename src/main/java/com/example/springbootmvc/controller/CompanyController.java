package com.example.springbootmvc.controller;

import com.example.springbootmvc.entity.Company;
import com.example.springbootmvc.repository.CompanyRepository;
import com.example.springbootmvc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    //zaproslarni tutib ishlatish
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getCompanyPage(Model model) {

        model.addAttribute("list", companyRepository.findAll());
        //listini yuborish
        return "company/company";
    }


    @GetMapping("/add")
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getSavecompany() {

        return "company/company-add";
    }

    @PostMapping("/add")
    public String saveCompany(Model model, @ModelAttribute Company company) {
        companyService.add(company);
        return "redirect:/company";
    }


}
