package com.example.Backend.pojo;

import javax.persistence.*;

@Entity

public class Unicorn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    private Integer poid;

    public Unicorn() {
    }

    public Unicorn(String libelle, Integer poid) {
        this.libelle = libelle;
        this.poid = poid;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
