package com.telecom.kanban.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer nbHoursForecast;
    private Integer nbHoursReal;
    private Date created;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TaskType taskType;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TaskStatus taskStatus;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<Developer> developers;

    @ManyToMany(mappedBy = "task", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<ChangeLog> changeLogs;

    public Task(String title, Integer nbHoursForecast, Integer nbHoursReal, Date created) {
        this.title = title;
        this.nbHoursForecast = nbHoursForecast;
        this.nbHoursReal = nbHoursReal;
        this.created = created;
        this.developers = new HashSet<>();
    }

    public Boolean addDeveloper(Developer developer) {
        return developers.add(developer);
    }


}
