package com.serverside.behappy.models;


import javax.persistence.*;

@Entity
public class NegativeEmotionsPast {

    public NegativeEmotionsPast() {
    }

    public NegativeEmotionsPast(Integer id_user, Integer year, Integer month, Integer date) {
        this.id_user = id_user;
        this.year = year;
        this.month = month;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer id_user,
                    year,
                    month,
                    date;


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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
