package com.example.springjparest.manytomany.compositepkextracolumn.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@ToString(exclude = "courses")
@EqualsAndHashCode(exclude = "courses")
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<CourseStudent> courses = new LinkedHashSet<>();

    @Column(nullable = false)
    private String name;
}