package com.crypto.steps;

import com.crypto.pages.DashboardPage;
import com.crypto.userAccount.User;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Locale;
import java.util.logging.Logger;


public abstract class TestBase {

    DashboardPage dashboardPage = new DashboardPage();
    Actions action = new Actions(getDriver());




    public static User getUser(){


        Faker faker = new Faker(new Locale("en-GB"));
        return new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().emailAddress());

    }

    public final static Logger logger = Logger.getLogger(TestBase.class.getName());



    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }else {
            return driver;
        }

    }
    public static void closeDriver(){
        try {

        }finally {
            driver.close();
        }
    }

}
