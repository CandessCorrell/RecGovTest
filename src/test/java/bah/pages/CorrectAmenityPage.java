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

@DefaultUrl("https://www-dev.projectzion.org/")
public class CorrectAmenityPage extends PageObject {

    @FindBy(xpath = "//*[@placeholder = 'Where are you going?']")
    private WebElementFacade searchTerms;



    @FindBy(xpath = "//*[contains(@class, 'rec-button-primary rec-button-full submitsearchbutton')]")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.className("campgroundlisting-component"));
        List<WebElement> results = definitionList.findElements(By.tagName("span"));
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