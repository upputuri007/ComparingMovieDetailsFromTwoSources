package IMDBPageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClasses.PageBaseClass;

public class MovieDatailsPage extends PageBaseClass{
	
	WebDriverWait wait;
	public MovieDatailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(how = How.XPATH, using = "//*[text()='Release date']/following-sibling::div/ul/li/a")
	WebElement imdbReleaseDateLocator;
	
	@FindBy(how = How.XPATH, using = "//*[text()='Country of origin']/following-sibling::div/ul/li/a")
	WebElement imdbCountryNameLocator;
	
	@FindBy(how = How.XPATH,using = "//*[text()='Details']")
	WebElement detailsLocator;
	
	public void scrollTheScreen() {
		try {
			wait.until(ExpectedConditions.visibilityOf(detailsLocator));
			scrollTheWebPage(detailsLocator);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public String getReleaseDate() {
		try {
			wait.until(ExpectedConditions.visibilityOf(imdbReleaseDateLocator));
			String releaseDate = imdbReleaseDateLocator.getText();
			System.out.println("Release Date: "+releaseDate);
			return releaseDate;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String getCountryName() {
		try {
			wait.until(ExpectedConditions.visibilityOf(imdbCountryNameLocator));
			String countryName = imdbCountryNameLocator.getText();
			System.out.println("Country: "+countryName);
			return countryName;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
