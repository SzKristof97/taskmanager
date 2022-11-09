package me.szkristof.taskmanagerapi.controllers;

import me.szkristof.taskmanagerapi.models.TaskEntity;
import me.szkristof.taskmanagerapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    //<editor-fold default-state="collapsed" desc="Autowired field">
    @Autowired
    private TaskService taskService;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="GET Mappings">

    @GetMapping("/tasks/all")
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="POST Mappings">

    @PostMapping("/tasks/add")
    public TaskEntity addTask(@RequestBody TaskEntity task) {
        return taskService.addTask(task);
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="DELETE Mappings">

    @DeleteMapping("/tasks/delete/{id}")
    public TaskEntity deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }

    //</editor-fold>


}
