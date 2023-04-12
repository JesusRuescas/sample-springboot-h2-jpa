package com.springboot.database.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.database.sample.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
