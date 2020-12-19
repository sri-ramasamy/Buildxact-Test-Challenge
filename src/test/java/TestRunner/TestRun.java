package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features", 
		glue="StepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/output.html","junit:target/cucumber-reports/cucumber.xml"})

public class TestRun {
	

}
