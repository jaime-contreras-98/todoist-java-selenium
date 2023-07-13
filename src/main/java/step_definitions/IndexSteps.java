package step_definitions;

import helpers.World;
import io.cucumber.java.en.Then;
import pom.pages.IndexPage;

public class IndexSteps {

    private World world;

    public IndexSteps(World world) {
        this.world = world;
        this.world.index = new IndexPage(world.driver);
    }

    @Then("click on Login section")
    public void click_on_Login_section() {
        world.index.clickOn();
    }

    /*
    @Given("I go to mainpage")
    public void given_i_go_to_mainPage() {
        world.driver = new ChromeDriver();
        world.index = new IndexPage(world.driver);

        world.driver.manage().window().maximize();
        world.driver.get("https://todoist.com/");
    }
    */

}
