package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class that contain all SQL query codes and prints the result of the sql query.
 * @author Euan Holmes,
 * @author Adam Riddell,
 * @author Scott Darroch
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */
public class SQL {

    //Connection to the SQL Database
    private Connection con;

    public SQL(Connection con) {
        this.con = con;
    }


    /**
     * Function that gets all countries in the world in order of largest to smallest population.
     * @author Scott Darroch
     * @return countries
     * Date Last modified 15/2/2021
     * Last modified by: Scott
     */
    public ArrayList<Country> report1() {
        ArrayList<Country> countries = new ArrayList<>();
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
                Country coun = new Country(rset.getString("country.code"),rset.getString("country.name"),rset.getString("country.continent"),
                        rset.getString("country.region"),rset.getInt("country.population"),rset.getString("city.name"));
                System.out.println(coun);
                countries.add(coun);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return countries;
        }
    }

    /**
     * Function that gets all countries in a continent in order of largest to smallest population.
     * @author Euan Holmes
     * @return countries
     * Date Last modified 26/2/2021
     * Last modified by: Euan
     */
    public ArrayList<Country> report2(){
        ArrayList<Country> countries = new ArrayList<>();
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
                Country coun = new Country(rset.getString("country.code"),rset.getString("country.name"),rset.getString("country.continent"),
                        rset.getString("country.region"),rset.getInt("country.population"),rset.getString("city.name"));
                System.out.println(coun);
                countries.add(coun);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return countries;
        }
    }


    /**
     * Function that gets the population of the countries in the Caribbean in order of largest to smallest.
     * @author Scott Darroch
     * @return countries
     * Date Last modified 26/2/2021
     * Last modified by: Scott
     */
    public ArrayList<Country> report3() {
        ArrayList<Country> countries = new ArrayList<>();
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
                Country coun = new Country(rset.getString("country.code"),rset.getString("country.name"),rset.getString("country.continent"),
                        rset.getString("country.region"),rset.getInt("country.population"),rset.getString("city.name"));
                System.out.println(coun);
                countries.add(coun);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return countries;
        }
    }

    /*
        Leave Room For 4-6
     */


    /**
     * Function that prints the report showing all the cities in the world organised by largest population to smallest.
     * @author Euan Holmes
     * @return cities
     * Date Last modified 4/3/2021
     * Last modified by: Euan
     */
    public ArrayList<City> report7(){
        ArrayList<City> cities = new ArrayList<>();
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
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }


    /**
     * Function that returns the population of each city in a continent (Asia) ordered from largest population to smallest.
     * @author Scott Darroch
     * @return cities
     * Date Last modified 3/3/2021
     * Last modified by: Scott
     */
    public ArrayList<City> report8(){
        ArrayList<City> cities = new ArrayList<>();
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
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }


    /**
     * Function that returns the population of each city in a region (The Caribbean) ordered from largest population to smallest.
     * @author Adam Riddel
     * @return cities
     * Date Last modified 3/3/2021
     * Last modified by: Adam
     */
    public ArrayList<City> report9(){
        ArrayList<City> cities = new ArrayList<>();
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
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }


    /**
     * Function that returns the population of each city in Scotland ordered from largest population to smallest.
     * @author Scott Darroch
     * @return cities
     * Date Last modified 5/3/2021
     * Last modified by: Scott
     */
    public ArrayList<City> report10(){
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("Report 10: The population of each city in Scotland ordered from largest population to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population, country.region "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.name = 'France' "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }

    }


    /**
     * Function that gets a list of the population of each city in (District) Noord_Brabant
     * @author Robert Denny
     * @author Adam Riddel
     * @author Euan Holmes
     * @return cities
     * Date Last modified 5/3/2021
     * Last modified by: Robert
     */
    public ArrayList<City> report11() {
        ArrayList<City> cities = new ArrayList<>();
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

            // Print header
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }

    /*
        Leave Room For 12-16
     */
    /**
     * Function that gets a list of the top 7 most populated cities in the world.
     * @author Scott Darroch
     * @return cities
     * Date Last modified 02/04/2021
     * Last modified by: Scott
     */
    public ArrayList<City> report12() {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("Report 12: The top 7 populated cities in the world.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, name, CountryCode, district, population "
                            + "FROM city "
                            + "ORDER BY population DESC "
                            + "LIMIT 7 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }

    /**
     * Function that gets a list of the top 14 most populated cities in North America.
     * @author Scott Darroch
     * @return cities
     * Date Last modified 02/04/2021
     * Last modified by: Scott
     */
    public ArrayList<City> report13() {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("Report 13: The top 14 populated cities in the continent of North America.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.name, CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.continent = 'North America' "
                            + "ORDER BY population DESC "
                            + "LIMIT 14 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }

    /**
     * Function that gets a list of the top 3 most populated cities in Southern Europe.
     * @author Scott Darroch
     * @return cities
     * Date Last modified 02/04/2021
     * Last modified by: Scott
     */
    public ArrayList<City> report14() {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("Report 14: The top 3 populated cities in the region of Southern Europe.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.name, CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.region = 'Southern Europe' "
                            + "ORDER BY population DESC "
                            + "LIMIT 3 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }

    /**
     * Function that gets a list of the top 5 most populated cities in Japan.
     * @author Scott Darroch
     * @return cities
     * Date Last modified 02/04/2021
     * Last modified by: Scott
     */
    public ArrayList<City> report15() {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("Report 15: The top 5 populated cities in Japan.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.name, CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.name = 'Japan' "
                            + "ORDER BY population DESC "
                            + "LIMIT 5 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Print header
            System.out.println(String.format("%-8s %-30s %-8s %-30s %-10s", "City ID", "City Name", "Country", "District", "Population"));

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }


    /**
     * Outputs the top 'N' populated cities in a district (Noord-Brabant)
     * @author Adam Riddel
     * @return cities
     * Date Last modified 04/04/2021
     * Last modified by: Adam
     */
    public ArrayList<City> report16(int n) {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("Report 16: The top 'N' populated cities in a district (Noord-Brabant).");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, name, CountryCode, district, population "
                            + "FROM city "
                            + "WHERE district = 'Noord-Brabant' "
                            + "ORDER BY population DESC "
                            + "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }

    /**
     * Function that prints the report showing all the capital cities in the world organised by largest population to smallest.
     * @author Euan Holmes
     * @return cities
     * Date Last modified 10/3/2021
     * Last modified by: Euan
     */
    public ArrayList<City> report17(){
        ArrayList<City> cities = new ArrayList<>();
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
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
                System.out.println(city);
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return cities;
        }
    }


    /**
     * Function that returns a list of all Capital Cities in a given Continent (Europe) ordered by population from largest to smallest.
     * @author Robert Denny
     * @author Scott Darroch
     * @author Euan Holmes
     * @return capital_cities
     * Date Last modified 8/3/2021
     * Last modified by: Robert
     */
    public ArrayList<CapitalCity> report18(){
        ArrayList<CapitalCity> capital_cities = new ArrayList<>();
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
                CapitalCity city = new CapitalCity(rset.getString("city.name"),rset.getString("country.name"),rset.getInt("city.population"));
                String CapitalCity_string =
                        String.format("%-30s %-35s %-15s",
                                city.getName(), city.getCountry(), city.getPopulation());
                System.out.println(CapitalCity_string);
                capital_cities.add(city);
            }
            return capital_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return capital_cities;
        }
    }


    /**
     * Function that returns a list of all Capital Cities in a given Region (Caribbean) ordered by population from largest to smallest
     * @author Robert Denny
     * @author Scott Darroch
     * @author Euan Holmes
     * @return capital_cities
     * Date Last modified 5/3/2021
     * Last modified by: Robert
     */
    public ArrayList<CapitalCity> report19(){
        ArrayList<CapitalCity> capital_cities = new ArrayList<>();
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
                CapitalCity city = new CapitalCity(rset.getString("city.name"),rset.getString("country.name"),rset.getInt("city.population"));
                String CapitalCity_string =
                        String.format("%-30s %-35s %-15s",
                                city.getName(), city.getCountry(), city.getPopulation());
                System.out.println(CapitalCity_string);
                capital_cities.add(city);
            }
            return capital_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return capital_cities;
        }
    }

    /**
     * Function that prints the report showing the top 'N' populated capital cities in the world.
     * @author Adam Riddell
     * Date Last modified 04/04/2021
     * Last modified by: Adam
     */
    public void report20(int n) {
        try
        {
            System.out.println("Report 20: Top 'N' populated capital cities in the world.");

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.ID = country.capital AND city.ID = country.capital "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC "
                            + "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
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
     * Function that prints the report showing the top 'N' populated capital cities in a continent.
     * @author Adam Riddell
     * Date Last modified 04/04/2021
     * Last modified by: Adam
     */
    public void report21(int n) {
        try
        {
            System.out.println("Report 21: Top 'N' populated capital cities in Europe.");

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.continent = 'Europe' AND city.ID = country.capital "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC "
                            + "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
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
     * Function that prints the report showing the top 'N' populated capital cities in a region.
     * @author Adam Riddell
     * Date Last modified 04/04/2021
     * Last modified by: Adam
     */
    public void report22(int n) {
        try
        {
            System.out.println("Report 22: Top 'N' populated cities in the Caribbean.");

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.name, city.CountryCode, city.district, city.population "
                            + "FROM city "
                            + "INNER JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.region = 'Caribbean' AND city.ID = country.capital "
                            + "GROUP BY city.ID "
                            + "ORDER BY city.population DESC "
                            + "LIMIT " + n;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City(rset.getInt("ID"), rset.getString("name"),rset.getString("CountryCode"),
                        rset.getString("district"), rset.getInt("population"));
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
     * Function that returns the population of each continent that are both living in cities and not living in cities.
     * @author Scott Darroch
     * @return populations
     * Date Last modified 12/3/2021
     * Last modified by: Scott
     */
    public ArrayList<Population> report23(){
        ArrayList<Population> populations = new ArrayList<>();
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
                Population pop = new Population(rset.getString("country.continent"),rset.getLong( "TotalCountryPopulation"),
                        rset.getInt("TotalCityPopulation"),
                        ((rset.getLong( "TotalCountryPopulation"))-(rset.getInt("TotalCityPopulation"))));
                System.out.println(pop);
                populations.add(pop);
            }
            return populations;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return populations;
        }
    }


    /**
     * Function that returns the population of each region that are both living in cities and not living in cities.
     * @author Scott Darroch
     * @return populations
     * Date Last modified 12/3/2021
     * Last modified by: Scott
     */
    public ArrayList<Population> report24(){
        ArrayList<Population> populations = new ArrayList<>();
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
                Population pop = new Population(rset.getString("country.region"),rset.getLong( "TotalCountryPopulation"),
                        rset.getInt("TotalCityPopulation"),
                        ((rset.getLong( "TotalCountryPopulation"))-(rset.getInt("TotalCityPopulation"))));
                System.out.println(pop);
                populations.add(pop);
            }
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return populations;
        }

    }


    /**
     * Function that returns the population of each country that are both living in cities and not living in cities.
     * @author Scott Darroch
     * @return populations
     * Date Last modified 10/3/2021
     * Last modified by: Scott
     */
    public ArrayList<Population> report25(){
        ArrayList<Population> populations = new ArrayList<>();
        try
        {
            System.out.println("Report 25: The population of each country living in cities and not living in cities.");
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
                Population pop = new Population(rset.getString("country.name"),rset.getLong( "TotalCountryPopulation"),
                        rset.getInt("TotalCityPopulation"),
                        ((rset.getLong( "TotalCountryPopulation"))-(rset.getInt("TotalCityPopulation"))));
                System.out.println(pop);
                populations.add(pop);
            }
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return populations;
        }

    }


    /**
     * Function that gets the world's population and prints it.
     * @author Euan Holmes
     * Date Last modified 25/2/2021
     * Last modified by: Euan
     */
    public long report26() {
        try
        {
            long x = 0L;
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
                x = rset.getLong("SUM(country.population)");
                System.out.println("Report #26: The total population of the world is: " + x);
            }
            return x;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return 0L;

        }
    }


    /**
     * Function that gets total population information for the continent of Europe.
     * @author Scott Darroch
     * Date Last modified 25/2/2021
     * Last modified by: Scott
     */
    public int report27() {
        try
        {
            int x = 0;
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
                x = rset.getInt("SUM(country.population)");
                System.out.println("Report #27: The total population of Europe is: " + rset.getInt("SUM(country.population)"));
            }
            return x;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return 0;
        }
    }


    /**
     * Function that returns the population of a single region (Caribbean).
     * @author Scott Darroch
     * Date Last modified 25/2/2021
     * Last modified by: Scott
     */
    public int report28() {
        try {
            int x = 0;
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(population), region "
                            + "FROM country "
                            + "WHERE region = 'Caribbean' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                x = rset.getInt("SUM(Population)");
                System.out.println("Report #28: The population of The Caribbean: " + rset.getInt("SUM(Population)"));
            }
            return x;
        }
        catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get population details");
                return 0;
            }
        }

    /**
     * Function that gets the population of a country and prints it.
     * @author Euan Holmes
     * Date Last modified 25/2/2021
     * Last modified by: Euan
     */
    public int report29() {
        try
        {
            int x = 0;
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
                x = rset.getInt("country.population");
                System.out.println("Report #29: The population of the Spain: " + rset.getInt("country.population"));
            }
            return x;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return 0;
        }
    }


    /**
     * Function that gets the population of New South Wales.
     * @author Scott Darroch
     * Date Last modified 25/2/2021
     * Last modified by: Scott
     */
    public int report30() {
        try
        {
            int x = 0;
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
                x = rset.getInt("SUM(city.population)");
                System.out.println("Report #30: The population of New South Wales is: " + rset.getInt("SUM(city.population)"));
            }
            return x;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return 0;
        }
    }


    /**
     * Function that returns the population of a single city (Edinburgh).
     * @author Adam Riddell
     * @return city
     * Date Last modified 25/2/2021
     * Last modified by: Adam
     */
    public int report31() {
        int city = 0;
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
            city = rset.getInt("Population");
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return city;
        }
    }


    /**
     * Function that returns the number of people who speak Chinese, English, Hindi, Spanish and Arabic from
     * greatest number to smallest.
     * @author Euan Holmes
     * @return languages
     * Date Last modified 10/3/2021
     * Last modified by: Euan
     */
    public Language[] report32() {
        System.out.println("Report 32: The number of people who speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest including world population.");
        System.out.println("Language:\tNumber of People who speak the language:\tPercentage of world population");

        Language chinese = new Language("'Chinese'");
        Language english = new Language("'English'");
        Language hindi = new Language("'Hindi'");
        Language spanish = new Language("'Spanish'");
        Language arabic = new Language("'Arabic'");

        Language[] languages = {chinese, english, hindi, spanish, arabic};
        try
        {
            for (int i = 0; i<languages.length; i++){

                Statement stmt = con.createStatement();
                String strSelect =
                        "SELECT SUM(country.population) AS country_pop, ROUND((100 * SUM(country.population))/(SELECT SUM(population) FROM country), 0) AS world_pop "
                                + "FROM country INNER JOIN countrylanguage on country.code = countrylanguage.countryCode "
                                + "WHERE countrylanguage.language = " + languages[i].getName();
                ResultSet rset = stmt.executeQuery(strSelect);

                while (rset.next())
                {
                    languages[i].setLanguage_num(rset.getInt("country_pop"));
                    languages[i].setLanguage_percent(rset.getInt("world_pop"));
                }
            }

            for (int i = 0; i<languages.length; i++){
                for (int j = i + 1; j<languages.length; j++){
                    if(languages[i].getLanguage_num() < languages[j].getLanguage_num()){
                        Language temp = languages[i];
                        languages[i] = languages[j];
                        languages[j] = temp;
                    }
                }
            }

            for (int i = 0; i<languages.length; i++){
                System.out.println(languages[i]);
            }
            return languages;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return languages;
        }
    }
}
