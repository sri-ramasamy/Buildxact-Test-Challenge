# Buildxact-Test-Challenge

Pre-requisites:

Java JDK 11
Chrome version 87

1. Run tests from TestRunner>TestRun.java
2. Change the features to run specific feature scenario say features=".//Features/login.feature"
@CucumberOptions(
		features=".//Features",  
		glue="StepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports/output.html","junit:target/cucumber-reports/cucumber.xml"})
    
    
