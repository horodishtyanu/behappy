package com.serverside.behappy.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    public User() {
    }

    public User(String name, String email, Set<NegativeEmotionsPast> negative_emotions_pasts, Set<PreparatoryTechnique> preparatory_techniques, String password, Long date_of_birth) {
        this.name = name;
        this.email = email;
        this.negative_emotions_pasts = negative_emotions_pasts;
        this.preparatory_techniques = preparatory_techniques;
        this.password = password;
        this.date_of_birth = date_of_birth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Long date_of_birth;

    @OneToMany(mappedBy = "id_user")
    private Set<NegativeEmotionsPast> negative_emotions_pasts;

    @OneToMany(mappedBy = "id_user")
    private Set<PreparatoryTechnique> preparatory_techniques;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Long date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Set<NegativeEmotionsPast> getNegative_emotions_pasts() {
        return negative_emotions_pasts;
    }

    public void setNegative_emotions_pasts(Set<NegativeEmotionsPast> negative_emotions_pasts) {
        this.negative_emotions_pasts = negative_emotions_pasts;
    }

    public Set<PreparatoryTechnique> getPreparatory_techniques() {
        return preparatory_techniques;
    }

    public void setPreparatory_techniques(Set<PreparatoryTechnique> preparatory_techniques) {
        this.preparatory_techniques = preparatory_techniques;
    }
}
