package me.szkristof.taskmanagerapi.services;

import io.swagger.v3.oas.annotations.Parameter;
import me.szkristof.taskmanagerapi.models.TaskEntity;
import me.szkristof.taskmanagerapi.repos.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    //<editor-fold default-state="collapsed" desc="Autowired field">

    @Autowired
    private TaskRepository taskRepository;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Constructor">
    public TaskService(){}
    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="GET Mapping methods">

    @Description("Returns all tasks")
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll().stream().toList();
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="POST Mapping methods">

    @Parameter(description = "The task to be added to the database")
    @Description("Adds a task to the database")
    public TaskEntity addTask(TaskEntity task) {
        Optional<TaskEntity> taskEntity = taskRepository.findById(task.getID());

        if (!taskEntity.isPresent()) {
            return taskRepository.save(task);
        }

        return null;
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="DELETE Mapping methods">

    @Parameter(description = "The ID of the task to delete")
    @Description("Deletes a task from the database")
    public TaskEntity deleteTask(int id) {
        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        if (taskEntity.isPresent()) {
            taskRepository.deleteById(id);
            return taskEntity.get();
        }
        return null;
    }

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="PUT Mapping methods">

    @Parameter(description = "The ID of the task to update")
    @Description("Updates a task in the database")
    public TaskEntity updateTask(int id, TaskEntity task) {
        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        if (taskEntity.isPresent()) {
            task.setID(id);
            return taskRepository.save(task);
        }
        return null;
    }

    //</editor-fold>

}
