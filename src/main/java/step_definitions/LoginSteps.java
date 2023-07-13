package step_definitions;

import helpers.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;
import pom.pages.LoginPage;

public class LoginSteps {

    private World world;

    public LoginSteps(World world) {
        this.world = world;
        this.world.login = new LoginPage(world.driver);
    }

    @Given("^I introduce credentials (.+) and (.+)")
    public void given_i_introduce_credentials(String username, String password) {
        world.login.loginForm(username, password);
    }

    @Given("I introduce proper credentials")
    public void given_i_introduce_proper_credentials() {
        world.dotenv = Dotenv.configure().load();

        world.login.loginForm(world.dotenv.get("username") + "@agilethought.com", world.dotenv.get("password"));
    }

    @Then("^I should see the fail message \"([^\"]*)\"$")
    public void i_should_see_the_fail_message(String error) {
        world.login.waitForErrorMsg(error);
    }

}
