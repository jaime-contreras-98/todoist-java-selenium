package step_definitions;

import helpers.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.pages.HomePage;

public class HomeSteps {
    private World world;

    public HomeSteps(World world) {
        this.world = world;
        this.world.home = new HomePage(world.driver);
    }

    @Then("I should see the homepage logo")
    public void i_should_see_the_homepage_logo() {
        world.home.waitForBarLogo();
    }

    @Given("I click on inbox section")
    public void i_click_on_inbox_section() {
        world.home.clickOnInbox();
    }

    @When("^I add a task \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_add_task(String name, String descr) {
        world.home.addTask(name, descr);
    }

    @When("^I add a task \"([^\"]*)\" with \"([^\"]*)\" for \"([^\"]*)\"$")
    public void i_add_task_date(String name, String descr, String date) {
        world.home.addTaskDate(name, descr, date);
    }

}
