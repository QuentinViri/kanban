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



}
