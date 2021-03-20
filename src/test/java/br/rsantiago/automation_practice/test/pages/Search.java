package br.rsantiago.automation_practice.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the 'Search - MyStore' page, where the search results from Mystore page are displayed
 */
public class Search {

    private WebDriver driver;

    @FindBy(className = "heading-counter")
    private WebElement searchResultsQtyText;

    @FindBy(className = "lighter")
    private WebElement searchText;

    @FindBy(css = "p.alert.alert-warning")
    private WebElement noResultsMessage;

    /**
     * This is the error/alert message that displays when no search results are found
     * @return No search results found message
     */
    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }

    /**
     * This method extracts the number of results found from the full message containing the search results.
     * Sample message: 0 results have been found
     * @return Number of search results found
     */
    public int getNumberOfResults() {
        String[] searchResultsText = searchResultsQtyText.getText().split(" ");
        if (searchResultsText.length > 0) {
            try {
                return Integer.parseInt(searchResultsText[0]);
            } catch (NumberFormatException nfe) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * This is the search keyword used. This is displayed on search page
     * @return The search keyword used
     */
    public String getKeywordUsed() {
        return this.searchText.getText().replace("\"", "");
    }

    public Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
