package com.tolfel.springrest.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "arena")
@NamedQuery(name = "findAllMatchesOfUser", query = "select m from Match m where m.idPlayerOne=:id or m.idPlayerTwo=:id")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "steam_url", nullable = false, length = 100)
    private String steamUrl;
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_USER_PROFILE",
            joinColumns = { @JoinColumn(name = "id_USER") },
            inverseJoinColumns = { @JoinColumn(name = "id_USER_PROFILE") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_TOURNAMENT",
            joinColumns = { @JoinColumn(name = "id_USER") },
            inverseJoinColumns = { @JoinColumn(name = "id_TOURNAMENT") })
    private Set<Tournament> tournaments = new HashSet<Tournament>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSteamUrl() {
        return steamUrl;
    }

    public void setSteamUrl(String steamUrl) {
        this.steamUrl = steamUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (rating != that.rating) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (steamUrl != null ? !steamUrl.equals(that.steamUrl) : that.steamUrl != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (steamUrl != null ? steamUrl.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }
}