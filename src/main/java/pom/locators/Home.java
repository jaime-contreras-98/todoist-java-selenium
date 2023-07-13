package pom.locators;

import org.openqa.selenium.By;

public class Home {
    public By topBar = By.id("top_bar_inner");
    public By inboxBtn = By.cssSelector("li[id='filter_inbox'] > div > div > a");
    public By addTaskBtn = By.xpath("//button[@class='plus_add_button']");
    public By taskNameInp = By.cssSelector("div[class*='content_field'] > div > p");
    public By taskDescInp = By.cssSelector("div[class*='description_field'] > div > p");
    public By setDateBtn = By.cssSelector("form[class*='task_editor'] > div > div:nth-child(2) > div > div:nth-child(1)");
    public By dateTodayBtn = By.xpath("//div[@class='scheduler'] /div[2] /button[1]");
    public By dateTomorrowBtn = By.xpath("//div[@class='scheduler'] /div[2] /button[2]");
    public By dateNxtWeekBtn = By.xpath("//div[@class='scheduler'] /div[2] /button[3]");
    public By saveTaskBtn = By.xpath("//button[@data-testid='task-editor-submit-button']");

}
