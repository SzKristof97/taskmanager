package me.szkristof.taskmanagerapi.models;

import java.sql.Timestamp;

public class TaskEntity {

    //<editor-fold default-state="collapsed" desc="Private fields">

    private int ID;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Timestamp created_at;
    private Timestamp updated_at;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Constructors">
    public TaskEntity() {}

    public TaskEntity(int ID, String title, String description, String status, String priority, Timestamp created_at, Timestamp updated_at) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
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