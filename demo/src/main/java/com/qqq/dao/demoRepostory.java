package com.qqq.dao;

import com.qqq.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface demoRepostory extends MongoRepository<Student,Integer> {

    public List<Student> findAll();

}
