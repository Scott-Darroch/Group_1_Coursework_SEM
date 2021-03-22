package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WorldPopTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect();
    }

    @Test
    void testGetWorldPopulation()
    {
        long testPop = 6078749450L;
        long worldPop = app.report26();
        Assertions.assertEquals(worldPop, testPop, 1);
    }
}
