package com.napier.sem;

import java.sql.*;

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

        //Report #1
        a.getAllCountries();

        //Report #2
        a.getPopulationContinent();


        //Report #3
        a.getPopulationRegion();


        //Report #7
        a.report7();


        //Report  #8
        a.report8();

        //report #9
        a.report9();

        //Report #11
        a.getCitiesInDistrictPopulation();

        //Report #18
        a.report18();

        //Report #19
        a.report19();


        //Report #26
        a.getWorldPopulation();


        //Report #27
        a.getTotalPopulationContinent();

        //Report #28: The population of the Caribbean
        a.report28();

        //Report #29
        a.getCountryPopulation();


        //Report #30
        a.getPopulationDistrict();


        //Report #31
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

    /**
     * This function prints the report showing all the cities in the world organised by largest population to smallest.
     */
    public void report7(){
        try
        {
            System.out.println("Report 7: All the cities in the world organised by largest population to smallest.");

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, name, CountryCode, district, population "
                            + "FROM city "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.name = rset.getString("name");
                city.country = rset.getString("CountryCode");
                city.district = rset.getString("district");
                city.population = rset.getInt("population");

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
     * Returns the population of each city in a continent (Asia) ordered from largest population to smallest.
     */
    public void report8(){
        try
        {
            System.out.println("Report 8: The population of each city in Asia ordered from largest population to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population, country.region "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.continent = 'Asia' "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-8s %-25s %-8s %-25s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City();
                city.ID = rset.getInt("city.ID");
                city.name = rset.getString("city.name");
                city.country = rset.getString( "city.CountryCode");
                city.district = rset.getString("city.district");
                city.population = rset.getInt("city.population");
                String city_string =
                        String.format("%-8s %-25s %-8s %-25s %-10s",
                                city.ID, city.name, city.country, city.district, city.population);
                System.out.println(city_string);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }

    }

    /**
     * Returns the population of each city in a region (The Caribbean) ordered from largest population to smallest.
      */
    public void report9(){
        try
        {
            System.out.println("Report 9: The population of each city in The Caribbean ordered from largest population to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population, country.region "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.region = 'Caribbean' "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC";
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
     * Returns a list of all Capital Cities in a given Continent (Europe) ordered by population from largest to smallest
     */
    public void report18(){
        try{

            System.out.println("Report #18: All the capital cities in a continent organised by largest population to smallest");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, country.name, city.population, country.code "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.code "
                            + "WHERE country.continent = 'Europe' "
                            + "ORDER BY city.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                CapitalCity city = new CapitalCity();
                city.name = rset.getString("city.name");
                city.country = rset.getString("country.name");
                city.population = rset.getInt("city.population");
                String CapitalCity_string =
                        String.format("%-30s %-35s %-15s",
                                city.name, city.country, city.population);
                System.out.println(CapitalCity_string);


            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
        }
    }

    /**
     * Returns a list of all Capital Cities in a given Region (Caribbean) ordered by population from largest to smallest
     */
    public void report19(){
        try{

            System.out.println("Report #19: All the capital cities in a region organised by largest to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, city.CountryCode, country.name, city.population, country.code "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.code "
                            + "WHERE country.region = 'Caribbean' "
                            + "ORDER BY city.population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                CapitalCity city = new CapitalCity();
                city.name = rset.getString("city.name");
                city.country = rset.getString("country.name");
                city.population = rset.getInt("city.population");
                String CapitalCity_string =
                        String.format("%-30s %-35s %-15s",
                                city.name, city.country, city.population);
                System.out.println(CapitalCity_string);


            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
        }
    }


    /**
     * Returns the population of a single region (Caribbean).
     */
    public void report28() {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population), region "
                            + "FROM country "
                            + "WHERE region = 'Caribbean' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            rset.next();

            System.out.println("Report #28: The population of The Caribbean: " + rset.getInt("SUM(Population)"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }
}