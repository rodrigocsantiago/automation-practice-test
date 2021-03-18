package br.rsantiago.automation_practice.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyStore {

    private final WebDriver driver;



    public MyStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
