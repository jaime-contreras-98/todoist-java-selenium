package pom.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    public By logoBtn = By.cssSelector("#todoist_app > div > div > div > a");
    public By userInp = By.id("element-0");
    public By userPswd = By.id("element-3");
    public By loginBtn = By.xpath("//*[@data-gtm-id='start-email-login']");
    public By errorLbl = By.xpath("//form[@class] /div[contains(@class,'a83bd4e0')]");

}
