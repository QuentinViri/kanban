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

}
