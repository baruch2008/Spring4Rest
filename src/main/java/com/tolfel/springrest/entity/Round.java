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
public class Round {
    private int id;
    private int idStage;
    private int round;
    private String description;
    private int bestOf;
    private Date deadline;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_STAGE", nullable = false)
    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    @Basic
    @Column(name = "round", nullable = false)
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "best_of", nullable = false)
    public int getBestOf() {
        return bestOf;
    }

    public void setBestOf(int bestOf) {
        this.bestOf = bestOf;
    }

    @Basic
    @Column(name = "deadline", nullable = false)
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Round round1 = (Round) o;

        if (id != round1.id) return false;
        if (idStage != round1.idStage) return false;
        if (round != round1.round) return false;
        if (bestOf != round1.bestOf) return false;
        if (description != null ? !description.equals(round1.description) : round1.description != null) return false;
        if (deadline != null ? !deadline.equals(round1.deadline) : round1.deadline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idStage;
        result = 31 * result + round;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + bestOf;
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        return result;
    }
}
