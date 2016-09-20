package bah.steps.serenity;

import bah.pages.ClosestLocationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndLocationSteps extends ScenarioSteps {

    ClosestLocationPage locationPage;

    @Step
    public void enters(String keyword) {
        locationPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        locationPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(locationPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        locationPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}