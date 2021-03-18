package br.rsantiago.automation_practice.test.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFramework {

    public enum BrowserType {
        CHROME,
        FIREFOX
    }

    public static WebDriver launchBrowser(BrowserType browserType) {

        WebDriver driver = null;

        if (browserType == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", "");
            driver = new ChromeDriver();
        } else if (browserType == BrowserType.FIREFOX) {
            System.setProperty("webdriver.firefox.driver", "");
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
