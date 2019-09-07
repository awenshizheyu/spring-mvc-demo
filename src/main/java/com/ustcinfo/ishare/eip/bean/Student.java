/**
 * Project Name : spring-mvc-demo
 * File Name    : Student
 * Package Name : com.ustcinfo.ishare.eip.bean
 * Date         : 2019-09-03 18:57
 * Author       : fan.wenbin
 * Copyright (c) 2018, fan.wenbin@ustcinfo.com All Rights Reserved.
 */
package com.ustcinfo.ishare.eip.bean;

import java.util.Objects;

/**
 * @program: spring-mvc-demo
 * @className: Student
 * @description: TODO
 * @CreateTime: 2019-09-03 18:57
 * @author: fan.wenbin
 * @version: V1.0
 */
public class Student {

    private String id;
    private String name;
    private Integer age;

    public Student() {
        super();
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id) &&
                name.equals(student.name) &&
                age.equals(student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
