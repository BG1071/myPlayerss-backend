package com.example.myplayerss;

import javax.persistence.*;
import java.util.Date;

@Entity
public class myPlayers {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int number;
    private String name;
    private String surname;
    private Date birthdate;
    private String nationality;
    private int height;
    private int worth;
    private String club;
    private String url;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public int getHeight() {
        return height;
    }

    public int getWorth() {
        return worth;
    }

    public String getClub() {
        return club;
    }

    public String getUrl() {
        return url;
    }
}