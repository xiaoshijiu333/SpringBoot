package com.fei.firstspringboot.webmvc.depart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/21
 * @Description: Employee实体类
 */
@Setter
@Getter
@Table(name = "employee")
public class Employee {
    @Id
    private Integer employeeId;
    private String employeeName;
    private String employeeSex;
}
