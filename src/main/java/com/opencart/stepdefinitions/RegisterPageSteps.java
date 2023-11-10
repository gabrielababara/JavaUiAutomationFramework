package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the Register form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String, String> formDataMap) throws InterruptedException {
        String firstNameValue = formDataMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")){
            firstNameValue = RandomDataManager.generateFirstName();
        }
        String lastNameValue = formDataMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = RandomDataManager.generateLastName();
        }
        String emailInput = formDataMap.get("email");
        if (emailInput !=null && emailInput.equalsIgnoreCase("RANDOM")){
            emailInput = RandomDataManager.generateRandomEmail();
        }
        String password = formDataMap.get("password");
        if (password != null && password.equalsIgnoreCase("RANDOM")){
            password = RandomDataManager.generatePassword();
        }

        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailInput, password, true);
        Thread.sleep(1000);
    }
    @And("Continue Button is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        registerPage.clickTheContinueButton();
    }
}