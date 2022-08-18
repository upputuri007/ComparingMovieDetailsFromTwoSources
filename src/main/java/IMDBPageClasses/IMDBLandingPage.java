package IMDBPageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClasses.PageBaseClass;

public class IMDBLandingPage extends PageBaseClass {
	WebDriverWait wait;
	
	public IMDBLandingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(how = How.XPATH,using = "//input[@placeholder='Search IMDb']")
	WebElement searchBoxLocator;
	
	@FindBy(how = How.ID, using = "iconContext-magnify")
	WebElement searchButtonLocator;
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void searchMovie(String movieName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchBoxLocator));
			searchBoxLocator.sendKeys(movieName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public SearchResultsPage clickSearchButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchButtonLocator));
			searchButtonLocator.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}
}
