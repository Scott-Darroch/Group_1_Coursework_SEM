package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
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
        app.connect();
        sql = new SQL(app.getCon());
    }

    @Test
    void testGetWorldPopulation()
    {
        long testPop = 6078749450L;
        long worldPop = sql.report26();
        assertEquals(testPop, worldPop);
    }

    @Test
    void testGetContinentPopulation()
    {
        int testpop = 730074600;
        int continentpop = sql.report27();
        assertEquals(testpop, continentpop);
    }
}
