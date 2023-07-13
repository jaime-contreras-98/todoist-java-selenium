package tests;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.pages.IndexPage;
import pom.pages.LoginPage;

public class FirstTest {

    WebDriver driver;
    IndexPage index;
    LoginPage login;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        index = new IndexPage(driver);
        login = new LoginPage(driver);

        driver.get("https://todoist.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest(){
        index.clickOn();
        login.loginForm("Hola","Pedro");
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterAll
    public void afterAllTests(){

    }

    @BeforeAll
    public void beforeAllTests(){

    }
}
