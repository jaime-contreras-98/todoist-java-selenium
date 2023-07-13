package helpers;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import pom.pages.HomePage;
import pom.pages.IndexPage;
import pom.pages.LoginPage;

public class World {

    public WebDriver driver;
    public Components comps;
    public IndexPage index;
    public LoginPage login;
    public HomePage home;
    public Dotenv dotenv;

}
