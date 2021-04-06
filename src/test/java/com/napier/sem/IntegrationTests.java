package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Class that contain all code for conducting integration tests for the project.
 * @author Euan Holmes,
 * @author Adam Riddell,
 * @author Scott Darroch,
 * @author Robert Denny
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
        app.connect();
        sql = new SQL(app.getCon());
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
}
