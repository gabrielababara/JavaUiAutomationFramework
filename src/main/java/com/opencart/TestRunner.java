package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();
        //New window code
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");
        Thread.sleep(1000);
        WebElement myAccountIcon = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
        myAccountIcon.click();
        WebElement registerOption = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerOption.click();
        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);
        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);

        WebElement registerBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement termsAndConditionToggleBar = driver.findElement(By.xpath("//input[@name='agree']"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", termsAndConditionToggleBar);
        Thread.sleep(3000);
        termsAndConditionToggleBar.click();
        registerBtn.click();
        driver.close();
        driver.quit();

        System.out.println("The execution is over");
    }
}