package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith (Cucumber.class)
@CucumberOptions(features="src/test/resources/feature",glue = {"StepDefinition"},
monochrome = true,
plugin = {"pretty",
		"json:target/cucumber-report/cucumber.json",
        "html:target/cucumber-report/cucumber.html",
        "junit:target/cucumber-report/cucumber.xml"}
//tags="@smoketest"
)
public class TestRunner {

}
