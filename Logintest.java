package com.ticketbooking.test;

import com.ticketbooking.pages.loginpage;
import org.openqa.selenium.webdriver;
import org.openqa.selenium.chrome.chromedriver;
import org.openqa.selenium.chrome.chromeoptions;
import org.testng.assert;
import org.testng.annotations.*;
import java.util.hashmap;
import java.util.map;

public class logintest {
    webdriver driver;
    loginpage loginpage;

    @beforemethod
    public void setup() {
        system.setproperty("webdriver.chrome.driver", "chromedriver.exe");

        chromeoptions options = new chromeoptions();
        options.addarguments("--disable-notifications");
        options.addarguments("--disable-popup-blocking");
        options.addarguments("--disable-save-password-bubble");
        options.addarguments("--disable-infobars");
        options.addarguments("--disable-extensions");
        options.addarguments("--start-maximized");
        options.addarguments("--remote-allow-origins=*");

        map<string, object> prefs = new hashmap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setexperimentaloption("prefs", prefs);
        options.setexperimentaloption("excludeswitches", new string[]{"enable-automation"});
        options.setexperimentaloption("useautomationextension", false);

        driver = new chromedriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
        loginpage = new loginpage(driver);
    }
    @test
    public void testlogin() {
        loginpage.login("mercury", "mercury");

        string actualtitle = driver.gettitle();
        system.out.println("title after login: " + actualtitle);  

        assert.asserttrue(actualtitle.contains("mercury tours"), "login failed or incorrect title");
    }

    @aftermethod
    public void teardown() {
        driver.quit();
    }
}
