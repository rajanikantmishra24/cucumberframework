package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue={"StepDefinitions"},
		plugin = { "pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json" },
		tags = "@LoginAll",
		monochrome = false
		
		
		)
public class TestRunner {

}
