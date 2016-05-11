package com.tolfel.springrest.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tournament", schema = "arena")
@NamedQuery(name = "findAllActualTournaments", query = "select t from Tournament t where t.endDate=null")
public class Tournament {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Basic
    @Column(name = "registration_date", nullable = true)
    private Date registrationDate;

    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;

    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @Basic
    @Column(name = "game", nullable = false, length = 45)
    private String game;

    @Basic
    @Column(name = "rules", nullable = false, length = 2500)
    private String rules;

    @Basic
    @Column(name = "id_discussion", nullable = false)
    private int idDiscussion;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Stage> stages = new HashSet<Stage>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getIdDiscussion() {
        return idDiscussion;
    }

    public void setIdDiscussion(int idDiscussion) {
        this.idDiscussion = idDiscussion;
    }

    public Set<Stage> getStages() {
        return stages;
    }

    public void setStages(Set<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        if (id != that.id) return false;
        if (stages != that.stages) return false;
        if (idDiscussion != that.idDiscussion) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (registrationDate != null ? !registrationDate.equals(that.registrationDate) : that.registrationDate != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (game != null ? !game.equals(that.game) : that.game != null) return false;
        if (rules != null ? !rules.equals(that.rules) : that.rules != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (game != null ? game.hashCode() : 0);
        result = 31 * result + stages.size();
        result = 31 * result + (rules != null ? rules.hashCode() : 0);
        result = 31 * result + idDiscussion;
        return result;
    }
}
