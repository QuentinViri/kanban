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

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private TaskType taskType;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private TaskStatus taskStatus;

    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private Set<Developer> developers;

    @ManyToMany(mappedBy ="task",cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private List<ChangeLog> changeLogs;

    public Task(String title, Integer nbHoursForecast, Integer nbHoursReal, Date created) {
        this.title = title;
        this.nbHoursForecast = nbHoursForecast;
        this.nbHoursReal = nbHoursReal;
        this.created = created;
        this.developers = new HashSet<>();
    }

    public Boolean addDeveloper(Developer developer){return developers.add(developer);}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbHoursForecast() {
        return nbHoursForecast;
    }

    public void setNbHoursForecast(Integer nbHoursForecast) {
        this.nbHoursForecast = nbHoursForecast;
    }

    public Integer getNbHoursReal() {
        return nbHoursReal;
    }

    public void setNbHoursReal(Integer nbHoursReal) {
        this.nbHoursReal = nbHoursReal;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public List<ChangeLog> getChangeLogs() {
        return changeLogs;
    }

    public void setChangeLogs(List<ChangeLog> changeLogs) {
        this.changeLogs = changeLogs;
    }
}
