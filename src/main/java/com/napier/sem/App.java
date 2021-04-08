package com.napier.sem;

import java.sql.*;

/**
 * Main app class that contains the connect() and disconnect() function for our database. Also contains
 * our calls to SQL.java to do our report functions.
 * @author Euan Holmes,
 * @author Adam Riddell,
 * @author Scott Darroch,
 * @author Robert Denny
 * Date Last modified 08/04/2021
 * Last modified by: Robert
 */
public class App
{
    //Connection to the SQL Database
    private static Connection con;

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect("localhost:33060");

        //Creates a new instance of the SQL reports
        SQL sql = new SQL(con);

        //Report #1: all countries in the world in order of largest to smallest population.
        sql.report1();

        //Report #2: A list of country populations in Africa
        sql.report2();

        //Report #3: Population of the countries in the Caribbean in order of largest to smallest.
        sql.report3();

        //"Report #4: The top 'N' populated countries in the World."
        sql.report4(3);

        //Report #5: The top 17 populated countries in the continent of Europe.
        sql.report5(15);

        //Report #6: The top 'N' populated countries in the caribbean
        sql.report6(5);

        //Report #7: All the cities in the world organised by largest population to smallest.
        sql.report7();

        //Report #8: Population of each city in a continent (Asia) ordered from largest population to smallest
        sql.report8();

        //report #9: Population of each city in a region (The Caribbean) ordered from largest population to smallest.
        sql.report9();

        //Report #10: Population of each city in Scotland ordered from largest population to smallest.
        sql.report10();

        //Report #11: population of each city in (District) Noord_Brabant
        sql.report11();

        //Report #12: The top 7 populated cities in the world.
        sql.report12();

        //Report #13: The top 14 populated cities in the continent of North America.
        sql.report13();

        //Report #14: The top 3 populated cities in the region of Southern Europe.
        sql.report14();

        //Report #15: The top 5 most populated cities in Japan.
        sql.report15();

        //Report #16: Top 'N' populated cities in a district ()
        sql.report16(5);

        //Report #17: All the capital cities in the world organised by largest population to smallest.
        sql.report17();

        //Report #18: All the capital cities in a continent organised by largest population to smallest.
        sql.report18();

        //Report #19: All the capital cities in a region organised by largest to smallest.
        sql.report19();

        //Report #20: Top 'N' populated capital cities in the world.
        sql.report20(5);

        //Report #21: The top 'N' capital cities in a continent (Europe).
        sql.report21(5);

        //Report #22: The top 'N' capital cities in a region (Caribbean).
        sql.report22(5);

        //Report #23: population of a continent living in cities and not living in cities.
        sql.report23();

        //Report #24: Population of a region living in cities and not living in cities.
        sql.report24();

        //Report #25: Population of each country living in cities and not living in cities.
        sql.report25();

        //Report #26: The total population of the world.
        sql.report26();

        //Report #27: The total population of Europe.
        sql.report27();

        //Report #28: The population of the Caribbean.
        sql.report28();

        //Report #29: The population of the Spain.
        sql.report29();

        //Report #30: The population of New South Wales.
        sql.report30();

        //Report #31: The population of a single city (Edinburgh)
        sql.report31();

        //Report #32 :Percentage share of each language compared to world population
        sql.report32();

        System.out.println("End of Reports.");

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Class that connects to the database.
     * @author Euan Holmes,
     * @author Adam Riddell,
     * @author Scott Darroch
     * Date Last modified 22/3/2021
     * Last modified by: Euan
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(10000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Function that disconnects from SQL database.
     * @author Euan Holmes,
     * @author Adam Riddell,
     * @author Scott Darroch
     * Date Last modified 20/2/2021
     * Last modified by: Scott
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    //Establish connection.
    public Connection getCon() {
        return con;
    }

}