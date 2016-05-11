package com.tolfel.springrest.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Олег on 09.05.2016.
 */
@Entity
public class Rate {
    private int id;
    private int idUser;
    private int idMatch;
    private int idPlayer;
    private int sum;
    private int idPaymentSystem;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_USER", nullable = false)
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "id_MATCH", nullable = false)
    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    @Basic
    @Column(name = "id_player", nullable = false)
    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    @Basic
    @Column(name = "sum", nullable = false, precision = 0)
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "id_payment_system", nullable = false)
    public int getIdPaymentSystem() {
        return idPaymentSystem;
    }

    public void setIdPaymentSystem(int idPaymentSystem) {
        this.idPaymentSystem = idPaymentSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        if (id != rate.id) return false;
        if (idUser != rate.idUser) return false;
        if (idMatch != rate.idMatch) return false;
        if (idPlayer != rate.idPlayer) return false;
        if (sum != rate.sum) return false;
        if (idPaymentSystem != rate.idPaymentSystem) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUser;
        result = 31 * result + idMatch;
        result = 31 * result + idPlayer;
        result = 31 * result + sum;
        result = 31 * result + idPaymentSystem;
        return result;
    }
}
