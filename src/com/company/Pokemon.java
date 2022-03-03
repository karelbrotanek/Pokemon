package com.company;

public class Pokemon {
    private String name;
    private String typ;
    private String typDva;
    private int HP;
    private int attack;
    private int generace;
    private boolean legendarni;


    public Pokemon(String name, String typ, String typDva, int HP, int generace, boolean legendarni, int attack) {
        this.name = name;
        this.typ = typ;
        this.typDva = typDva;
        this.HP = HP;
        this.attack = attack;
        this.generace = generace;
        this.legendarni = legendarni;
    }

    public String getName() {
        return name;
    }

    public String getTyp() {
        return typ;
    }

    public String getTypDva() {
        return typDva;
    }

    public int getHP() {
        return HP;
    }

    public int getAttack() {
        return attack;
    }

    public int getGenerace() {
        return generace;
    }

    public boolean isLegendarni() {
        return legendarni;
    }


}
