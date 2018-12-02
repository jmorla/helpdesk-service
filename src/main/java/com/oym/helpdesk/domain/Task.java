package com.oym.helpdesk.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @Column(name = "TASK_ID")
    private String id;

    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createAt;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "ASSIGNED_ID")
    private User assigned;

//    @ManyToOne
//    @JoinColumn(name = "TYPE")
//    private TaskType type;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assined) {
        this.assigned = assined;
    }

//    public TaskType getType() {
//        return type;
//    }
//
//    public void setType(TaskType type) {
//        this.type = type;
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", status=" + status +
                '}';
    }
}
