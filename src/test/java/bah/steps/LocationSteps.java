package bah.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import bah.steps.serenity.EndLocationSteps;

public class LocationSteps {

    @Steps
    EndLocationSteps jeff;

    @Given("the user is on the Recs.gov home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        jeff.is_the_home_page();
    }

    @When("the user looks up the place '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        jeff.looks_for(word);
    }

    @Then("they should see at least a park '(.*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        jeff.should_see_definition(definition);
    }

}
