package com.napier.sem;

/**
 * Class for a country report
 * @author Euan Holmes
 * @author Adam Riddell
 * @author Scott Darroch
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */
public class Country {
    //Private variables code, name, continent, region, population and capital.
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private String capital;

    //Constructor for country class.
    public Country(String code, String name, String continent, String region, int population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    //Getters and setters for private variables.
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    //toString() method for class.
    public String toString() {
        return String.format("%-5s %-48s %-20s %-30s %-15s %-15s", this.code, this.name, this.continent, this.region, this.population, this.capital);
    }
}
