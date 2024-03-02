package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends BasePage {
	WebDriver driver;

	public homePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a/div[normalize-space()='Find Doctors']")
	WebElement findButton;

	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-locality']")
	WebElement location;

	@FindBy(xpath = "//div[@data-qa-id='omni-suggestion-entire-city']")
	WebElement Area;

	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement speciality;

	@FindBy(xpath = "//div[@class='c-omni-suggestion-item__content__title']")
	List<WebElement> list;

	public void Find_Doctor_button() {
		findButton.click();
	}

	public void Enter_location(String loc) {
		location.clear();
		location.sendKeys(loc);
	}

	public void Select_Area() {
		Area.click();
	}

	public void Select_Speciality(String doc) throws InterruptedException {
		speciality.sendKeys(doc);
		Thread.sleep(2000);
	}

	public void Select_Doctor(String doc) throws InterruptedException

	{
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.equalsIgnoreCase(doc)) {
				list.get(i).click();
				break;
			}
		}
		Thread.sleep(4000);
	}
}
