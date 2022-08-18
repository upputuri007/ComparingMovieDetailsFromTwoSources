package WikipediaPageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClasses.PageBaseClass;

public class WikipediaLandingPage extends PageBaseClass{
	
	WebDriverWait wait;
	public WikipediaLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(how = How.ID, using = "searchInput")
	WebElement searchBoxLocator;
	
	@FindBy(how = How.ID, using = "searchButton")
	WebElement clickSearchButton;
	
	
	public MovieArticlePage searchMovieInWikipedia(String movieName) {
		wait.until(ExpectedConditions.visibilityOf(searchBoxLocator));
		try {
			searchBoxLocator.sendKeys(movieName);
			clickSearchButton.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return PageFactory.initElements(driver, MovieArticlePage.class);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
