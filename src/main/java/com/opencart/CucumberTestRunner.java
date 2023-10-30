package com.opencart;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/gabrielababara/IdeaProjects/JavaUiAutomationFramework/src/main/java/com/opencart/features/Register.feature",
        glue = "com.opencart.stepdefinitions",
        tags = ""
)


public class CucumberTestRunner {
}
