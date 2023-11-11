package com.cdz.mngmtrisk.cosmoevolution.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_knight")
public class Knight {

    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int star;
    private int cloth;
    private int constelation;
    private String imgUrl;
    private String classe;
    private String element;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // constructor
    public Knight() {
    }

    public Knight(Long id, String name, int star, int cloth, int constelation, String imgUrl, String classe,
            String element) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.cloth = cloth;
        this.constelation = constelation;
        this.imgUrl = imgUrl;
        this.classe = classe;
        this.element = element;
    }

    // getter and setter
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

    public int getCloth() {
        return cloth;
    }

    public void setCloth(int cloth) {
        this.cloth = cloth;
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

}
