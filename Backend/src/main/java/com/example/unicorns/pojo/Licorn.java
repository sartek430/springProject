package com.example.unicorns.pojo;

public class Licorn {
    private Integer type;
    private String name;
    private String color;
    private Float price;
    private Float horn_size;
    private String description;
    private Float max_speed;
    private String spell;
    private Integer power;

    public Licorn(Integer type, String name, String color, Float price, Float horn_size, String description, Float max_speed, String spell, Integer power) {
        this.type = type;
        this.name = name;
        this.color = color;
        this.price = price;
        this.horn_size = horn_size;
        this.description = description;
        this.max_speed = max_speed;
        this.spell = spell;
        this.power = power;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getHorn_size() {
        return horn_size;
    }

    public void setHorn_size(Float horn_size) {
        this.horn_size = horn_size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(Float max_speed) {
        this.max_speed = max_speed;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}