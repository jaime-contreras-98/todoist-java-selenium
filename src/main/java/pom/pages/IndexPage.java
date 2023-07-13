package pom.pages;

import helpers.Components;
import pom.locators.Index;
import org.openqa.selenium.WebDriver;

public class IndexPage {

    WebDriver driver;
    Index index = new Index();

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOn(){
        driver.findElement(index.loginLink).click();
    }

}
