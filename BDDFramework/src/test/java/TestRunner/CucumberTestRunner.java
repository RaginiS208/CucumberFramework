package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

/*
@CucumberOptions(tags="@TC1,@TC2", features = {"src/test/resources/Features"},
glue ={"StepDefinitions"},
plugin={"pretty","html:target/htmlreport.html"}
)
*/

@CucumberOptions(
	    features = "src/test/resources/Features",  // Path to all feature files
	    glue = {"StepDefinitions"},               // Include all step definition classes in this package
	    plugin = {"pretty", "html:target/cucumber-reports.html"} // Report generation
	)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {


	
}
