package com.springboot.database.sample.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "class_grid", joinColumns = {
            @JoinColumn(name = "class_ id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "grid_ id", referencedColumnName = "id") })
    private Set<StudyGridEntity> studyGrid = new HashSet<>();

    public ClassEntity() {
    }

    public ClassEntity(String name, Set<StudyGridEntity> studyGrid) {
        this.name = name;
        this.studyGrid = studyGrid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudyGridEntity> getStudyGrid() {
        return studyGrid;
    }

    public void setStudyGrid(Set<StudyGridEntity> studyGrid) {
        this.studyGrid = studyGrid;
    }

}
