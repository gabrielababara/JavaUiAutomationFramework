package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();
        RegisterPage registerPage = new RegisterPage(driver);

        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);

        String password = RandomDataManager.generatePassword();
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);

        registerPage.clickTheContinueButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInTheLoginFrom(randomEmail, password);
        loginPage.clickLoginBtn();

        DriverManager.getInstance().tearDown();

        System.out.println("The execution is over");
    }
}