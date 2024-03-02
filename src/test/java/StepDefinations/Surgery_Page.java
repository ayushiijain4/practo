package StepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SurgeryPage;

public class Surgery_Page {
	SurgeryPage sr;
	 WebDriver driver;
	 Logger logger;
	Properties p;
	

@Given("user is on surgery page")
public void user_is_on_surgery_page() throws InterruptedException {
   driver=Hooks.getDriver();
   logger=Hooks.getLogger();
   p=Hooks.getProperties();
   sr=new SurgeryPage(driver);
   
	sr.surgery_click();
	logger.info("surger link is clicked");
   
}

@When("page is scrolled to see lists")
public void page_is_scrolled_to_see_lists() throws Exception {
	sr.Scroll();
	
	
	logger.info("page is scrolled");
    
}

@Then("popular surgery list is captured")
public void popular_surgery_list_is_captured() {
	try {
		sr.surgeryList();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	logger.info("surgery list is displayed");
}


}





