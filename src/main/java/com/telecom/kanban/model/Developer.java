package com.telecom.kanban.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Developer {


    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String password;

    @Column(unique = true)
    private String email;
    private Date startContact;

    @ManyToMany(mappedBy = "developers", cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public Developer(String firstname, String lastname, String password, String email, Date startContact) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.startContact = startContact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartContact() {
        return startContact;
    }

    public void setStartContact(Date startContact) {
        this.startContact = startContact;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
