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

        //Connection to the SQL Database
        Connection con = null;


        // Connect to database
        a.connect();

        //Creates a new instance of the SQL reports
        SQL sql = new SQL(con);

        //Report #1: all countries in the world in order of largest to smallest population.
        sql.report1();

        //Report #2: A list of country populations in Africa
        sql.report2();

        //Report #3: Population of the countries in the Caribbean in order of largest to smallest.
        sql.report3();

        /**
         * Leave room for 4 - 6
         */

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

        //Report #17
        a.report17();

        //Report #18
        a.report18();

        //Report #19
        a.report19();

        //Report #23
        a.report23();

        //Report #24
        a.report24();

        //Report #25
        a.report25();

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


        //Report #32 :Percentage share of each language compared to world population
        a.reportLanguage();


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
     * This function prints the report showing all the capital cities in the world organised by largest population to smallest.
     */
    public void report17(){
        try
        {
            System.out.println("Report 17: All the capital cities in the world organised by largest population to smallest.");

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.ID = country.capital "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City();
                city.ID = rset.getInt("city.ID");
                city.name = rset.getString("city.name");
                city.country = rset.getString("city.CountryCode");
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

    /** Returns the population of each continent that are both living in cities and not living in cities. **/
    public void report23(){
        try
        {
            System.out.println("Report 23: The population of a continent living in cities and not living in cities.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.continent, SUM(country.population) As TotalCountryPopulation, SUM(city.population) As TotalCityPopulation "
                            + "FROM country  "
                            + "INNER JOIN city ON city.CountryCode = country.Code "
                            + "GROUP BY country.continent ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-40s %-18s %-18s %-12s", "Continent", "Country Population", "City Population", "Non-city Population"));

            while (rset.next())
            {
                Population pop = new Population();
                pop.name = rset.getString("country.continent");
                pop.total_population = rset.getLong( "TotalCountryPopulation");
                pop.total_population_in_cities = rset.getInt("TotalCityPopulation");
                pop.total_population_not_in_cities =  (pop.total_population - pop.total_population_in_cities);
                System.out.println(pop);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }

        /** Returns the population of each region that are both living in cities and not living in cities. **/
    }
    public void report24(){
        try
        {
            System.out.println("Report 24: The population of a region living in cities and not living in cities.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.region, SUM(country.population) As TotalCountryPopulation, SUM(city.population) As TotalCityPopulation "
                            + "FROM country  "
                            + "INNER JOIN city ON city.CountryCode = country.Code "
                            + "GROUP BY country.region ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-40s %-18s %-18s %-12s", "Region", "Country Population", "City Population", "Non-city Population"));

            while (rset.next())
            {
                Population pop = new Population();
                pop.name = rset.getString("country.region");
                pop.total_population = rset.getLong( "TotalCountryPopulation");
                pop.total_population_in_cities = rset.getInt("TotalCityPopulation");
                pop.total_population_not_in_cities =  (pop.total_population - pop.total_population_in_cities);
                System.out.println(pop);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }

    }

    /** Returns the population of each country that are both living in cities and not living in cities. **/
    public void report25(){
        try
        {
            System.out.println("Report 25: The population of each country living in cities and not living in cities..");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.name, SUM(country.population) As TotalCountryPopulation, SUM(city.population) As TotalCityPopulation "
                            + "FROM country  "
                            + "INNER JOIN city ON city.CountryCode = country.Code "
                            + "GROUP BY country.name ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-40s %-18s %-18s %-12s", "Name", "Country Population", "City Population", "Non-city Population"));

            while (rset.next())
            {
                Population pop = new Population();
                pop.name = rset.getString("country.name");
                pop.total_population = rset.getLong( "TotalCountryPopulation");
                pop.total_population_in_cities = rset.getInt("TotalCityPopulation");
                pop.total_population_not_in_cities =  (pop.total_population - pop.total_population_in_cities);
                System.out.println(pop);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
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

    /**
     * Returns the language report.
     */
    public void reportLanguage() {
        try
        {
            System.out.println("Report 32: The number of people who speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest including world population.");
            System.out.println("Language:\tNumber of People who speak the language:\tPercentage of world population");

            Language chinese = new Language();
            chinese.name = "'Chinese'";
            Language english = new Language();
            english.name = "'English'";
            Language hindi = new Language();
            hindi.name = "'Hindi'";
            Language spanish = new Language();
            spanish.name = "'Spanish'";
            Language arabic = new Language();
            arabic.name = "'Arabic'";

            Language[] languages = {chinese, english, hindi, spanish, arabic};

            for (int i = 0; i<languages.length; i++){

                Statement stmt = con.createStatement();
                String strSelect =
                        "SELECT SUM(country.population) AS country_pop, ROUND((100 * SUM(country.population))/(SELECT SUM(population) FROM country), 0) AS world_pop "
                                + "FROM country INNER JOIN countrylanguage on country.code = countrylanguage.countryCode "
                                + "WHERE countrylanguage.language = " + languages[i].name;
                ResultSet rset = stmt.executeQuery(strSelect);

                while (rset.next())
                {
                    languages[i].language_num = rset.getInt("country_pop");
                    languages[i].language_percent = rset.getInt("world_pop");
                }
            }

            for (int i = 0; i<languages.length; i++){
                for (int j = i + 1; j<languages.length; j++){
                    if(languages[i].language_num < languages[j].language_num){
                        Language temp = languages[i];
                        languages[i] = languages[j];
                        languages[j] = temp;
                    }
                }
            }

            for (int i = 0; i<languages.length; i++){
                System.out.println(languages[i]);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
        }
    }
}