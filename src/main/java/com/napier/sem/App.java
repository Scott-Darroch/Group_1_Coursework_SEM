package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Reports.
 */
public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();


        /**
         * Report 1:
         * Extract country population information from world.sql file, send message to user explaining what the report shows
         * then print country population information.
          */
        a.getAllCountries();


        /**
         * Report 2:
         * Extract population information from a continent (Africa), send message to user explaining what the report shows
         * then print the continent population information.
         */
        a.getPopulationContinent();


        /**
         * Report 3:
         * Extract population information from a region (Caribbean), send message to user explaining what the report shows
         * then print the region population information.
         */
        a.getPopulationRegion();


        /**
         * Report 11:
         * Extract population information from a given district (Noord-Barbant), send message to user explaining what the report shows
         * then print the district population information.
         */
        a.getCitiesInDistrictPopulation();


        /**
         * Report 26:
         * Extract population information from the world, send message to user explaining what the report shows
         * then print the world population information.
         */
        a.getWorldPopulation();


        /**
         * Report 27:
         * Extract population information from a given continent (Europe), send message to user explaining what the report shows
         * then print the continent population information.
         */
        a.getTotalPopulationContinent();


        /**
         * Report 29:
         * Extract population information from a given country (Spain), send message to user explaining what the report shows
         * then print the country population information.
         */
        a.getCountryPopulation();


        /**
         * Report 30:
         * Extract population information from a given district (New South Wales), send message to user explaining what the report shows
         * then print the district population information.
         */
        a.getPopulationDistrict();


        /**
         * Report 31:
         * Extract population information from a given city (Edinburgh), send message to user explaining what the report shows
         * then print the city population information.
         */
        a.getPopulationCity();


        System.out.println("End of Reports.");
        
        // Disconnect from database
        a.disconnect();

    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
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




    /**
     * Gets all the current population information.
     * @return A list of all populations, or null if there is an error.
     */
    public void getAllCountries() {
        try
        {
            System.out.println("Report 1: A report showing all countries in the world in order of largest to smallest population.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, city.name "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID "
                            + "ORDER BY country.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("city.name");
                System.out.println(coun);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    /**
     * Gets all the current population information.
     * @return A list of country populations for a continent (Africa), or null if there is an error.
     */
    public void getPopulationContinent(){
        try
        {
            System.out.println("Report #2, A list of country populations in Africa");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, city.name "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID AND country.continent = 'Africa' "
                            + "ORDER BY country.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("city.name");
                System.out.println(coun);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    /**
     * Gets all the current population information.
     * @return A list of population for a region (Caribbean), or null if there is an error.
     */
    public void getPopulationRegion() {
        try
        {
            System.out.println("Report 3: A report showing the population of the countries in the Caribbean in order of largest to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, city.name "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID AND country.region = 'Caribbean' "
                            + "ORDER BY country.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("city.name");
                System.out.println(coun);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    /**
     * Gets a list of the population of each city in a given district
     * @return a list of the population of all cities in a given district, or Null if there is an error
     */
    public void getCitiesInDistrictPopulation() {
        try
        {
            System.out.println("Report 11: The population of each city in Noord_Brabant ordered from largest population to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, name, CountryCode, district, population "
                            + "FROM city "
                            + "WHERE district = 'Noord-Brabant' "
                            + "ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City();
                city.ID = rset.getInt("city.ID");
                city.name = rset.getString("city.name");
                city.country = rset.getString( "city.CountryCode");
                city.district = rset.getString("city.district");
                city.population = rset.getInt("city.population");
                System.out.println(city);

            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");


        }
    }

    /**
     * Gets all the current population information.
     * @return A list of population for a district (New South Wales), or null if there is an error.
     */
    public void getPopulationDistrict() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.district, SUM(city.population) "
                            + "FROM city "
                            + "WHERE city.district = 'New South Wales' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            while (rset.next())
            {
                System.out.println("Report #30: The total population of New South Wales is: " + rset.getInt("SUM(city.population)"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    /**
     * Gets the world's population and prints it.
     */
    public void getWorldPopulation() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.population) "
                            + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                System.out.println("Report #26: The total population of the world is: " + rset.getLong("SUM(country.population)"));
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");

        }
    }

    /**
     * Gets the population of a country and prints it.
     */
    public void getCountryPopulation() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, country.population "
                            + "FROM country "
                            + "WHERE country.name = 'Spain' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                System.out.println("Report #29: The population of the Spain: " + rset.getInt("country.population"));
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");

        }
    }

    /**
     * Gets all the current population information.
     * @return A list of population for a continent (Europe), or null if there is an error.
     */
    public void getTotalPopulationContinent() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.continent, SUM(country.population) "
                            + "FROM country "
                            + "WHERE country.continent = 'Europe' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            while (rset.next())
            {
                System.out.println("Report #27: The total population of Europe is: " + rset.getInt("SUM(country.population)"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }

    /**
     * Returns the population of a single city (Edinburgh).
     * @return A City (Edinburgh), or null if there is an error.
     */
    public void getPopulationCity() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, name, CountryCode, district, population "
                            + "FROM city "
                            + "WHERE name = 'Edinburgh' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            rset.next();

            System.out.println("Report #31: The population of Edinburgh: " + rset.getInt("Population"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }
}