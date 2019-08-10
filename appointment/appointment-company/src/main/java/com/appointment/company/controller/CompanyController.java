package com.appointment.company.controller;

import com.appointment.common.entity.Result;
import com.appointment.common.entity.ResultCode;
import com.appointment.company.Company;
import com.appointment.company.mapper.CompanyMappper;
import com.appointment.company.service.CompanyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@Api(value = "公司管理接口",description = "公司增删改查")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //按id查询公司
    @ApiOperation("按id查询公司")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result find(@PathVariable String id){
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    //添加公司
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result add(@RequestBody Company company){
        companyService.add(company);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //删除公司
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        companyService.delete(id);
        Result result = new Result(ResultCode.SUCCESS);
        return result;
    }

    //查询所有公司
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Result findAll(){
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }

}
