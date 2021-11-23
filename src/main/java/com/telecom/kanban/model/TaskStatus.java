package com.telecom.kanban.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class TaskStatus{

    @Id
    @GeneratedValue
    private Long id;
    private String label;

    @ManyToMany(mappedBy = "taskStatus",cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public TaskStatus(String label) {
        this.label = label;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
