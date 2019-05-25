package com.fei.firstspringboot.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiaoshijiu
 * @description 测试属性文件赋值
 * @package com.fei.firstspringboot.test
 * @date 2019/5/8
 */
@Component
@ConfigurationProperties(prefix = "test")
public class Student {

    /**
     * @ConfigurationProperties 必须要为属性提供set，get方法；@Value则不需要
     */
    private String name;
    private Integer age;
    private String sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String  toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
