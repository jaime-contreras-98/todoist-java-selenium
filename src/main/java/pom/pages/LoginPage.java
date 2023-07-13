package pom.pages;

import helpers.Components;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pom.locators.Login;

public class LoginPage extends Components {

    WebDriver driver;
    Login login = new Login();

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void loginForm(String username, String password) {
        waitForElementToAppear(login.logoBtn);

        driver.findElement(login.userInp).sendKeys(username);
        driver.findElement(login.userPswd).sendKeys(password);
        driver.findElement(login.loginBtn).click();
    }

    public void waitForErrorMsg(String errorMsg) {
        waitForElementToAppear(login.errorLbl);

        String msg = driver.findElement(login.errorLbl).getText();
        Assert.assertEquals(errorMsg, msg);
    }

}
