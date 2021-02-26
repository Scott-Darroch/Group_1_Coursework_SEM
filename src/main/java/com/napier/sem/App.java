package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Extract country population information from world.sql
        ArrayList<Country> countries = a.getAllPopulations();
        //Send message to user explaining what the report shows
        System.out.println("A report showing all countries in the world in order of largest to smallest population.");
        //Print country population information
        a.printPopulations(countries);
        //
        // Extract population information from a region (Caribbean)
        countries = a.getPopulationRegion();
        // Output to user for clarity
        System.out.println("A report showing the population of the Caribbean in order of largest to smallest.");
        // printPopulations method can be reused here as it supplies the same output requirement as previous report
        a.printPopulations(countries);
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
    public ArrayList<Country> getAllPopulations()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital "
                            + "FROM country "
                            + "ORDER BY country.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("country.capital");
                countries.add(coun);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    /**
     * Prints a list of populations.
     * @param countries The list of populations to print.
     */
    public void printPopulations(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-5s %-48s %-20s %-30s %-15s %-15s", "Code", "Country Name", "Continent", "Region", "Population", "Capitol"));
        // Loop over all countries in the list
        for (Country coun : countries)
        {
            String emp_string =
                    String.format("%-5s %-48s %-20s %-30s %-15s %-15s",
                            coun.code, coun.name, coun.continent, coun.region, coun.population, coun.capital);
            System.out.println(emp_string);
        }
    }


    /**
     * Gets all the current population information.
     * @return A list of population for a region (Caribbean), or null if there is an error.
     */
    public ArrayList<Country> getPopulationRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, country.capital "
                            + "FROM country "
                            + "WHERE country.region = 'Caribbean' "
                            + "ORDER BY country.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("country.capital");
                countries.add(coun);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
}