package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/loginDTT.feature",
				 glue = {"stepDefinitions", "hooks"},
			//	 monochrome = true,
				 publish = true,
			//	 tags = "@sanity",
				plugin = {"pretty", 
						  "json:Reportsjson/jsonReport.json",
						  "junit:Reportsxml/xmlReport.xml",
						  "html:Reportshtml/htmlReport.html",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				 dryRun = false
				)
public class RunTests {

}
