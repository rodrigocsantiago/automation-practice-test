package br.rsantiago.automation_practice.test.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {

    /**
     * Returns an instance of the WebDriver depending on the 'browser' System property.
     * Currently valid values are: FIREFOX or CHROME.
     * If this property is not provided the default browser is 'FIREFOX'.
     * @return WebDriver instance of the browser provided in 'browser' System property
     */
    public static WebDriver getDriver() {
        String browser = System.getProperty("browser");

        if (browser == null) browser = "FIREFOX";

        if ("FIREFOX".equals(browser.toUpperCase(Locale.ROOT))) {
            System.out.println("Browser is Firefox");
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("CHROME".equals(browser.toUpperCase(Locale.ROOT))) {
            System.out.println("Browser is Chrome");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else {
            throw new InvalidArgumentException("Invalid 'browser' parameter provided");
        }
    }
}
