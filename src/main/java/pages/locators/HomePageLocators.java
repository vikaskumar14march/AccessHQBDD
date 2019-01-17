package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='search-input-From']")
	public WebElement fromTextbox;
	
	@FindBy(how=How.XPATH,using=".//*[@id='search-input-To']")
	public WebElement toTextbox;
	
	@FindBy(how=How.XPATH,using=".//*[@id='search-button']")
	public WebElement goButton;
	
	
	
	@FindBy(how=How.XPATH,using=".//*[@id='price-max']")
	public WebElement searchList;
	
	@FindBy(how=How.XPATH,using=".//*[@id='search-submit']")
	public WebElement findMyNextCarButton;
}
