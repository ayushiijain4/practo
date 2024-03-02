package StepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DoctorsDetail;

public class Doctor_Detail{
	WebDriver driver;
	 Logger logger;
	Properties p;
	DoctorsDetail dt;
	
	@Given("user is on search doctor page")
	public void user_is_on_search_doctor_page() throws InterruptedException {
		driver=Hooks.getDriver();
		   logger=Hooks.getLogger();
		   p=Hooks.getProperties();
	   dt=new DoctorsDetail(driver);
	   dt.url();
	    
	}

	@When("user selects patient story filter")
	public void user_selects_patient_story_filter() throws InterruptedException {
		dt.clickOnStory();
		dt.Select_Patient_Story();
		logger.info("filter for patient story is selected ");
	   
	   
	}

	@When("user selects doctor experience  filter")
	public void user_selects_doctor_experience_filter() throws InterruptedException {
		dt.clickOnExperience();
		dt.Select_Doctor_Experience();
		logger.info("filter for doctor experience is selected");
	   
	    
	}

	@When("user selects filter for fee and availablity")
	public void user_selects_filter_for_fee_and_availablity() throws InterruptedException {
		dt.Select_Filter();
		logger.info("filter for fees and availablity is selected");
	   
	}

	@When("user clicks on sortBy dropDown")
	public void user_clicks_on_sort_by_drop_down() {
		dt.clickOnSortBy();
		logger.info("sort by is clicked");
	   
	}

	@When("user selects the sortBy option")
	public void user_selects_the_sort_by_option() throws InterruptedException {
		dt.selectSort();
		logger.info("results are sorted");
	    
	}

	@Then("top five doctors name is captured")
	public void top_five_doctors_name_is_captured() throws InterruptedException, IOException {
		dt.ScrollPage();
		logger.info("page is scroll down");
		dt.Top_Five_Doctor_Name();
		logger.info("list of top 5 doctor's name is printed");
	    
	}

	@Then("top five doctors experience is captured")
	public void top_five_doctors_experience_is_captured() throws IOException {
		dt.Doctor_Experience();
		logger.info("list of top 5 doctor's experience is printed");
	   
	}

	@Then("top five clinic name is captured")
	public void top_five_clinic_name_is_captured() throws IOException {
		dt.clinic();
		logger.info("list of top 5 doctor's clinic is printed");
	    
	}

	@Then("top five doctors practice locality is captured")
	public void top_five_doctors_practice_locality_is_captured() throws IOException {
		dt.PracticeLocality();
		logger.info("list of top 5 doctor's clinic location is printed");
	   
	}

	@Then("top five doctors consultation fee is captured")
	public void top_five_doctors_consultation_fee_is_captured() throws IOException {
		dt.consultationFee();
		logger.info("list of top 5 doctor's consultation fee is printed");
	    
	}
	


}
