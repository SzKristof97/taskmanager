package me.szkristof.taskmanagerapi.controllers;

import me.szkristof.taskmanagerapi.exceptions.taskexceptions.TaskAlreadyAddedException;
import me.szkristof.taskmanagerapi.exceptions.taskexceptions.TaskNotFoundException;
import me.szkristof.taskmanagerapi.models.TaskEntity;
import me.szkristof.taskmanagerapi.models.error.ErrorResponse;
import me.szkristof.taskmanagerapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    //<editor-fold default-state="collapsed" desc="Autowired fields">
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
        TaskEntity taskEntity = taskService.addTask(task);

        if (taskEntity == null) {
            throw new TaskAlreadyAddedException("Task with ID " + task.getID() + " already exists!");
        }

        return taskEntity;
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="DELETE Mappings">

    @DeleteMapping("/tasks/delete/{id}")
    public TaskEntity deleteTask(@PathVariable int id) {
        TaskEntity taskEntity = taskService.deleteTask(id);

        if (taskEntity == null) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }

        return taskEntity;
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="PUT Mappings">

    @PutMapping("/tasks/update/{id}")
    public TaskEntity updateTask(@PathVariable int id, @RequestBody TaskEntity task) {
        TaskEntity taskEntity = taskService.updateTask(id, task);

        if(taskEntity == null) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }

        return taskEntity;
    }

    //</editor-fold>


    //<editor-fold default-state="collapsed" desc="Error Handler">

    @ExceptionHandler(value = TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleTaskNotFoundException(TaskNotFoundException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(value = TaskAlreadyAddedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleTaskAlreadyAddedException(TaskAlreadyAddedException e) {
        return new ErrorResponse(HttpStatus.CONFLICT.value(),  e.getMessage());
    }

    //</editor-fold>
}
