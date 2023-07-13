package pom.pages;

import helpers.Components;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pom.locators.Home;

public class HomePage extends Components {

    WebDriver driver;
    Home home = new Home();

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void waitForBarLogo() {
        waitForElementToAppear(home.topBar);

        Assert.assertTrue(true);
    }

    public void clickOnInbox() {
        driver.findElement(home.inboxBtn).click();
    }

    public void addTask(String name, String descr) {
        driver.findElement(home.addTaskBtn).click();
        driver.findElement(home.taskNameInp).sendKeys(name);
        driver.findElement(home.taskDescInp).sendKeys(descr);
        driver.findElement(home.saveTaskBtn).click();
    }

    public void addTaskDate(String name, String descr, String date) {
        driver.findElement(home.addTaskBtn).click();
        driver.findElement(home.taskNameInp).sendKeys(name);
        driver.findElement(home.taskDescInp).sendKeys(descr);
        driver.findElement(home.setDateBtn).click();
        if (date.equalsIgnoreCase("Today"))
            driver.findElement(home.dateTodayBtn).click();
        else if (date.equalsIgnoreCase("Tomorrow"))
            driver.findElement(home.dateTomorrowBtn).click();
        else if (date.equalsIgnoreCase("Next week"))
            driver.findElement(home.dateNxtWeekBtn).click();
        driver.findElement(home.saveTaskBtn).click();
    }

}
