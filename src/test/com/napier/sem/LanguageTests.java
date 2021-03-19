package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class LanguageTests {

    static App app;

    @BeforeAll
    static void init()
    {
        // Init new instances of App & DbConnection
        app = new App();

    }

    @Test
    void printPrintEmptyLanguageTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        System.out.println(languages);
    }

    @Test
    void printPrintNullLanguageTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(null);
        System.out.println(languages);
    }

    @Test
    void printCityTest()
    {
        ArrayList<Language> languages = new ArrayList<>();
        Language language = new Language();
        language.name = ("English");
        language.language_num = (42);
        language.language_percent = (10);
        languages.add(language);
        System.out.println(language);
    }
}