package com.cdz.mngmtrisk.cosmoevolution.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_knight")
public class Knight {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int star;
    private int armor;
    private int constelation;
    private String imgUrl;

    // Constructor
    public Knight() {
    }

    public Knight(Long id, String name, int star, int armor, int constelation, String imgUrl) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.armor = armor;
        this.constelation = constelation;
        this.imgUrl = imgUrl;
    }

    // Getters and Setters

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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getConstelation() {
        return constelation;
    }

    public void setConstelation(int constelation) {
        this.constelation = constelation;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
