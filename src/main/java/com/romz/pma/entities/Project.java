package com.romz.pma.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author roman - Project project-management
 */
@Entity
@Data @RequiredArgsConstructor @NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @NonNull
    private String name;

    @NonNull
    private String stage;

    @NonNull
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;
}
