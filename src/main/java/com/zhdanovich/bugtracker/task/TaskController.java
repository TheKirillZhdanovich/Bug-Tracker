package com.zhdanovich.bugtracker.task;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private Long projectId;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // TODO: add another get method and create global for this class variable which contains the project_id

    @GetMapping("/{id}")
    public String showTasks(Model model, @PathVariable("id") Long id) {
        projectId = id;
        model.addAttribute("tasks", taskService.showTasks(projectId));
        return "tasks/tasks";
    }

    @GetMapping()
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.showTasks(projectId));
        return "tasks/tasks";
    }

    @GetMapping("/new")
    public String createTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);

        List<String> listOfStatuses = Arrays.asList("Not Started", "In Progress", "Done");
        model.addAttribute("listOfStatuses", listOfStatuses);

        List<String> listOPriorities = Arrays.asList("Low", "Medium", "High");
        model.addAttribute("listOfPriorities", listOPriorities);

        return "tasks/create_task";
    }

    @PostMapping()
    public String addTask(@ModelAttribute("task") Task task) {
        task.setProjectId(projectId);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{taskId}")
    public String editTask(Model model, @PathVariable("taskId") Long id) {

        model.addAttribute("task", taskService.getTaskById(id));

        List<String> listOfStatuses = Arrays.asList("Not Started", "In Progress", "Done");
        model.addAttribute("listOfStatuses", listOfStatuses);

        List<String> listOPriorities = Arrays.asList("Low", "Medium", "High");
        model.addAttribute("listOfPriorities", listOPriorities);

        return "tasks/edit_task";
    }

    @PostMapping("/{taskId}")
    public String updateTask(@ModelAttribute("task") Task task, @PathVariable("taskId") Long id) {
        taskService.updateTask(task, id);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteTasks(@PathVariable("taskId") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/concrete/{taskId}")
    public String concreteTask(Model model, @PathVariable("taskId") Long id) {
        model.addAttribute("challenge", taskService.getTaskById(id));
        return "tasks/concrete_task";
    }

}
