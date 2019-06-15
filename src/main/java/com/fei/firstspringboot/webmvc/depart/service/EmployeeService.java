package com.fei.firstspringboot.webmvc.depart.service;

import com.fei.firstspringboot.webmvc.depart.entity.Employee;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/13
 * @Description: 员工服务层接口
 */
public interface EmployeeService {
    /**
     * 更新员工
     * 用于单元测试
     */
    Integer updateEmployee(Integer employeeId);
    Integer insertEmployee(Employee employee);
}
