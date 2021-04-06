package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Class that contain all code for conducting integration tests for the project.
 * @author Euan Holmes,
 * @author Adam Riddell,
 * @author Scott Darroch
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */

public class IntegrationTests {

    static App app;
    static SQL sql;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
        sql = new SQL(app.getCon());
    }

    // A test to prove that the report1 function gets a report showing all the countries in the world in order
    // of largest to smallest population.
    @Test
    void testReport1()
    {
        int countries_expected_length = 232;
        int countries_length = sql.report1().size();
        assertEquals(countries_expected_length, countries_length, "This asserts that the whole countries " +
                "array is returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report2 function gets a report showing all the countries in Africa in order of
    // of largest to smallest population.
    @Test
    void testReport2()
    {
        int countries_expected_length = 57;
        int countries_length = sql.report2().size();
        assertEquals(countries_expected_length, countries_length, "This asserts that the whole countries " +
                "array is returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report3 function gets a report showing all the countries in the Caribbean in
    // order of largest to smallest population.
    @Test
    void testReport3()
    {
        int countries_expected_length = 24;
        int countries_length = sql.report3().size();
        assertEquals(countries_expected_length, countries_length, "This asserts that the whole countries " +
                "array is returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report7 function gets a report showing all the cities in the world in order of
    // of largest to smallest population.
    @Test
    void testReport7()
    {
        int cities_expected_length = 4079;
        int cities_length = sql.report7().size();
        assertEquals(cities_expected_length, cities_length , "This asserts that the whole cities array is " +
                "returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report8 function gets a report showing all the cities in the world in order of
    // of largest to smallest population.
    @Test
    void testReport8()
    {
        int cities_expected_length = 1766;
        int cities_length = sql.report8().size();
        assertEquals(cities_expected_length, cities_length , "This asserts that the whole cities array is " +
                "returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report9 function gets a report showing all the cities in the world in order of
    // of largest to smallest population.
    @Test
    void testReport9()
    {
        int cities_expected_length = 58;
        int cities_length = sql.report9().size();
        assertEquals(cities_expected_length, cities_length , "This asserts that the whole cities array is " +
                "returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report10 function gets a report showing all the cities in the world in order of
    // of largest to smallest population.
    @Test
    void testReport10()
    {
        int cities_expected_length = 40;
        int cities_length = sql.report10().size();
        assertEquals(cities_expected_length, cities_length , "This asserts that the whole cities array is " +
                "returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report11 function gets a report showing all the cities in the world in order of
    // of largest to smallest population.
    @Test
    void testReport11()
    {
        int cities_expected_length = 4;
        int cities_length = sql.report11().size();
        assertEquals(cities_expected_length, cities_length , "This asserts that the whole cities array is " +
                "returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report12 function gets a report showing the top N populated cities in the world.
    @Test
    void testReport12()
    {
        int city_expected_population = 10500000;
        int city_population = sql.report12().get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first city in the ArrayLists" +
                "population is correct by checking against the hardcoded expected population of that city.");
    }

    // A test to prove that the report13 function gets a report showing the top N populated cities in a continent.
    @Test
    void testReport13()
    {
        int city_expected_population = 8591309;
        int city_population = sql.report13().get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that city.");
    }

    // A test to prove that the report14 function gets a report showing the top N populated cities in a region.
    @Test
    void testReport14()
    {
        int city_expected_population = 2879052;
        int city_population = sql.report14().get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that city.");
    }

    // A test to prove that the report15 function gets a report showing the top N populated cities in a country.
    @Test
    void testReport15()
    {
        int city_expected_population = 7980230;
        int city_population = sql.report15().get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that city.");
    }

    // A test to prove that the report16 function gets a report showing the top N populated cities in a district.
    @Test
    void testReport16()
    {
        int city_expected_population = 201843;
        int city_population = sql.report16(5).get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that city.");
    }

    // A test to prove that the report17 function gets a report showing all the capital cities in the
    // world organised by largest population to smallest.
    @Test
    void testReport17()
    {
        int capital_cities_expected_length = 232;
        int capital_cities_length = sql.report17().size();
        assertEquals(capital_cities_expected_length, capital_cities_length, "This asserts that the whole capital cities " +
                "array is returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report18 function gets a report showing all the capital cities in a
    // continent organised by largest population to smallest.
    @Test
    void testReport18()
    {
        int capital_cities_expected_length = 841;
        int capital_cities_length = sql.report18().size();
        assertEquals(capital_cities_expected_length, capital_cities_length, "This asserts that the whole capital cities " +
                "array is returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report19 function gets a report showing all the capital cities in a
    // region organised by largest population to smallest.
    @Test
    void testReport19()
    {
        int capital_cities_expected_length = 58;
        int capital_cities_length = sql.report19().size();
        assertEquals(capital_cities_expected_length, capital_cities_length, "This asserts that the whole capital cities " +
                "array is returned by checking the actual length returned against the hardcoded expected length.");
    }

    // A test to prove that the report20 function gets a report showing the top N populated capital cities in the world.
    @Test
    void testReport20()
    {
        int city_expected_population = 9981619;
        int city_population = sql.report20(5).get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first capital city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that capital city.");
    }

    // A test to prove that the report21 function gets a report showing the top N populated capital cities in a continent.
    @Test
    void testReport21()
    {
        int city_expected_population = 8389200;
        int city_population = sql.report21(5).get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first capital city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that capital city.");
    }

    // A test to prove that the report22 function gets a report showing the top N populated capital cities in a region.
    @Test
    void testReport22()
    {
        int city_expected_population = 2256000;
        int city_population = sql.report22(5).get(0).getPopulation();
        assertEquals(city_expected_population, city_population, "This asserts that the first capital city in the ArrayLists" +
                "population is correct by checking it against the hardcoded expected population of that capital city.");
    }

    // A test to prove that the report23 function gets a report showing the population of each continent that
    // are living in cities and not living in cities.
    @Test
    void testReport23()
    {
        long expected_asia_pop = 900937599400L;
        long actual_asia_pop = sql.report23().get(0).getTotal_population();
        assertEquals(expected_asia_pop, actual_asia_pop, "This asserts that the Asia total population generated by the" +
                "function is the same as the hardcoded expected value.");

    }

    // A test to prove that the report24 function gets a report showing the population of each region that
    // are living in cities and not living in cities.
    @Test
    void testReport24()
    {
        long expected_southern_and_central_asia_pop = 363665421000L;
        long actual_southern_and_central_asia_pop = sql.report24().get(0).getTotal_population();
        assertEquals(expected_southern_and_central_asia_pop, actual_southern_and_central_asia_pop, "This asserts that the " +
                "Southern and Central Asia total population generated by the function is the same as the hardcoded expected value.");

    }

    // A test to prove that the report25 function gets a report showing the population of each country that
    // are living in cities and not living in cities.
    @Test
    void testReport25()
    {
        long expected_afghanistan_pop = 90880000;
        long actual_afghanistan_pop = sql.report25().get(0).getTotal_population();
        assertEquals(expected_afghanistan_pop, actual_afghanistan_pop, "This asserts that the Afghanistan total population generated by the" +
                "function is the same as the hardcoded expected value.");
    }

    // A test to prove that the getworldpopulation method correctly gets the world population from the database.
    @Test
    void testGetWorldPopulation()
    {
        long testPop = 6078749450L;
        long worldPop = sql.report26();
        assertEquals(testPop, worldPop);
    }

    // A test to prove that the getcontinentpopulation method correctly gets the continent population from the database.
    @Test
    void testGetContinentPopulation()
    {
        int testpop = 730074600;
        int continentpop = sql.report27();
        assertEquals(testpop, continentpop);
    }

    // A test to prove that the getregionpopulation method correctly gets the region population from the database.
    @Test
    void testGetRegionPopulation()
    {
        int testpop = 38140000;
        int regionpop = sql.report28();
        assertEquals(testpop, regionpop);
    }

    // A test to prove that the getcountrypopulation method correctly gets the country population from the database.
    @Test
    void testGetCountryPopulation()
    {
        int testpop = 39441700;
        int countrypop = sql.report29();
        assertEquals(testpop, countrypop);
    }

    // A test to prove that the getcitypopulation method correctly gets the city population from the database
    @Test
    void testGetCityPopulation()
    {
        int testpop = 3993949;
        int citypop = sql.report30();
        assertEquals(testpop, citypop);
    }

    // A test to prove that the report31 function correctly gets the city population from the database.
    @Test
    void testReport31()
    {
        int testpop = 450180;
        int citypop = sql.report31();
        assertEquals(testpop, citypop, "This asserts that the city population generated is the same as the " +
                "hardcoded expected output.");
    }

    // A test to prove that the report32 function correctly gets the number of people who speak Chinese, Arabic,
    // English, Hindi and Spanish from greatest number to smallest.
    @Test
    void testReport32()
    {
        int expected_chinese_speakers = 1968265500;
        int actual_chinese_speakers = sql.report32()[0].getLanguage_num();
        assertEquals(expected_chinese_speakers, actual_chinese_speakers, "This asserts that the number of chinese speakers" +
                "matches the hardcoded expected number.");
    }
}
