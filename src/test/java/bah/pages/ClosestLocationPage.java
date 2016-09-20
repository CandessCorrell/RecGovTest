package bah.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://www-dev.projectzion.org/") //The default location for where you start your test from
public class ClosestLocationPage extends PageObject {

    @FindBy(xpath = "//*[@placeholder = 'Where are you going?']") //Specify the html tag for the text input box I'm trying to search in as the input box is the only html tag with the placeholder tag
    private WebElementFacade searchTerms;



    @FindBy(xpath = "//*[contains(@class, 'rec-button-primary rec-button-full submitsearchbutton')]") //The class name for the "search" button is called rec-button-primary rec-button-full... so it tells the test app. to click this button to search the entered term
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.className("campgroundlisting-component")); //the div tag containing only the search results
        List<WebElement> results = definitionList.findElements(By.tagName("span")); //<span></span> is the name of the html that contains the locations i.e. "Near Yosemite National Park, CA"
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}