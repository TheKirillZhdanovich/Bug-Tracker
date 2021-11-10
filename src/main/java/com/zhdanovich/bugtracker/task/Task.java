package com.zhdanovich.bugtracker.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {

    @Id
    @SequenceGenerator(name = "task_sequence_generator", sequenceName = "task_sequence_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_sequence_generator")
    private Long id;
    private Long projectId;
    private String nameOfTask;
    private String status;
    private String priority;

    @Column(length=10000)
    private String description;

    public Task(Long projectId, String nameOfTask, String status, String priority, String description) {
        this.projectId = projectId;
        this.nameOfTask = nameOfTask;
        this.status = status;
        this.priority = priority;
        this.description = description;
    }

}
