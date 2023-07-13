package helpers;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Components {

    public WebDriver driver;
    public WebDriverWait wait;
    private Dotenv dotenv;

    public Components(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver initializeWebDriver() {
        dotenv = Dotenv.configure().load();
        String browser = dotenv.get("browser");

        if (browser.equalsIgnoreCase("Chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("Firefox"))
            driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();

        return driver;
    }

    public void waitForElementToAppear(By findBy) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File source = screen.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");

        FileUtils.copyFile(source, file);

        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

}
