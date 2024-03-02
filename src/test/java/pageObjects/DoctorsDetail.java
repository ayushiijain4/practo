package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ExcelUtils.ExcelOutputUtils;

public class DoctorsDetail extends BasePage {
	// public WebDriver driver;
	public JavascriptExecutor js = (JavascriptExecutor) driver;

	public DoctorsDetail(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@data-qa-id='doctor_review_count_section']")
	WebElement story;

	@FindBy(xpath = "//*[@class='c-dropdown__list']/li")
	List<WebElement> patientStory;

	@FindBy(xpath = "//div[@data-qa-id='years_of_experience_section']")
	WebElement docExp;

	@FindBy(xpath = "//*[@class='c-dropdown__list']/li")
	List<WebElement> experience;

	@FindBy(xpath = "//span[normalize-space()='All Filters']")
	WebElement allFilter;

	@FindBy(xpath = "//span[@data-qa-id='₹0-₹500_label']")
	WebElement Fee;

	@FindBy(xpath = "//label[@for='Availability2']")
	WebElement availablity;

	@FindBy(xpath = "//span[@data-qa-id='sort_by_selected']")
	WebElement sort;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li")
	List<WebElement> sorttt;
	
	@FindBy(xpath="//*[@id='container']/div/div[4]/div/div[1]/div/div[2]/div[2]")
	WebElement scrollTill1;

	@FindBy(xpath = "//button[@class='c-guided-filter']")
	WebElement scrollTill2;

	@FindBy(xpath = "//h2[@data-qa-id='doctor_name']")
	List<WebElement> docName;

	@FindBy(xpath = "//div[@data-qa-id='doctor_experience']")
	List<WebElement> exper;

	@FindBy(xpath = "//span[@data-qa-id='doctor_clinic_name']")
	List<WebElement> Clinic;

	@FindBy(xpath="//span[@data-qa-id='practice_locality']")
	List<WebElement>practice;
	
	@FindBy(xpath="//span[@data-qa-id='consultation_fee']")
	List<WebElement> fee;

	public void clickOnStory() {
		story.click();

	}
	public void url() {
		String Title=driver.getTitle();
		
	}

	public void Select_Patient_Story() throws InterruptedException {
		for (int i = 0; i < patientStory.size(); i++) {
			String text = patientStory.get(i).getText();
			if (text.equalsIgnoreCase("10+ Patient Stories")) {
				patientStory.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);

	}

	public void clickOnExperience() {
		docExp.click();
	}

	public void Select_Doctor_Experience() throws InterruptedException {

		for (int i = 0; i < experience.size(); i++) {
			String Textexp = experience.get(i).getText();
			if (Textexp.equalsIgnoreCase("5+ Years of experience")) {
				experience.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
	}

	public void Select_Filter() throws InterruptedException {

		allFilter.click();
		Fee.click();
		Thread.sleep(5000);
		allFilter.click();
		availablity.click();
		Thread.sleep(5000);
	}

	public void clickOnSortBy() {
		sort.click();

	}

	public void selectSort() throws InterruptedException {

		Thread.sleep(2000);

		for (int i = 0; i < sorttt.size(); i++) {
			String sorting = sorttt.get(i).getText();
			if (sorting.equalsIgnoreCase("Experience - High to Low")) {
				sorttt.get(i).click();

				break;

			}
		}
		Thread.sleep(8000);
	}

	public void ScrollPage() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", scrollTill1);
		Thread.sleep(10000);
		js.executeScript("arguments[0].scrollIntoView();", scrollTill2);
		

	}

	public void Top_Five_Doctor_Name() throws IOException {

		ExcelOutputUtils.setCellData("Sheet1", 1, 0, "DOCTOR'S NAME");

		for (int i = 0; i < 5; i++) {
			String data = docName.get(i).getText();
			ExcelOutputUtils.setCellData("Sheet1", i + 2, 0, data);
			// System.out.println(docName.get(i).getText());

		}
	}

	public void Doctor_Experience() throws IOException {

		ExcelOutputUtils.setCellData("Sheet1", 1, 3, "DOCTOR'S EXPERIENCE");

		for (int i = 0; i < 5; i++) {
			String data2 = exper.get(i).getText();
			ExcelOutputUtils.setCellData("Sheet1", i + 2, 3, data2);
			// System.out.println(docName.get(i).getText());

		}

	}

	public void clinic() throws IOException {
		ExcelOutputUtils.setCellData("Sheet1", 1, 7, "DOCTOR'S CLINIC");

		for (int i = 0; i < 5; i++) {
			String data3 = Clinic.get(i).getText();
			ExcelOutputUtils.setCellData("Sheet1", i + 2, 7, data3);

		}

	}

	public void PracticeLocality() throws IOException {
		ExcelOutputUtils.setCellData("Sheet1", 1, 11, "PRACTICE LOCALITY");

		for (int i = 0; i < 5; i++) {
			String data4 = practice.get(i).getText();
			ExcelOutputUtils.setCellData("Sheet1", i + 2, 11, data4);

		}

	}
	
	public void consultationFee() throws IOException {
		
		ExcelOutputUtils.setCellData("Sheet1", 1, 14, "CONSULTATION FEE");

		for (int i = 0; i < 5; i++) {
			String data5 = fee.get(i).getText();
			ExcelOutputUtils.setCellData("Sheet1", i + 2, 14, data5);

		}
	}

}
