package com.napier.sem;

/**
 * Class for a capital city report
 */
public class CapitalCity {

    /**
     * The capital city's name
     */
    public String name;

    /**
     * The capital city's country
     */
    public String country;

    /**
     * The capital city's population
     */
    public int population;

    public String toString() {
        return String.format("%-30s %-5s %-15s", this.name, this.country, this.population);
    }
}
