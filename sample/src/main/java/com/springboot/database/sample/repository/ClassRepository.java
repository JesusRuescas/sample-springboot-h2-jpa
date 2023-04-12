package com.springboot.database.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.database.sample.entities.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

}
