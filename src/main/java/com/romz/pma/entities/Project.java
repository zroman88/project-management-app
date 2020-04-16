package com.romz.pma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author roman - Project project-management
 */
@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1, initialValue = 1)
    private long projectId;

    @NotNull
    private String name;

    @NotNull
    private String stage;

    @NotNull
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @ToString.Exclude
    @JsonIgnore
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if (employees == null) employees = new ArrayList<>();

        employees.add(employee);
    }
}
