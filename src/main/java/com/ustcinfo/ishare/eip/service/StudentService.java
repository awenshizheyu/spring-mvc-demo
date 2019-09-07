/**
 * Project Name : spring-mvc-demo
 * File Name    : StudentService
 * Package Name : com.ustcinfo.ishare.eip.service
 * Date         : 2019-09-03 19:00
 * Author       : fan.wenbin
 * Copyright (c) 2018, fan.wenbin@ustcinfo.com All Rights Reserved.
 */
package com.ustcinfo.ishare.eip.service;

import com.ustcinfo.ishare.eip.bean.Student;
import com.ustcinfo.ishare.eip.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-mvc-demo
 * @className: StudentService
 * @description: TODO
 * @CreateTime: 2019-09-03 19:00
 * @author: fan.wenbin
 * @version: V1.0
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAll() {
        return studentDao.getAll();
    }

    public void delete(String id) {
        studentDao.delete(id);
    }

    public void save(Student student) {
        studentDao.save(student);
    }
}
