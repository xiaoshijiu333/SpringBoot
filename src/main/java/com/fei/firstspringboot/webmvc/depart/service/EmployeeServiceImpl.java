package com.fei.firstspringboot.webmvc.depart.service;

import com.fei.firstspringboot.webmvc.depart.entity.Employee;
import com.fei.firstspringboot.webmvc.depart.mapper.EmployeeTKMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/13
 * @Description: 员工服务层接口实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeTKMapper employeeTKMapper;

    @Override
    public Integer updateEmployee(Integer employeeId) {
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo("employeeId", employeeId);
        Employee employee = new Employee();
        employee.setEmployeeName("张三");
        return employeeTKMapper.updateByExampleSelective(employee, example);
    }

    @Override
    public Integer insertEmployee(Employee employee) {
        employee.setEmployeeName("张三");
        return employeeTKMapper.insertSelective(employee);
    }
}
