package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Feature file"},
		glue="StepDefinations",
				plugin= {"pretty","html:reports/cucumber_reprot/cucumber-report/report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=true,
		publish=true
		)

public class runTest {

}

