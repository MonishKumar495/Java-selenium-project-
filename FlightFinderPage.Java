package com.ticketbooking.pages;

import org.openqa.selenium.by;
import org.openqa.selenium.webdriver;

public class flightfinderpage {
    webdriver driver;

    public flightfinderpage(webdriver driver) {
        this.driver = driver;
    }

    public void selecttriptype() {
        driver.findelement(by.xpath("//input[@value='roundtrip']")).click();
    }

    public void clickcontinue() {
        driver.findelement(by.name("findflights")).click();
    }

    public void searchflights(string fromport, string toport) {
        driver.findelement(by.name("fromport")).sendkeys(fromport);
        driver.findelement(by.name("toport")).sendkeys(toport);
        clickcontinue();
    }
}
