package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class that contain all code for conducting unit tests.
 * @author Euan Holmes,
 * @author Adam Riddell,
 * @author Scott Darroch
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */

public class UnitTests {

    //City
    @Test
    void printPrintEmptyCityTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        System.out.println(cities);
    }

    @Test
    void printPrintNullCityTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        System.out.println(cities);
    }

    @Test
    void printCityTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(000, "Paris", "France", "Central France", 180);
        cities.add(city);
        System.out.println(city);
    }

    //Country


    @Test
    void printPrintEmptyCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        System.out.println(countries);
    }

    @Test
    void printPrintNullCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        System.out.println(countries);
    }

    @Test
    void printCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("GER","Germany","Europe","Central Europe",520000000,"Berlin");
        countries.add(country);
        System.out.println(country);
    }

    //Language


    @Test
    void printPrintEmptyLanguageTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        System.out.println(languages);
    }

    @Test
    void printPrintNullLanguageTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(null);
        System.out.println(languages);
    }

    @Test
    void printLangTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        Language language = new Language("English", 42, 10);
        languages.add(language);
        System.out.println(language);
    }

    //Population

    @Test
    void printPrintEmptyPopTest()
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
    void printPopTest()
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

    //Capital City

    @Test
    void printPrintEmptyCapitalTest()
    {
        ArrayList<CapitalCity> capcities = new ArrayList<>();
        System.out.println(capcities);
    }

    @Test
    void printPrintNullCapitalTest()
    {
        ArrayList<CapitalCity> capcities = new ArrayList<>();
        capcities.add(null);
        System.out.println(capcities);
    }
    @Test
    void printCapitalTest()
    {
        ArrayList<CapitalCity> capcities = new ArrayList<>();
        CapitalCity capcity = new CapitalCity("Paris", "France", 126583905);
        capcities.add(capcity);
        System.out.println(capcity);
    }
}
