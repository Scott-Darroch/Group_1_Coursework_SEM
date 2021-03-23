package com.napier.sem;

/**
 * Class for a capital city report
 */
public class CapitalCity {
    //Private variables for name, country and population.
    private String name;
    private String country;
    private int population;

    //Constructor for the capital city class.
    public CapitalCity(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    //Getters and setters for all the private variables.
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    //toString method for the class.
    public String toString() {
        return String.format("%-30s %-5s %-15s", this.name, this.country, this.population);
    }
}
