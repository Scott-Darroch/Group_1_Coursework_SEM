package com.napier.sem;

public class Language {
    public String name;
    public int language_num;
    public int language_percent;

    @Override
    public String toString() {
        return name + "\t" + language_num + "\t" + language_percent + "%";
    }
}
