package com.springboot.database.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.database.sample.entities.CourseEntity;

public interface SampleRepository extends JpaRepository<CourseEntity, Integer> {
    List<CourseEntity> findByName(String name);

    List<CourseEntity> findByNameContaining(String name);

    List<CourseEntity> findByNameLike(String name);

    List<CourseEntity> findByNameLikeIgnoreCase(String name);

    @Query(value = "Select c From CourseEntity c")
    List<CourseEntity> findByQueryName();

    @Query(value = "Select course_name From course_table where area = 'Test'", nativeQuery = true)
    List<String> findByQueryNamePeerArea();

    @Query(value = "Select course_name From course_table where area = :area", nativeQuery = true)
    List<String> findByQueryNamePeerSelectedArea(@Param("area") String area);

    @Query(value = "Select course_name From course_table where area = :area and course_name = :name", nativeQuery = true)
    List<String> findByQueryNamePeerSelectedArea(@Param("area") String area, @Param("name") String name);

    @Query(value = "Select course_name From course_table where area = ?1 and course_name = ?2", nativeQuery = true)
    List<String> findByQueryNamePeerAreaParam(String area, String name);
}
