package com.napier.sem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Class that contain all code for conducting unit tests.
 * @author Euan Holmes,
 * @author Adam Riddell,
 * @author Scott Darroch,
 * @author Robert Denny
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */

public class UnitTests {

    //City
    @Test
    void printPrintEmptyCityTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        out.println(cities);
        String expected = "[]";
        String result = String.valueOf(cities);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printPrintNullCityTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        out.println(cities);
        String expected = "[null]";
        String result = String.valueOf(cities);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printCityTest()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City(42, "Paris", "France", "Central France", 180);
        cities.add(city);
        out.println(city);
        String expected = "[42       Paris                          France   Central France                 180       ]";
        String result = String.valueOf(cities);
        assertEquals(expected, result, "This asserts that ");
    }

    //Country


    @Test
    void printPrintEmptyCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        out.println(countries);
        String expected = "[]";
        String result = String.valueOf(countries);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printPrintNullCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        out.println(countries);
        String expected = "[null]";
        String result = String.valueOf(countries);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printCountryTest()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country("GER","Germany","Europe","Central Europe",520000000,"Berlin");
        countries.add(country);
        out.println(country);
        String expected = "[GER   Germany                                          Europe               Central Europe                 520000000       Berlin         ]";
        String result = String.valueOf(countries);
        assertEquals(expected, result, "This asserts that ");
    }

    //Language


    @Test
    void printPrintEmptyLanguageTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        out.println(languages);
        String expected = "[]";
        String result = String.valueOf(languages);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printPrintNullLanguageTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(null);
        out.println(languages);
        String expected = "[null]";
        String result = String.valueOf(languages);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printLangTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        Language language = new Language("English", 42, 10);
        languages.add(language);
        out.println(language);
        String expected = "[English                         42                                       10                       ]";
        String result = String.valueOf(languages);
        assertEquals(expected, result, "This asserts that ");
    }

    //Population

    @Test
    void printPrintEmptyPopTest()
    {
        ArrayList<Population> populations = new ArrayList<>();
        out.println(populations);
        String expected = "[]";
        String result = String.valueOf(populations);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printPrintNullPopulationTest()
    {
        ArrayList<Population> populations = new ArrayList<>();
        populations.add(null);
        out.println(populations);
        String expected = "[null]";
        String result = String.valueOf(populations);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printPopTest()
    {
        ArrayList<Population> populations = new ArrayList<>();
        Population population = new Population("France",42,12,30);
        populations.add(population);
        out.println(population);
        String expected = "[France                                   42                 12 (29%)           30 (71%)    ]";
        String result = String.valueOf(populations);
        assertEquals(expected, result, "This asserts that ");
    }

    //Capital City

    @Test
    void printPrintEmptyCapitalTest()
    {
        ArrayList<CapitalCity> capcities = new ArrayList<>();
        out.println(capcities);
        String expected = "[]";
        String result = String.valueOf(capcities);
        assertEquals(expected, result, "This asserts that ");
    }

    @Test
    void printPrintNullCapitalTest()
    {
        ArrayList<CapitalCity> capcities = new ArrayList<>();
        capcities.add(null);
        out.println(capcities);
        String expected = "[null]";
        String result = String.valueOf(capcities);
        assertEquals(expected, result, "This asserts that ");
    }
    @Test
    void printCapitalTest()
    {
        ArrayList<CapitalCity> capcities = new ArrayList<>();
        CapitalCity capcity = new CapitalCity("Paris", "France", 126583905);
        capcities.add(capcity);
        out.println(capcity);
        String expected = "[Paris                          France 126583905      ]";
        String result = String.valueOf(capcities);
        assertEquals(expected, result, "This asserts that ");
    }
}
