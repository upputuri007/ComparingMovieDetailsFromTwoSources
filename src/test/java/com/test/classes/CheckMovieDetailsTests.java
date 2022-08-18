package com.test.classes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import BaseClasses.PageBaseClass;
import IMDBPageClasses.IMDBLandingPage;
import IMDBPageClasses.MovieDatailsPage;
import IMDBPageClasses.SearchResultsPage;
import TestUtilities.RetryFailedTests;
import Utilities.ReadPropertiesFile;
import Utilities.ReadResultsPropertiesFile;
import Utilities.WriteToPropertiesFile;
import WikipediaPageClasses.MovieArticlePage;
import WikipediaPageClasses.WikipediaLandingPage;

public class CheckMovieDetailsTests {
	public String IMDBReleaseDate;
	public String IMDBCountry;
	public String WikipediaReleaseDate;
	public String WikipediaCountry;

	IMDBLandingPage imdbLandingPage;
	SearchResultsPage searchResultsPage;
	MovieDatailsPage movieDatailsPage;
	WikipediaLandingPage wikipediaLandingPage;
	MovieArticlePage movieArticlePage;

	PageBaseClass pageBaseClass = new PageBaseClass();
	ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	WriteToPropertiesFile writeToPropertiesFile = new WriteToPropertiesFile();
	ReadResultsPropertiesFile readResultsPropertiesFile = new ReadResultsPropertiesFile();
	
	private static Logger log = Logger.getLogger(CheckMovieDetailsTests.class);

	@BeforeMethod
	public void initializeDriver() {
		log.info("Launching the Driver");
		pageBaseClass.invokeBrowser("Chrome");
	}

	@Test(retryAnalyzer = RetryFailedTests.class, priority = 0)
	public void getMovieReleaseDateFromIMDB() {
		log.info("Navigating to IMDB URL");
		imdbLandingPage = pageBaseClass.openIMDBApplication(readPropertiesFile.readWebsiteURl("IMDBurl"));
		
		log.info("Assertion on IMDB Landing Page with URL passed from property file");
		Assert.assertEquals(imdbLandingPage.getPageTitle(),readPropertiesFile.readIMDBLandingPageTitle("IMDBLandingPageTitle"));
		
		log.info("Searching with movie name passed from properties file");
		imdbLandingPage.searchMovie(readPropertiesFile.readIMDBMovieName("imdbMovieName"));
		
		log.info("Clicking on search button");
		searchResultsPage = imdbLandingPage.clickSearchButton();
		
		log.info("Assertion on search result page title");
		Assert.assertEquals(searchResultsPage.getPageTitle(),readPropertiesFile.readSearchedResultsPageTitle("searchedResultsPageTitle"));
		
		log.info("Click on expected movie name result");
		movieDatailsPage = searchResultsPage.clickOnMovieName(readPropertiesFile.readIMDBMovieName("imdbMovieName"));
		
		log.info("Scrolling the web page to find details");
		movieDatailsPage.scrollTheScreen();
		
		log.info("Extracting release date and country from the UI");
		IMDBReleaseDate = movieDatailsPage.getReleaseDate();
		IMDBCountry = movieDatailsPage.getCountryName();
		
		log.info("Storing release date and country in property file");
		writeToPropertiesFile.wrtie("IMDBReleaseDate", "IMDBCountry", IMDBReleaseDate, IMDBCountry);
	}

	@Test(retryAnalyzer = RetryFailedTests.class, priority = 1)
	public void getMovieReleaseDateFromWikipedia() {
		log.info("Navigate to wikipedia landing page with URL passed from properties files");
		wikipediaLandingPage = pageBaseClass.openWikiPediaApplication(readPropertiesFile.readWebsiteURl("WikipediaUrl"));
		
		log.info("Assertion on Wikipedia landing pagetitle");
		Assert.assertEquals(wikipediaLandingPage.getPageTitle(),readPropertiesFile.readWikiLandingPageTitle("WikiPediaLandingPageTitle"));
		
		log.info("Searching with movie name passed from property file");
		movieArticlePage = wikipediaLandingPage.searchMovieInWikipedia(readPropertiesFile.readIMDBMovieName("wikiMovieName"));
		
		log.info("Extracting release date and country from wikipedia");
		WikipediaReleaseDate = movieArticlePage.getReleaaseDateFromWiki();
		WikipediaCountry = movieArticlePage.getCountryName();
		
		log.info("Storing extracted release date and counntry in property file");
		writeToPropertiesFile.wrtie("WikipediaReleaseDate", "WikipediaCountry", WikipediaReleaseDate, WikipediaCountry);
	}

	@Test(retryAnalyzer = RetryFailedTests.class, priority = 2)
	public void assertExtractedDetails() {
		log.info("Assertion on country data extracted from two sources");
		Assert.assertEquals(IMDBCountry, WikipediaCountry);
		
		log.info("Assertion on release date data extracted from two sources");
		Assert.assertEquals(IMDBReleaseDate, WikipediaReleaseDate);
	}

	@AfterMethod
	public void quitDriver() {
		log.info("Clearing the driver instance");
		pageBaseClass.quitBrowser();
	}

}
