package com.serverside.behappy.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PreparatoryTechnique {

    public PreparatoryTechnique() {
    }

    public PreparatoryTechnique(Integer id_user, Integer id_technique, Long date) {
        this.id_user = id_user;
        this.id_technique = id_technique;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id_user;
    private Integer id_technique;

    private Long date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_technique() {
        return id_technique;
    }

    public void setId_technique(Integer id_technique) {
        this.id_technique = id_technique;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
