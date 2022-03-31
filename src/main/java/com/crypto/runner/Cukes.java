package com.crypto.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = false,
        features = "src/main/resources/",
        glue = "com/crypto/steps",
        dryRun = false,
        tags = ""

)
public class Cukes {
}
