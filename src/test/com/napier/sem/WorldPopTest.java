package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorldPopTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void testGetWorldPopulation()
    {
        app.connect();
        long testPop = 6078749450L;
        long worldPop = app.report26();
        assertEquals(testPop, worldPop);
    }
}
