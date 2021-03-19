package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
    Connection con;

    public SQL(Connection con) {
        this.con = con;
    }

    /**
     * Gets all countries in the world in order of largest to smallest population..
     */
    public void report1() {
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
     * Gets A list of country populations in Africa.
     */
    public void report2(){
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

}
