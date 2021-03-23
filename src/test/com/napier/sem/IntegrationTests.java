package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
