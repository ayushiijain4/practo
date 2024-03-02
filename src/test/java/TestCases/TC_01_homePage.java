package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import factory.BaseClass;
import pageObjects.homePage;

public class TC_01_homePage extends BaseClass {
	homePage hp;

	@Test(priority = 1)
	public void Search_For_Doctor() throws InterruptedException {
		hp = new homePage(driver);
		logger.info("***TC_01_homePage started***");
		hp.Find_Doctor_button();
	}

	@Test(priority = 2)
	public void Select_Location() {
		hp.Enter_location(p.getProperty("location"));
		logger.info("location is selected");

	}

	@Test(priority = 3)
	public void Select_Area() {
		hp.Select_Area();
		logger.info("locality is selected");
	}

	@Test(priority = 4)
	public void Select_doctor() throws InterruptedException, IOException {
		hp.Select_Speciality(p.getProperty("speciality"));
		captureScreen("HomePage");

		hp.Select_Doctor("dentist");
		logger.info("speciality is selected");
	}

}
