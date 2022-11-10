package me.szkristof.taskmanagerapi.models;

import me.szkristof.taskmanagerapi.enums.taskenums.TaskPriorityEnum;
import me.szkristof.taskmanagerapi.enums.taskenums.TaskStatusEnum;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "tasks")
public class TaskEntity {

    //<editor-fold default-state="collapsed" desc="Private fields">

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ID;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, columnDefinition = "ENUM('TODO', 'IN_PROGRESS', 'DONE')")
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;
    @Column(nullable = false, columnDefinition = "ENUM('LOW', 'MEDIUM', 'HIGH')")
    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_at;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updated_at;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Constructors">
    public TaskEntity() {}

    public TaskEntity(String title, String description, TaskStatusEnum status, TaskPriorityEnum priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }
    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Getters and setters">

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public TaskPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(TaskPriorityEnum priority) {
        this.priority = priority;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    //</editor-fold>
}
