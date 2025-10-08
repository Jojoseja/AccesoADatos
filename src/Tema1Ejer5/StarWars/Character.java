package Tema1Ejer5.StarWars;

import java.io.Externalizable;

public class Character{
    //Atributos
    private String name; //Nombre del Personaje
    private String gender;
    private String birth_year; //Año de Nacimiento
    private double height;
    private double mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String planet;
    private String species;

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", planet='" + planet + '\'' +
                ", species='" + species + '\'' +
                '}';
    }


    //Metodo que devuelve una String del personaje en formato csv
    public String toCSV(){
        return name+","+gender+","+birth_year+","+height+","+mass+","+hair_color+","+skin_color+","+eye_color+","+planet+","+species;
    }


    //Sobreescritura del metodo equals para que dos personajes sean identicos si tienen el mismo nombre
    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Character)obj).name);
    }
}
