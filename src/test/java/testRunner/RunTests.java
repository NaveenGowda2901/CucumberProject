package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\eclipseWorkspace\\CucmberAutomationFramework\\src\\test\\resources\\features\\cart.feature",
				 glue = {"stepDefinitions", "hooks"},
			//	 monochrome = true,
				 publish = true,
				 tags = "@sanity",
				 dryRun = false
				)


public class RunTests {

}
