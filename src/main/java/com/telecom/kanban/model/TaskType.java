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


}
