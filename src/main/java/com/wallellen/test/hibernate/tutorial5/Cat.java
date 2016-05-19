package com.wallellen.test.hibernate.tutorial5;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.plaf.synth.ColorType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by <a href="mailto:wallellen@hotmail.com">WALLE</a> on 5/10/16.
 */
@Entity
@Table(name = "cats")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("C")
@DiscriminatorColumn(name = "subclass", discriminatorType = DiscriminatorType.CHAR)
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal weight;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date birthdate;
    @NotNull
    @Column(updatable = false)
    @Type(type = "com.wallellen.test.hibernate.tutorial5.DemoCat")
    private ColorType color;
    @NotNull
    @Column(updatable = false)
    private String sex;
    @Column(updatable = false)
    private Integer litterId;
    @ManyToOne
    @JoinColumn(name = "mother_id", updatable = false)
    private Cat mother;
    @OneToMany(mappedBy = "mother")
    @OrderBy("litterId")
    private Set<Cat> kittens = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLitterId() {
        return litterId;
    }

    public void setLitterId(Integer litterId) {
        this.litterId = litterId;
    }

    public Cat getMother() {
        return mother;
    }

    public void setMother(Cat mother) {
        this.mother = mother;
    }

    public Set<Cat> getKittens() {
        return kittens;
    }

    public void setKittens(Set<Cat> kittens) {
        this.kittens = kittens;
    }
}
