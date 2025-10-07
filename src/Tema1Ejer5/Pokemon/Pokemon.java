package Tema1Ejer5.Pokemon;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergio Cuesta
 */

import Tema1Ejer5.Pokemon.excepciones.InvalidNumber;

import java.io.*;

public class Pokemon implements Externalizable {
    @Serial
    private static final long serialVersionUID = 1L;

    String name;
    int level;
    int life;
    int attack;
    int defense;
    int specialAttack;
    int specialDefense;
    int speed;

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws InvalidNumber {
        if (level < 0 || level > 100) {
            throw new InvalidNumber("Invalid level");
        } else {
            this.level = level;
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) throws InvalidNumber{
        if (life < 0 || life > 255) {
            throw new InvalidNumber("Invalid life");
        } else {
            this.life = life;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0 || attack > 255) {
            throw new InvalidNumber("Invalid attacks");
        } else {
            this.attack = attack;
        }
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if  (defense < 0 || defense > 255) {
            throw new InvalidNumber("Invalid defense");
        } else  {
            this.defense = defense;
        }
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        if (specialAttack < 0 || specialAttack > 255) {
            throw new InvalidNumber("Invalid special attacks");
        } else {
            this.specialAttack = specialAttack;
        }
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        if  (specialDefense < 0 || specialDefense > 255) {
            throw new InvalidNumber("Invalid special defense");
        } else {
            this.specialDefense = specialDefense;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if  (speed < 0 || speed > 255) {
            throw new InvalidNumber("Invalid speed");
        } else {
            this.speed = speed;
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(level);
        out.writeInt(life);
        out.writeInt(attack);
        out.writeInt(defense);
        out.writeInt(specialAttack);
        out.writeInt(specialDefense);
        out.writeInt(speed);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.level = in.readInt();
        this.life = in.readInt();
        this.attack = in.readInt();
        this.defense = in.readInt();
        this.specialAttack = in.readInt();
        this.specialDefense = in.readInt();
        this.speed = in.readInt();
    }
}
