package com.napier.sem;

/**
 * Class for a population report
 * @author Euan Holmes
 * @author Adam Riddell
 * @author Scott Darroch
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */
public class Population {
    //Private variables name, total population, total population in cities and total population not in cities.
    private String name;
    private long total_population;
    private int total_population_in_cities;
    private long total_population_not_in_cities;

    //Constructor for Population class.
    public Population(String name, long total_population, int total_population_in_cities, long total_population_not_in_cities) {
        this.name = name;
        this.total_population = total_population;
        this.total_population_in_cities = total_population_in_cities;
        this.total_population_not_in_cities = total_population_not_in_cities;
    }

    //Getters and setter for private variables.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotal_population() {
        return total_population;
    }

    public void setTotal_population(long total_population) {
        this.total_population = total_population;
    }

    public int getTotal_population_in_cities() {
        return total_population_in_cities;
    }

    public void setTotal_population_in_cities(int total_population_in_cities) {
        this.total_population_in_cities = total_population_in_cities;
    }

    public long getTotal_population_not_in_cities() {
        return total_population_not_in_cities;
    }

    public void setTotal_population_not_in_cities(long total_population_not_in_cities) {
        this.total_population_not_in_cities = total_population_not_in_cities;
    }

    //toString() method for class.
    @Override
    public String toString() {
        return String.format("%-40s %-18s %-18s %-12s", this.name, this.total_population, this.total_population_in_cities + " ("+ Math.round(((double)this.total_population_in_cities/(double)this.total_population)*100) + "%)", this.total_population_not_in_cities+ " ("+ Math.round(((double)this.total_population_not_in_cities/(double)this.total_population)*100)+"%)");
    }

}
