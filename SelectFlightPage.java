package com.ticketbooking.pages;

import org.openqa.selenium.by;
import org.openqa.selenium.webdriver;

public class selectflightpage {
    webdriver driver;

    public selectflightpage(webdriver driver) {
        this.driver = driver;
    }

    public void chooseflight() {
        driver.findelement(by.name("outflight")).click();
        driver.findelement(by.name("inflight")).click();
        driver.findelement(by.name("reserveflights")).click();
    }
}
