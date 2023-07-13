package execution;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "step_definitions", monochrome = true, tags = "@Login", plugin = {
        "html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
