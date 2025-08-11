package com.ticketbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(By.name("submit")).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
