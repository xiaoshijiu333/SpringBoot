package com.fei.firstspringboot.webmvc.depart.controller;

import com.fei.firstspringboot.webmvc.common.ApiResult;
import com.fei.firstspringboot.webmvc.depart.entity.Department;
import com.fei.firstspringboot.webmvc.depart.entity.Employee;
import com.fei.firstspringboot.webmvc.depart.mapper.DepartMapper;
import com.fei.firstspringboot.webmvc.depart.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/20
 * @Description: 部门相关Controller
 */
@RestController
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartMapper departMapper;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询所有部门 Mybatis普通方法查询
     * @return ApiResult<Department>
     */
    @GetMapping("/getAll")
    public ApiResult<Department> getAllDeparts() {
        List<Department> allDepart = departMapper.getAllDepart();
        return ApiResult.success(allDepart);
    }

    /**
     * 查询所有部门 通用Mapper查询
     * @return ApiResult<Department>
     */
    @GetMapping("/getAllByTk")
    public ApiResult<PageInfo> getAllDeparts2() {
        PageHelper.startPage(1, 3);
        List<Employee> list = employeeService.getAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        return ApiResult.success(pageInfo);
    }
}
