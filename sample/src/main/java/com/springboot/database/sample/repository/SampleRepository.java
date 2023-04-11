package com.springboot.database.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.database.sample.entities.SampleEntity;

public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {

}
