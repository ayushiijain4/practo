package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ExcelUtils.ExcelInputUtils;

public class CorporateWellness extends BasePage {
	WebDriver driver;

	public CorporateWellness(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='For Corporates']")
	WebElement corporatebtn;

	@FindBy(xpath = "//a[normalize-space()='Health & Wellness Plans']")
	WebElement healthOption;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='organizationName']")
	WebElement organizationName;

	@FindBy(xpath = "//input[@id=\"contactNumber\"]")
	WebElement contactNumber;

	@FindBy(xpath = "//input[@id='officialEmailId']")
	WebElement officialEmailId;

	@FindBy(xpath = "//select[@id='organizationSize']")
	WebElement drop;

	@FindBy(xpath = "//select[@id='interestedIn']")
	WebElement interest;

	@FindBy(xpath = "//button[normalize-space()='Schedule a demo']")
	WebElement button;

	@FindBy(xpath = "//div[@class='u-text--bold text-alpha']")
	WebElement dispalyed;

	public void Click_CorporateWellness() {
		corporatebtn.click();
		healthOption.click();
	}

	public void Enter_DetailsInvalid() throws IOException {
		List<String> mylist=ExcelInputUtils.InvalidData();
		
		name.sendKeys(mylist.get(0));
		
		organizationName.sendKeys(mylist.get(1));
		
		contactNumber.sendKeys(mylist.get(2));
		
		
		officialEmailId.sendKeys(mylist.get(3));
	}
	
	
	

	public void organization_size_and_Interest() {
		Select size = new Select(drop);
		size.selectByVisibleText("10001+");
		Select interested = new Select(interest);
		interested.selectByVisibleText("Taking a demo");
	}

	

	public void Click_Button() throws InterruptedException, IOException {
		boolean check = button.isEnabled();
		if (check == true) {
			button.click();
			Thread.sleep(15000);
			String message = dispalyed.getText();
			System.out.println(message);
		} else {
			
	        System.out.println("not enabled");
		}
		
	}
	
	public void clearDetail() throws InterruptedException {
		name.clear();
		organizationName.clear();
		contactNumber.clear();
		officialEmailId.clear();
		Thread.sleep(2000);
	}
	
	public void Enter_DetailsValid() throws IOException {
		List<String> mylist2=ExcelInputUtils.validData();
		name.sendKeys(mylist2.get(0));
		
		organizationName.sendKeys(mylist2.get(1));
		
		contactNumber.sendKeys(mylist2.get(2));
		
		
		officialEmailId.sendKeys(mylist2.get(3));
		
		
	}
	
}
