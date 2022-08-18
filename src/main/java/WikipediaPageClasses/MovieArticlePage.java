package WikipediaPageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClasses.PageBaseClass;

public class MovieArticlePage extends PageBaseClass{
	
	WebDriverWait wait;
	public MovieArticlePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(how = How.XPATH,using = "//*/th/div[text()='Release date']//parent::th/following-sibling::td/div")
	WebElement wikiReleaseDateLocator;
	
	@FindBy(how = How.XPATH,using = "//*/th[text()='Country']/following-sibling::td")
	WebElement wikiCountryLocator;
	
	public String getReleaaseDateFromWiki() {
		try {
			wait.until(ExpectedConditions.visibilityOf(wikiReleaseDateLocator));
			String releasaeDate = wikiReleaseDateLocator.getText();
			System.out.println(releasaeDate);
			return releasaeDate;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String getCountryName() {
		try {
			wait.until(ExpectedConditions.visibilityOf(wikiCountryLocator));
			String countryName = wikiCountryLocator.getText();
			System.out.println(countryName);
			return countryName;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
