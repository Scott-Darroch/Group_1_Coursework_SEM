package com.napier.sem;

/**
 * Class for population report
 */
public class Population {

    /**
     * The name of the continent, region or country for this population.
     */
    public String name;

    /**
     * The total population of the continent, region or country for this population.
     */
    public long total_population;

    /**
     * The total population of the continent, region or country living in the cities(%).
     */
    public int total_population_in_cities;

    /**
     * The total population of the continent, region or country not living in cities(%).
     */
    public long total_population_not_in_cities;

    public String toString() {
        return String.format("%-40s %-12s %-8s %-12s", this.name, this.total_population, this.total_population_in_cities, this.total_population_not_in_cities);
    }

}
