package Tema1Ejer5.StarWars;

import java.text.DecimalFormat;

public class Characters {
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

    public Characters() {
    }

    public Characters(String name, String gender, String birth_year, double height, double mass, String hair_color, String skin_color, String eye_color, String planet, String species) {
        this.name = name;
        this.gender = gender;
        this.birth_year = birth_year;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.planet = planet;
        this.species = species;
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
        //Formato para eliminar los .0 pero mantener los decimales de aquellos que no sean .0
        DecimalFormat df = new DecimalFormat("#.##");
        String heightText = df.format(this.getHeight());
        String massText = df.format(this.getMass());

        return "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Birth Year: " + birth_year + "\n" +
                "Height: "+ heightText + "\n" +
                "Mass: " + massText + "\n" +
                "Hair Color: " + hair_color + "\n" +
                "Skin Color: " + skin_color + "\n" +
                "Eye color: " + eye_color + "\n" +
                "Planet: " + planet + "\n" +
                "Species: " + species;
    }


    //Metodo que devuelve una String del personaje en formato csv
    public String toCSV(){
        //Formato para eliminar los .0 pero mantener los decimales de aquellos que no sean .0
        DecimalFormat df = new DecimalFormat("#.##");
        String heightText = df.format(this.getHeight());
        String massText = df.format(this.getMass());

        return name+","+gender+","+birth_year+","+heightText+","+massText+","+hair_color+","+skin_color+","+eye_color+","+planet+","+species;
    }


    //Sobreescritura del metodo equals para que dos personajes sean identicos si tienen el mismo nombre
    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Characters)obj).name);
    }
}
