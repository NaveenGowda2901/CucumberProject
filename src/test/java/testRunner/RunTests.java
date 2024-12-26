package testRunner;

import org.junit.runner.RunWith;
import org.testng.TestNG;
import org.testng.annotations.Listeners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.ScreenshotListener;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/search.feature",
				 glue = {"stepDefinitions", "hooks"},
				 monochrome = true,
				 publish = true,
				plugin = {"pretty", 
						  "json:Reports-output/Reportsjson/jsonReport.json",
						  "junit:Reports-output/Reportsxml/xmlReport.xml",
						  "html:Reports-output/Reportshtml/htmlReport.html",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				tags = "@sanity",
				 dryRun = false
				)

public class RunTests {
	 
}
