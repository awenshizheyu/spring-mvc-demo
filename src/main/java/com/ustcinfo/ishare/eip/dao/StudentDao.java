/**
 * Project Name : spring-mvc-demo
 * File Name    : StudentDao
 * Package Name : com.ustcinfo.ishare.eip.dao
 * Date         : 2019-09-03 19:02
 * Author       : fan.wenbin
 * Copyright (c) 2018, fan.wenbin@ustcinfo.com All Rights Reserved.
 */
package com.ustcinfo.ishare.eip.dao;

import com.ustcinfo.ishare.eip.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: spring-mvc-demo
 * @className: StudentDao
 * @description: TODO
 * @CreateTime: 2019-09-03 19:02
 * @author: fan.wenbin
 * @version: V1.0
 */
@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getAll() {
        String sql = "select `id`, `name`, `age` FROM student;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        List<Student> studentList = new ArrayList<Student>();
        Student student = null;
        if(list.isEmpty()) {
            return studentList;
        }
        for(Map<String, Object> map : list) {
            if(map == null || map.isEmpty()) {
                continue;
            }
            student = new Student();
            String id = map.get("id") == null ? "" : map.get("id").toString();
            String name = map.get("name") == null ? "" : map.get("name").toString();
            Integer age = map.get("age") == null ? 0 : (int) map.get("age");
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            studentList.add(student);
        }
        return studentList;
    }

    public void save(Student student) {
        if(student.getId() == null) {
            student.setId(UUID.randomUUID().toString() );
        }
        String sql = "INSERT INTO student VALUES('"
                + student.getId() + "', '"
                + student.getName() + "', "
                + student.getAge() + ");";
        System.out.println("SQL:" + sql);
        jdbcTemplate.execute(sql);
    }

    public void delete(String id) {
        String sql = "DELETE FROM student where id = '" + id + "';";
        jdbcTemplate.execute(sql);
    }

}
