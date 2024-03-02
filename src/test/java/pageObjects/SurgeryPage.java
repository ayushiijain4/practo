package pageObjects;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ExcelUtils.ExcelOutputUtils;

public class SurgeryPage extends BasePage {
	public JavascriptExecutor js = (JavascriptExecutor) driver;

	public SurgeryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(text(),'Surgeries')]")
	WebElement surgery;

	@FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[4]/div[2]/div/div[1]/p[1]")
	WebElement scroll;

	@FindBy(xpath = "//div[@class='SurgicalSolutions-module_ailmentItemWrapper__Krx-u']")
	List<WebElement> surgeryList;

	public void surgery_click() throws InterruptedException {
		surgery.click();
		Thread.sleep(4000);
	}

	public void Scroll() throws Exception {
		
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		
	}

	public void surgeryList() throws IOException {
		ExcelOutputUtils.setCellData("Sheet2", 1, 2, "POPULAR SURGERIES");

		for (int i = 0; i < surgeryList.size(); i++) {
			String surData = surgeryList.get(i).getText();
			ExcelOutputUtils.setCellData("Sheet2", i + 2, 2, surData);
			// System.out.println(docName.get(i).getText());

		}
		
	}

}
