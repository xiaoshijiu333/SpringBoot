package com.fei.firstspringboot.service;

import com.fei.firstspringboot.webmvc.depart.entity.Employee;
import com.fei.firstspringboot.webmvc.depart.mapper.EmployeeTKMapper;
import com.fei.firstspringboot.webmvc.depart.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import static org.mockito.Mockito.times;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/13
 * @Description: 服务层测试
 */
/**
 * 使用@RunWith(SpringRunner.class) 因为需要加载一些配置
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    /**
     * 将mock的数据注入
     */
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    /**
     * Mock：伪造的数据
     */
    @Mock
    private EmployeeTKMapper employeeTKMapper;

    /**
     * 模拟单元测试
     */
    @Test
    public void updateTest() {
        Mockito.when(employeeTKMapper.updateByExampleSelective(Mockito.any(Employee.class),
                Mockito.any(Example.class))).thenReturn(1);
        Assert.assertTrue(employeeService.updateEmployee(1) == 1);
        Mockito.verify(employeeTKMapper, times(1))
                .updateByExampleSelective(Mockito.any(Employee.class), Mockito.any(Example.class));
    }

    @Test
    public void insertTest() {
        Employee employee = new Employee();
        Mockito.when(employeeTKMapper.insertSelective(employee)).thenReturn(2);
        Assert.assertTrue(employeeService.insertEmployee(employee) == 2);
    }

}
