package com.serverside.behappy.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    public User() {
    }

    public User(String name, String email, Set<NegativeEmotionsPast> negativeEmotionsPasts, Set<PreparatoryTechnique> preparatoryTechniques, String password, Integer dateOfBirth) {
        this.name = name;
        this.email = email;
        this.negativeEmotionsPasts = negativeEmotionsPasts;
        this.preparatoryTechniques = preparatoryTechniques;
        this.password = password;
        this.DateOfBirth = dateOfBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Integer DateOfBirth;

    @OneToMany(mappedBy = "id_user")
    private Set<NegativeEmotionsPast> negativeEmotionsPasts;

    @OneToMany(mappedBy = "id_user")
    private Set<PreparatoryTechnique> preparatoryTechniques;

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

    public Integer getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Set<NegativeEmotionsPast> getNegativeEmotionsPasts() {
        return negativeEmotionsPasts;
    }

    public void setNegativeEmotionsPasts(Set<NegativeEmotionsPast> negativeEmotionsPasts) {
        this.negativeEmotionsPasts = negativeEmotionsPasts;
    }

    public Set<PreparatoryTechnique> getPreparatoryTechniques() {
        return preparatoryTechniques;
    }

    public void setPreparatoryTechniques(Set<PreparatoryTechnique> preparatoryTechniques) {
        this.preparatoryTechniques = preparatoryTechniques;
    }
}
