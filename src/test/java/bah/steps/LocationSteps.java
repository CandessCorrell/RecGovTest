package bah.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import bah.steps.serenity.EndLocationSteps;

public class LocationSteps {

    //This is the template for creating tests for more specific things that the tester would put in the LookupALocation.feature
    @Steps
    EndLocationSteps jeff;

    @Given("the user is on the Recs.gov home page") //This test determines if the test app's starting website is correct
    public void givenTheUserIsOnTheWikionaryHomePage() {
        jeff.is_the_home_page();
    }

    @When("the user looks up the place '(.*)'")  //The thing in the (.*) basically just represents what the user would type in that the testing app. would automatically type into the text input box i.e. "Yosemite" or "Grand Canyon" based on what you type in LookupALocation.feature
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        jeff.looks_for(word);
    }

    @Then("they should see at least a park '(.*)'") //What the
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        jeff.should_see_definition(definition);
    }

}
