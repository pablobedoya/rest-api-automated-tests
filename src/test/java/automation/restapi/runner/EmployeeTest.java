package automation.restapi.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber-report/cucumber.json"},
				features = "classpath:features",
				glue = "automation.restapi.steps",
				monochrome = true,
				dryRun = false,
				publish = false)
public class EmployeeTest {

}
