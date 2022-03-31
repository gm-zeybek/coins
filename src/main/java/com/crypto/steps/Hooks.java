package com.crypto.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks extends TestBase{

    @Before
    public void setup(){
        System.out.println("before ");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--enable-javascript");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
    @After()
    public void tearDown(){
        closeDriver();


        System.out.println("after");
    }

}
