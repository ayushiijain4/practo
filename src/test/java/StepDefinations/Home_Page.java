package StepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;

public class Home_Page  {
	WebDriver driver;
	 Logger logger;
	Properties p;
	 homePage pg;
	Hooks hk;

	@Given("user is on homepage")
	public void user_is_on_homepage() throws IOException {
		driver=Hooks.getDriver();
		   logger=Hooks.getLogger();
		   p=Hooks.getProperties();
		pg = new homePage(driver);
		

		
		logger.info("***TC_01_homePage started***");

	}

	@Given("user clicks on find doctor button")
	public void user_clicks_on_find_doctor_button() {
		pg.Find_Doctor_button();
		
	}

	@When("user enters location")
	public void user_enters_location() {
		pg.Enter_location(p.getProperty("location"));
		logger.info("location is selected");
	}

	@When("user selects area")
	public void user_selects_area() {
		pg.Select_Area();
		logger.info("locality is selected");
	}

	@Then("user enters speciality")
	public void user_enters_speciality() throws InterruptedException {
		pg.Select_Speciality(p.getProperty("speciality"));
	}

	@Then("user selects doctor")
	public void user_selects_doctor() throws InterruptedException {
		pg.Select_Doctor("dentist");
		logger.info("speciality is selected");

	}
	

}
