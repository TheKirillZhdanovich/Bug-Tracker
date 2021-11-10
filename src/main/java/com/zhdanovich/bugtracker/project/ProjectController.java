package com.zhdanovich.bugtracker.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public String showProjects(Model model) {
        model.addAttribute("projects", projectService.showProjects());
        return "projects/projects";
    }

    @GetMapping("/new")
    public String createProject(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects/create_project";
    }

    @PostMapping()
    public String addProject(@ModelAttribute Project project) {
        projectService.saveProjects(project);
        return "redirect:/project";
    }

    @GetMapping("/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/project";
    }
}
