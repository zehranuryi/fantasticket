package com.codecrew.fantasticket.entity;

import com.codecrew.fantasticket.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseEntity {

    @Column(name = "icon")
    @JsonProperty(value = "icon")
    @NotEmpty
    private String icon;

    @Column(name = "title", nullable = false)
    @JsonProperty(value = "title")
    @NotEmpty
    private String title;

    @Column(name = "message", nullable = false)
    @JsonProperty(value = "message")
    @NotEmpty
    private String message;

    @Column(name = "date", nullable = false)
    @JsonProperty(value = "date")
    @NotNull
    private LocalDateTime date;
    
    @ManyToMany(mappedBy = "notifications")
    Set<User> users;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
