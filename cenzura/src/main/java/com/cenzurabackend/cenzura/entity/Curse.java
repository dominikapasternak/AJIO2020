package com.cenzurabackend.cenzura.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Curse {

    @Id
    @GeneratedValue
    Integer id;

    String curse;

    public Curse() {
    }

    public Curse(String curse) {
        this.curse = curse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
    }
}
