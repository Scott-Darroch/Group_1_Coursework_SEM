package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class CountryTests {

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
}