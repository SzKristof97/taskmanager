package me.szkristof.taskmanagerapi.controllers;

import me.szkristof.taskmanagerapi.models.TaskEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final List<TaskEntity> tasks = createTasks();

    private List<TaskEntity> createTasks() {
        List<TaskEntity> _tasks = new ArrayList<>();
        _tasks.add(new TaskEntity(1, "Task 1", "Description 1", "Open", "High", Timestamp.valueOf("2022.11.09 12:00:00"), Timestamp.valueOf("2022.11.09 12:00:00")));
        _tasks.add(new TaskEntity(2, "Task 2", "Description 2", "Open", "Low", Timestamp.valueOf("2022.11.09 12:00:00"), Timestamp.valueOf("2022.11.09 12:00:00")));
        _tasks.add(new TaskEntity(3, "Task 3", "Description 3", "Closed", "Medium", Timestamp.valueOf("2022.11.09 12:00:00"), Timestamp.valueOf("2022.11.09 12:00:00")));

        return _tasks;
    }

    @RequestMapping(name = "/all", produces = "application/json", method = RequestMethod.GET)
    public List<TaskEntity> getAllTasks() {
        return tasks;
    }

    @RequestMapping(name = "/open", produces = "application/json", method = RequestMethod.GET)
    public List<TaskEntity> getOpenTasks() {
        List<TaskEntity> openTasks = new ArrayList<>();
        for (TaskEntity task : tasks) {
            if (task.getStatus().equals("Open")) {
                openTasks.add(task);
            }
        }
        return openTasks;
    }

    @RequestMapping(name = "/closed", produces = "application/json", method = RequestMethod.GET)
    public List<TaskEntity> getClosedTasks() {
        List<TaskEntity> closedTasks = new ArrayList<>();
        for (TaskEntity task : tasks) {
            if (task.getStatus().equals("Closed")) {
                closedTasks.add(task);
            }
        }
        return closedTasks;
    }

    @RequestMapping(name = "/{id}", produces = "application/json", method = RequestMethod.GET)
    public TaskEntity getTaskById(@RequestHeader int id) {
        for (TaskEntity task : tasks) {
            if (task.getID() == id) {
                return task;
            }
        }
        return null;
    }

    @RequestMapping(name = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public TaskEntity deleteTaskById(@RequestHeader int id) {
        TaskEntity taskToDelete = null;
        for (TaskEntity task : tasks) {
            if (task.getID() == id) {
                tasks.remove(task);
                taskToDelete = task;
                break;
            }
        }
        return taskToDelete;
    }

    @RequestMapping(name = "/create", produces = "application/json", method = RequestMethod.POST)
    public TaskEntity createTask(
            @RequestBody TaskEntity task
    ) {
        try{
            tasks.add(task);
            return task;
        } catch (Exception e) {
            return null;
        }
    }
}
