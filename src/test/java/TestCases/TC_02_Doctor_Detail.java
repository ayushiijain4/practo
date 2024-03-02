package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.DoctorsDetail;

public class TC_02_Doctor_Detail extends BaseClass {

	DoctorsDetail dd;

	@Test(priority = 1)
	public void click() {
		dd = new DoctorsDetail(driver);
		logger.info("****TC_02_Doctor_Detail started****");
		dd.clickOnStory();

	}

	@Test(priority = 2)
	public void select_patientStory() throws InterruptedException {

		dd.Select_Patient_Story();
		logger.info("filter for patient story is selected ");
	}

	@Test(priority = 3)
	public void selectExperience() throws InterruptedException {
		dd.clickOnExperience();
		dd.Select_Doctor_Experience();
		logger.info("filter for doctor experience is selected");

	}

	@Test(priority = 4)
	public void selectFilter() throws InterruptedException {
		dd.Select_Filter();
		logger.info("filter for fees and availablity is selected");
	}

	@Test(priority = 5)
	public void clickSort() {
		dd.clickOnSortBy();
		logger.info("sort by is clicked");

	}

	@Test(priority = 6)
	public void selectRelevance() throws InterruptedException {
		dd.selectSort();
		logger.info("results are sorted");

	}

	@Test(priority = 7)
	public void scrollDown() throws InterruptedException, IOException {
		dd.ScrollPage();
		captureScreen("namedoc1");

		logger.info("page is scroll down");
	}

	@Test(priority = 8)
	public void getDoctorName() throws IOException {
		dd.Top_Five_Doctor_Name();
		logger.info("list of top 5 doctor's name is printed");
	}

	@Test(priority = 9)
	public void getDoctorExperience() throws IOException {
		dd.Doctor_Experience();
		logger.info("list of top 5 doctor's experience is printed");
	}

	@Test(priority = 10)
	public void getClinicName() throws IOException {
		dd.clinic();
		logger.info("list of top 5 doctor's clinic is printed");
	}

	@Test(priority = 11)
	public void getPracticeLocality() throws IOException {
		dd.PracticeLocality();
		logger.info("list of top 5 doctor's clinic location is printed");
	}

	@Test(priority = 12)
	public void getConsultationFee() throws IOException {
		dd.consultationFee();
		logger.info("list of top 5 doctor's consultation fee is printed");
	}

}
