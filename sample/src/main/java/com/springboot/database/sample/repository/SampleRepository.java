package com.springboot.database.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.database.sample.entities.SampleEntity;

public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {
    List<SampleEntity> findByName(String name);

    List<SampleEntity> findByNameContaining(String name);

    List<SampleEntity> findByNameLike(String name);

    List<SampleEntity> findByNameLikeIgnoreCase(String name);

    @Query(value = "Select s From SampleEntity s")
    List<SampleEntity> findByQueryName();

    @Query(value = "Select sample_name From sample_table where area = 'Test'", nativeQuery = true)
    List<String> findByQueryNamePeerArea();

    @Query(value = "Select sample_name From sample_table where area = :area", nativeQuery = true)
    List<String> findByQueryNamePeerSelectedArea(@Param("area") String area);

    @Query(value = "Select sample_name From sample_table where area = :area and sample_name = :name", nativeQuery = true)
    List<String> findByQueryNamePeerSelectedArea(@Param("area") String area, @Param("name") String name);

    @Query(value = "Select sample_name From sample_table where area = ?1 and sample_name = ?2", nativeQuery = true)
    List<String> findByQueryNamePeerAreaParam(String area, String name);
}
