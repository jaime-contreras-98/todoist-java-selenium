package step_definitions;

import helpers.Components;
import helpers.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GeneralSteps {

    private World world;

    public GeneralSteps(World world) {
        this.world = world;
        this.world.comps = new Components(world.driver);
    }

    @Given("^I go to page (.+)")
    public void i_go_to_page_string(String page) {
        world.driver = world.comps.initializeWebDriver();

        world.driver.manage().window().maximize();
        world.driver.get(page);
    }

    /*
    @When("^I click on (.+)")
    public void i_click_on_element() {
    }
     */

    @Then("I close my browser")
    public void i_should_close_my_browser() {
        world.driver.quit();
    }
}
