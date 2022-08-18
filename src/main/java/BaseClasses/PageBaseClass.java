package BaseClasses;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import IMDBPageClasses.IMDBLandingPage;
import WikipediaPageClasses.WikipediaLandingPage;

public class PageBaseClass {
	public WebDriver driver;
	
	public void  invokeBrowser(String browserName) {
		try {
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("Mozila")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			driver = new SafariDriver();
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	public IMDBLandingPage openIMDBApplication(String websiteURL) {
		driver.get(websiteURL);
		return PageFactory.initElements(driver, IMDBLandingPage.class);
	}
	
	public WikipediaLandingPage openWikiPediaApplication(String websiteURL) {
		driver.get(websiteURL);
		return PageFactory.initElements(driver, WikipediaLandingPage.class);
		
	}
	
	public void tearDown() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
//	public String getPageTitle(WebDriver driver) {
//		this.driver = driver;
//		 return driver.getTitle();
//	}
	
	
	public void scrollTheWebPage(WebElement destLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", destLocator);
	}
	
}
