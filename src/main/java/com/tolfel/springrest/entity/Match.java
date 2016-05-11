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
public class Match {
    private int id;
    private int idStage;
    private int idPlayerOne;
    private int idPlayerTwo;
    private Integer scorePlayerOne;
    private Integer scorePlayerTwo;
    private Date date;
    private Integer idDiscussion;
    private byte isPlayed;

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
    @Column(name = "id_player_one", nullable = false)
    public int getIdPlayerOne() {
        return idPlayerOne;
    }

    public void setIdPlayerOne(int idPlayerOne) {
        this.idPlayerOne = idPlayerOne;
    }

    @Basic
    @Column(name = "id_player_two", nullable = false)
    public int getIdPlayerTwo() {
        return idPlayerTwo;
    }

    public void setIdPlayerTwo(int idPlayerTwo) {
        this.idPlayerTwo = idPlayerTwo;
    }

    @Basic
    @Column(name = "score_player_one", nullable = true)
    public Integer getScorePlayerOne() {
        return scorePlayerOne;
    }

    public void setScorePlayerOne(Integer scorePlayerOne) {
        this.scorePlayerOne = scorePlayerOne;
    }

    @Basic
    @Column(name = "score_player_two", nullable = true)
    public Integer getScorePlayerTwo() {
        return scorePlayerTwo;
    }

    public void setScorePlayerTwo(Integer scorePlayerTwo) {
        this.scorePlayerTwo = scorePlayerTwo;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "id_discussion", nullable = true)
    public Integer getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(Integer idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    @Basic
    @Column(name = "is_played", nullable = false)
    public byte getIsPlayed() {
        return isPlayed;
    }

    public void setIsPlayed(byte isPlayed) {
        this.isPlayed = isPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (id != match.id) return false;
        if (idStage != match.idStage) return false;
        if (idPlayerOne != match.idPlayerOne) return false;
        if (idPlayerTwo != match.idPlayerTwo) return false;
        if (isPlayed != match.isPlayed) return false;
        if (scorePlayerOne != null ? !scorePlayerOne.equals(match.scorePlayerOne) : match.scorePlayerOne != null)
            return false;
        if (scorePlayerTwo != null ? !scorePlayerTwo.equals(match.scorePlayerTwo) : match.scorePlayerTwo != null)
            return false;
        if (date != null ? !date.equals(match.date) : match.date != null) return false;
        if (idDiscussion != null ? !idDiscussion.equals(match.idDiscussion) : match.idDiscussion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idStage;
        result = 31 * result + idPlayerOne;
        result = 31 * result + idPlayerTwo;
        result = 31 * result + (scorePlayerOne != null ? scorePlayerOne.hashCode() : 0);
        result = 31 * result + (scorePlayerTwo != null ? scorePlayerTwo.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (idDiscussion != null ? idDiscussion.hashCode() : 0);
        result = 31 * result + (int) isPlayed;
        return result;
    }
}
