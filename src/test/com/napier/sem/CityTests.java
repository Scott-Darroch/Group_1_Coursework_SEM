package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CityTests {

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
        city.district = ("?");
        city.population = (180);
        cities.add(city);
        System.out.println(city);
    }
}