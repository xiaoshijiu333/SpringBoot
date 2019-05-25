package com.fei.firstspringboot.webmvc.depart.controller;

import com.fei.firstspringboot.webmvc.common.ApiResult;
import com.fei.firstspringboot.webmvc.depart.entity.Department;
import com.fei.firstspringboot.webmvc.depart.entity.Employee;
import com.fei.firstspringboot.webmvc.depart.mapper.DepartMapper;
import com.fei.firstspringboot.webmvc.depart.mapper.EmployeeTKMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

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
    private EmployeeTKMapper employeeTKMapper;

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
    public ApiResult<Department> getAllDeparts2() {
        PageHelper.startPage(1, 3);
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo("employeeSex", "男");
        List<Employee> list = employeeTKMapper.selectByExample(example);
        return ApiResult.success(list);
    }
}
