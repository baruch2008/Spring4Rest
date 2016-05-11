package com.tolfel.springrest.entity;

import javax.persistence.*;

/**
 * Created by Олег on 09.05.2016.
 */
@Entity
@Table(name = "stage_type", schema = "arena", catalog = "")
public class StageType {
    private int id;
    private String type;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StageType stageType = (StageType) o;

        if (id != stageType.id) return false;
        if (type != null ? !type.equals(stageType.type) : stageType.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
