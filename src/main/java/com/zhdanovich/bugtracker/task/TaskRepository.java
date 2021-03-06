package com.zhdanovich.bugtracker.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByProjectId(Long projectId);
    Task findTaskById(Long taskId);

}
