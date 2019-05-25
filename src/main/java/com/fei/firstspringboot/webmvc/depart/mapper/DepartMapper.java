package com.fei.firstspringboot.webmvc.depart.mapper;

import com.fei.firstspringboot.webmvc.depart.entity.Department;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/20
 * @Description: 部门数据库接口
 */
public interface DepartMapper {

    /**
     * 查询所有部门
     * @return 所有部门列表
     */
    List<Department> getAllDepart();
}
