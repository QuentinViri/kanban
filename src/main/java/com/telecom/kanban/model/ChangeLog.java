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

}
