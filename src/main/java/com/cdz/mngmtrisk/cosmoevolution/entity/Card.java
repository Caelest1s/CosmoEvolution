package com.cdz.mngmtrisk.cosmoevolution.entity;

import com.cdz.mngmtrisk.cosmoevolution.enums.EnumCardColor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_card")
public class Card {

    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private EnumCardColor color;
    private byte star;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // constructor
    public Card() {
    }

    public Card(Long id, String name, EnumCardColor color, byte star) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.star = star;
    }

    // getters and setters
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

    public EnumCardColor getColor() {
        return color;
    }

    public void setColor(EnumCardColor color) {
        this.color = color;
    }

    public byte getStar() {
        return star;
    }

    public void setStar(byte star) {
        this.star = star;
    }

}
