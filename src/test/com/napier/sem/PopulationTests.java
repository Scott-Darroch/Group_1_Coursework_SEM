package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class PopulationTests {

    static App app;

    @BeforeAll
    static void init()
    {
        // Init new instances of App & DbConnection
        app = new App();

    }

    @Test
    void printPrintEmptyCountryTest()
    {
        ArrayList<Population> populations = new ArrayList<>();
        System.out.println(populations);
    }

    @Test
    void printPrintNullPopulationTest()
    {
        ArrayList<Population> populations = new ArrayList<>();
        populations.add(null);
        System.out.println(populations);
    }

    @Test
    void printCityTest()
    {
        ArrayList<Population> populations = new ArrayList<>();
        Population population = new Population();
        population.name = ("France");
        population.total_population = (42);
        population.total_population_in_cities = (12);
        population.total_population_not_in_cities = (30);
        populations.add(population);
        System.out.println(population);
    }
}