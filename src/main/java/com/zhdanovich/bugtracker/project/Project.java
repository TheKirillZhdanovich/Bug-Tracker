package com.zhdanovich.bugtracker.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Project {

    @Id
    @SequenceGenerator(name = "project_sequence_generator", sequenceName = "project_sequence_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_sequence_generator")
    private Long id;
    private String nameOfProject;

    public Project(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }

}
