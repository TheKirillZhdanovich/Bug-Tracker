package com.zhdanovich.bugtracker.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> showTasks(Long projectId) {
        return taskRepository.findTasksByProjectId(projectId);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }

    public void updateTask(Task task, Long id) {
        Task updatedTask = taskRepository.findTaskById(id);

        updatedTask.setNameOfTask(task.getNameOfTask());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setDescription(task.getDescription());

        taskRepository.save(updatedTask);
    }

}
