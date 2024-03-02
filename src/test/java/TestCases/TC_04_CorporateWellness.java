package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.CorporateWellness;

public class TC_04_CorporateWellness extends BaseClass {

	CorporateWellness cw;

	@Test(priority = 1)
	public void corporateLink() {
		cw = new CorporateWellness(driver);
		logger.info("***TC_04_CorporateWellness***");
		cw.Click_CorporateWellness();

	}

	@Test(priority = 2)
	public void detailsInvalid() throws IOException {
		cw.Enter_DetailsInvalid();
		logger.info("details entered");
	}

	@Test(priority = 3)
	public void sizeOfOrganizationAndInterest() throws IOException {
		cw.organization_size_and_Interest();
		logger.info("orgniztion size is selected");
		captureScreen("invalid");
	}

	@Test(priority = 4)
	public void SubmitButton() throws InterruptedException, IOException {
		cw.Click_Button();
		captureScreen("messge1");
		logger.info("submit button is clicked");
	}

	@Test(priority = 5)
	public void clear() throws InterruptedException {
		cw.clearDetail();
	}

	@Test(priority = 6)
	public void detailsValid() throws IOException {
		cw.Enter_DetailsValid();
	}

	@Test(priority = 7)
	public void organization_size_and_Interest() {
		cw.organization_size_and_Interest();
		logger.info("orgniztion size is selected");
	}

	@Test(priority = 8)
	public void SubmitButton1() throws InterruptedException, IOException {
		cw.Click_Button();
		captureScreen("messge");
		logger.info("submit button is clicked");
	}

}
