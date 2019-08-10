package com.appointment.company.service;

import com.appointment.common.utils.IdWorker;
import com.appointment.company.Company;
import com.appointment.company.mapper.CompanyMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMappper companyMappper;

    @Autowired
    private IdWorker idWorker;

    public void add(Company company){
        final String id = idWorker.nextId() + "";
        company.setId(id);
        companyMappper.insert(company);
    }

    public void delete(String id){
        companyMappper.deleteById(id);
    }

    public Company findById(String id){
        final Company company = companyMappper.selectById(id);
        return company;
    }

    public List<Company> findAll(){
        List<Company> companies = companyMappper.selectList(null);
        return companies;
    }
}
