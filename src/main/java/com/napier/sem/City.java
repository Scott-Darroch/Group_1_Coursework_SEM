package com.napier.sem;

/**
 * Class for a city report
 */
public class City {
    //private variables for ID, name, country, district and population.
    private int ID;
    private String name;
    private String country;
    private String district;
    private int population;

    //Constructor for City class.
    public City(int ID, String name, String country, String district, int population) {
        this.ID = ID;
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    //Getters and setters for private variables.
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    //toString method for class.
    public String toString() {
        return String.format("%-5s %-30s %-5s %-25s %-15s", this.ID, this.name, this.country, this.district, this.population);
    }
}
