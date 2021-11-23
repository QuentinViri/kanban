package com.telecom.kanban.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ChangeLog {

    @Id
    @GeneratedValue
    private Long id;
    private Date occured;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Task task;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TaskStatus source;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private TaskStatus target;

    public ChangeLog(Date occured, Task task, TaskStatus source, TaskStatus target) {
        this.occured = occured;
        this.task = task;
        this.source = source;
        this.target = target;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOccured() {
        return occured;
    }

    public void setOccured(Date occured) {
        this.occured = occured;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskStatus getSource() {
        return source;
    }

    public void setSource(TaskStatus source) {
        this.source = source;
    }

    public TaskStatus getTarget() {
        return target;
    }

    public void setTarget(TaskStatus target) {
        this.target = target;
    }
}
