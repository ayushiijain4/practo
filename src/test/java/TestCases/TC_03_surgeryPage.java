package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.SurgeryPage;

public class TC_03_surgeryPage extends BaseClass {

	SurgeryPage sp;

	@Test(priority = 1)
	public void Click_On_surgery() throws InterruptedException {
		sp = new SurgeryPage(driver);
		logger.info("***TC_03_surgeryPage started***");
		sp.surgery_click();

	}

	@Test(priority = 2)
	public void pageScroll() throws Exception {
		sp = new SurgeryPage(driver);
		sp.Scroll();
		captureScreen("surgeryList");

		logger.info("page is scrolled");

	}

	@Test(priority = 3)
	public void Get_surgery_list() {
		try {
			sp.surgeryList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("surgery list is displayed");
	}

}
