package com.cdz.mngmtrisk.cosmoevolution.entity;

import java.util.List;

import com.cdz.mngmtrisk.cosmoevolution.enums.EnumAccountStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account")
public class Account {

    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String pass;
    private EnumAccountStatus status;
    @Column(unique = true)
    private String nick;
    private int level;

    @OneToMany(mappedBy = "account")
    private List<Knight> knights;
    @OneToMany(mappedBy = "account")
    private List<Card> cards;

    // constructor
    public Account() {

    }

    public Account(Long id, String login, String pass, EnumAccountStatus status, String nick, int level) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.status = status;
        this.nick = nick;
        this.level = level;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public EnumAccountStatus getStatus() {
        return status;
    }

    public void setStatus(EnumAccountStatus status) {
        this.status = status;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
