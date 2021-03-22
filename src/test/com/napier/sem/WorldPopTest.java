package com.napier.sem;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class WorldPopTest {

    static App app = new App();

    public WorldPopTest() throws SQLException {
    }
    @BeforeAll
    static void init()
    {
    }

    @Test
    void testGetWorldPopulation()
    {
        app.connect();

        Long testPop = 6078749450L;
        Long worldPop = app.report26();
        Assertions.assertEquals(worldPop, testPop, 1);
    }
}
