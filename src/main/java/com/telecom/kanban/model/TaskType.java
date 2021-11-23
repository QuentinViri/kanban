package com.telecom.kanban.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class TaskType{

    @Id
    @GeneratedValue
    private Long id;
    private String label;

    @OneToMany(mappedBy = "taskType",cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public TaskType(String label) {
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
