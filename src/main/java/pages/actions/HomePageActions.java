package pages.actions;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import org.testng.Assert;
import pages.locators.HomePageLocators;
import utils.SeleniumDriver;

public class HomePageActions {
	
	
	HomePageLocators HomePageLocators=null;
	JavascriptExecutor executor ;

	public  HomePageActions()
	{
		this.HomePageLocators= new HomePageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), HomePageLocators);
		executor = (JavascriptExecutor)SeleniumDriver.getDriver();
	}
	

	
	public void setFromStation(String fromStation)
	{
		try
		{
			HomePageLocators.fromTextbox.sendKeys(fromStation);
			Thread.sleep(3000);
			selectStattionWithText(fromStation);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void setToStation(String toStation)
	{
		try
		{
			HomePageLocators.toTextbox.sendKeys(toStation);
			Thread.sleep(3000);
			selectStattionWithText(toStation);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void clickGoButton()
	{
		HomePageLocators.goButton.click();
	}
	
	
	public void selectStattionWithText(String stationName) {
		try {
			WebElement autoOptions = SeleniumDriver.getDriver().findElement(By.id("suggestions-From"));
		
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("a"));
		
			for (WebElement option : optionsToSelect) {
				//System.out.println(option.getText());
				if (option.getText().contains(stationName)) {
					//System.out.println("Trying to select: " + stationName);
					option.click();
					break;
				}

			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void setFromAndToStation(String fromStation, String toStation) throws InterruptedException
	{
		
		HomePageLocators.fromTextbox.sendKeys(fromStation);
		Thread.sleep(3000);
		selectStattionWithText(fromStation);
		
		HomePageLocators.toTextbox.sendKeys(toStation);
		Thread.sleep(3000);
		selectStattionWithText(toStation);
		

	}
	
	public void verifyResultList() 
	{
		try {
			WebElement resultOptions = SeleniumDriver.getDriver().findElement(By.xpath("//div[@role='list']"));
			//wait.until(ExpectedConditions.visibilityOf(resultOptions));

			List<WebElement> optionToSelect = resultOptions.findElements(By.xpath("//div[@role='listitem']"));
			System.out.println("Options: " + optionToSelect.size());
			int size = optionToSelect.size();
			System.out.println("Number of options: " + size);
			
			
			if(size == 0)
			{
				Assert.fail("Trip options not provided");
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}
	
	
	
	
}
