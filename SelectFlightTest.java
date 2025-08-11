package com.ticketbooking.test;

import com.ticketbooking.pages.FlightFinderPage;
import com.ticketbooking.pages.LoginPage;
import com.ticketbooking.pages.SelectFlightPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class SelectFlightTest {
    WebDriver driver;
    LoginPage loginPage;
    FlightFinderPage flightFinderPage;
    SelectFlightPage selectFlightPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");

        loginPage = new LoginPage(driver);
        flightFinderPage = new FlightFinderPage(driver);
        selectFlightPage = new SelectFlightPage(driver);
    }

    @Test
    public void testSelectFlight() {
        loginPage.login("mercury", "mercury");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Find a Flight"));

        flightFinderPage.selectTripType();
        flightFinderPage.searchFlights("London", "New York");

        wait.until(ExpectedConditions.titleContains("Select a Flight"));

        selectFlightPage.chooseFlight();

        assertTrue(driver.getTitle().contains("Book a Flight"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
