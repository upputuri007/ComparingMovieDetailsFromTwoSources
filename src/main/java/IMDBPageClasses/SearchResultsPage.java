package IMDBPageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClasses.PageBaseClass;

public class SearchResultsPage extends PageBaseClass{
	WebDriverWait wait;
	public SearchResultsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	
	public MovieDatailsPage clickOnMovieName(String movieName) {
		try {
			driver.findElement(By.xpath("//*/a[contains(text(),'"+movieName+"')]")).click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return PageFactory.initElements(driver, MovieDatailsPage.class);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

}
