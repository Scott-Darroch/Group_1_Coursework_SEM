package com.napier.sem;

/**
 * Class for a city report
 * @author Euan Holmes
 * @author Adam Riddell
 * @author Scott Darroch
 * Date Last modified 23/3/2021
 * Last modified by: Euan
 */
public class Language {
    private String name;
    private int language_num;
    private int language_percent;

    public Language(String name) {
        this.name = name;
    }

    public Language(String name, int language_num, int language_percent) {
        this.name = name;
        this.language_num = language_num;
        this.language_percent = language_percent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLanguage_num() {
        return language_num;
    }

    public void setLanguage_num(int language_num) {
        this.language_num = language_num;
    }

    public int getLanguage_percent() {
        return language_percent;
    }

    public void setLanguage_percent(int language_percent) {
        this.language_percent = language_percent;
    }

    @Override
    public String toString() {
        return name + "\t" + language_num + "\t" + language_percent + "%";
    }
}
