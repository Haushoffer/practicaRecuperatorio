package edu.ucbcba.taller.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by coreI7 on 30/04/2017.
 */
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Double lat;

    @NotNull
    private Double lng;

    private Integer likes = 0;

    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}
