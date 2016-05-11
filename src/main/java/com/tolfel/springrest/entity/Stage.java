package com.tolfel.springrest.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Олег on 09.05.2016.
 */
@Entity
public class Stage {
    private int id;
    private int idTournament;
    private int stage;
    private int idStageType;
    private int goToNextStage;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_TOURNAMENT", nullable = false)
    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    @Basic
    @Column(name = "stage", nullable = false)
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    @Basic
    @Column(name = "id_STAGE_TYPE", nullable = false)
    public int getIdStageType() {
        return idStageType;
    }

    public void setIdStageType(int idStageType) {
        this.idStageType = idStageType;
    }

    @Basic
    @Column(name = "go_to_next_stage", nullable = false)
    public int getGoToNextStage() {
        return goToNextStage;
    }

    public void setGoToNextStage(int goToNextStage) {
        this.goToNextStage = goToNextStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage1 = (Stage) o;

        if (id != stage1.id) return false;
        if (idTournament != stage1.idTournament) return false;
        if (stage != stage1.stage) return false;
        if (idStageType != stage1.idStageType) return false;
        if (goToNextStage != stage1.goToNextStage) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idTournament;
        result = 31 * result + stage;
        result = 31 * result + idStageType;
        result = 31 * result + goToNextStage;
        return result;
    }
}
