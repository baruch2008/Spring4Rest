package com.tolfel.springrest.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Олег on 09.05.2016.
 */
@Entity
public class Message {
    private int id;
    private int idAuthor;
    private String message;
    private Date date;
    private int idDiscussion;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_author", nullable = false)
    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Basic
    @Column(name = "message", nullable = false, length = 1000)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "id_discussion", nullable = false)
    public int getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(int idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (id != message1.id) return false;
        if (idAuthor != message1.idAuthor) return false;
        if (idDiscussion != message1.idDiscussion) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;
        if (date != null ? !date.equals(message1.date) : message1.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idAuthor;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idDiscussion;
        return result;
    }
}
