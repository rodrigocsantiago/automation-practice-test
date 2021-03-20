package br.rsantiago.automation_practice.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the landing page of the http://automationpractice.com website
 */
public class MyStore {

    private static final String DEFAULT_URL = "http://automationpractice.com";
    private final WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement search;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    /**
     * Searches for a product by entering text on Search text field and pressing the search button
     * The end result is the navigation to the 'MyStore - Search' page
     * @param keyword The keyword to be used in search
     * @return Reference to the Search page, where search results are displayed
     */
    public Search searchProduct(String keyword) {
        search.sendKeys(keyword);
        searchButton.click();
        return new Search(driver);
    }

    public MyStore(WebDriver driver) {
        this.driver = driver;

        String url = System.getProperty("url");
        if (url == null) url = DEFAULT_URL;

        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }
}
