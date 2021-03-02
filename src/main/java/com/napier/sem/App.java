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
        ArrayList<Country> countries = a.getAllCountries();
        //Send message to user explaining what the report shows
        System.out.println("Report 1: A report showing all countries in the world in order of largest to smallest population.");
        //Print country population information
        a.printCityReports(countries);

        // Extract population information from a continent (Africa)
        countries = a.getPopulationContinent();
        // Output to user for clarity
        System.out.println("Report 2: A report showing the population of the countries in Africa in order of largest to smallest.");
        // printPopulations method can be reused here as it supplies the same output requirement as previous report
        a.printCityReports(countries);

        // Extract population information from a region (Caribbean)
        countries = a.getPopulationRegion();
        // Output to user for clarity
        System.out.println("Report 3: A report showing the population of the Caribbean in order of largest to smallest.");
        // printCityReports method can be reused here as it supplies the same output requirement as previous report
        a.printCityReports(countries);

        System.out.println("Report 26: The population of the world.");
        // getWorldPopulation method gets the world's population then prints it.
        a.getWorldPopulation();

        System.out.println("Report 27: The total population of a continent (Europe).");
        // Extract the population information from the continent Europe
        countries = a.getTotalPopulationContinent();
        a.printPopulationContinent(countries);

        System.out.println("Report 29: The total population of a country (Spain).");
        // getCountryPopulation method gets the population of a country then prints it.
        a.getCountryPopulation();

        // Extract population information from a district (New South Wales)
        ArrayList<City> cities = a.getPopulationDistrict();
        // Output to user for clarity
        System.out.println("Report 30: The total population of a district (New South Wales).");
        a.printPopulationDistrict(cities);
        //


        //Prints the output of report 31, the population of Edinburgh
        System.out.println("Report #31, The population of a City (Edinburgh)");
        System.out.println(a.getPopulationCity());

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
    public ArrayList<Country> getAllCountries()
    {
        try
        {
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
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("city.name");
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
    public void printCityReports(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-5s %-48s %-20s %-30s %-15s %-15s", "Code", "Country Name", "Continent", "Region", "Population", "Capital"));
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
                    "SELECT country.code, country.name, country.continent, country.region, country.population, city.name "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID AND country.region = 'Caribbean' "
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
                coun.capital = rset.getString("city.name");
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
     * Gets all the current population information.
     * @return A list of country populations for a continent (Africa), or null if there is an error.
     */
    public ArrayList<Country> getPopulationContinent()
    {
        try
        {
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
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.code = rset.getString("country.code");
                coun.name = rset.getString("country.name");
                coun.continent = rset.getString("country.continent");
                coun.region = rset.getString("country.region");
                coun.population = rset.getInt("country.population");
                coun.capital = rset.getString("city.name");
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
     * Gets all the current population information.
     * @return A list of population for a district (New South Wales), or null if there is an error.
     */
    public ArrayList<City> getPopulationDistrict()
    {
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
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.district = rset.getString("city.district");
                city.population = rset.getInt("SUM(city.population)");
                cities.add(city);
            }
            return cities;
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
     * @param cities The list of populations to print.
     */
    public void printPopulationDistrict(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-25s %-20s", "District", "Total Population"));
        // Loop over all countries in the list
        for (City cit : cities)
        {
            String emp_string =
                    String.format("%-25s %-20s",
                            cit.district, cit.population);
            System.out.println(emp_string);
        }
    }

    /**
     * Gets the world's population and prints it.
     */
    public void getWorldPopulation()
    {
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
                System.out.println("The total population of the world is: " + rset.getLong("SUM(country.population)"));
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
    public void getCountryPopulation()
    {
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
                Country country = new Country();
                country.name = rset.getString("country.name");
                country.population = rset.getInt("country.population");
                System.out.println("The population of the country: " + country.name + " is: " + country.population);
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
    public ArrayList<Country> getTotalPopulationContinent()
    {
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
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.continent = rset.getString("country.continent");
                country.population = rset.getInt("SUM(country.population)");
                countries.add(country);
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
    public void printPopulationContinent(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-25s %-20s", "Continent", "Total Population"));
        // Loop over all countries in the list
        for (Country country : countries)
        {
            String emp_string =
                    String.format("%-25s %-20s",
                            country.continent, country.population);
            System.out.println(emp_string);
        }
    }

    /**
     * Returns the population of a single city (Edinburgh).
     * @return A City (Edinburgh), or null if there is an error.
     */
    public City getPopulationCity()
    {
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

            City city = new City();
            city.ID = rset.getInt("ID");
            city.name = rset.getString("Name");
            city.country = rset.getString("CountryCode");
            city.district = rset.getString("District");
            city.population = rset.getInt("Population");

            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }
}