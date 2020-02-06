package com.romz.pma.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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


}
