package com.brscout.brscout.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "player_stats")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamName;
    private int number;
    private String nation;
    private String position;
    private Integer age;

    public PlayerModel() {
    }

    public PlayerModel(String name, String teamName, int number, String nation, String position, Integer age) {
        this.name = name;
        this.teamName = teamName;
        this.number = number;
        this.nation = nation;
        this.position = position;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
