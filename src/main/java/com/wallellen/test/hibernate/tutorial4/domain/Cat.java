package com.wallellen.test.hibernate.tutorial4.domain;

import java.awt.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
public class Cat {
    private Long id;
    private Date birthday;
    private Color color;
    private char sex;
    private float weight;
    private int litterId;
    private Cat mother;
    private Set kittens = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getLitterId() {
        return litterId;
    }

    public void setLitterId(int litterId) {
        this.litterId = litterId;
    }

    public Cat getMother() {
        return mother;
    }

    public void setMother(Cat mother) {
        this.mother = mother;
    }

    public Set getKittens() {
        return kittens;
    }

    public void setKittens(Set kittens) {
        this.kittens = kittens;
    }

    public void addKitten(Cat cat) {
        cat.setMother(this);
        cat.setLitterId(kittens.size());
        addKitten(cat);
    }
}
