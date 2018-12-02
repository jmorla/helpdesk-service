package com.oym.helpdesk.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Task> ownerTask;

    @OneToMany(mappedBy = "assigned")
    private Set<Task> assignedTask;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getOwnerTask() {
        return ownerTask;
    }

    public void setOwnerTask(Set<Task> ownerTask) {
        this.ownerTask = ownerTask;
    }

    public Set<Task> getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(Set<Task> asignedTask) {
        this.assignedTask = asignedTask;
    }
}
