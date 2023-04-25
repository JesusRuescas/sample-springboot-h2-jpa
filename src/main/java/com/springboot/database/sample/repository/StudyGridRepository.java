package com.springboot.database.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.database.sample.entities.StudyGridEntity;

public interface StudyGridRepository extends JpaRepository<StudyGridEntity, Integer> {

}
