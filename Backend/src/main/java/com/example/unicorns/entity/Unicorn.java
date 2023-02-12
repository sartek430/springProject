package com.example.unicorns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unicorns")
public class Unicorn {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int type;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private float price;

    @Column
    private float horn_size;

    @Column
    private String description;

    @Column
    private float max_speed;

    @Column
    private String spell;

    @Column
    private int power;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getHorn_size() {
        return horn_size;
    }

    public void setHorn_size(float horn_size) {
        this.horn_size = horn_size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(float max_speed) {
        this.max_speed = max_speed;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
