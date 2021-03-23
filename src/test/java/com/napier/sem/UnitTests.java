package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        City city = new City();
        city.ID = (000);
        city.name = ("Paris");
        city.country = ("France");
        city.district = ("Central France");
        city.population = (180);
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
        Country country = new Country();
        country.code = ("GER");
        country.name = ("Germany");
        country.continent = ("Europe");
        country.region = ("Central Europe");
        country.population = (520000000);
        country.capital= ("Berlin");
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
        Language language = new Language();
        language.name = ("English");
        language.language_num = (42);
        language.language_percent = (10);
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
}
