package com.napier.sem;

/**
 * Class for a country report
 */
public class City {


    /**
     * The city's ID
     */
    public int ID;

    /**
     * The city's name
     */
    public String name;

    /**
     * The city's country
     */
    public String country;

    /**
     * The city's district
     */
    public String district;

    /**
     * The city's population
     */
    public int population;

    public String toString() {
        return String.format("%-5s %-48s %-20s %-30s %-15s", this.ID, this.name, this.country, this.district, this.population);
    }
}
