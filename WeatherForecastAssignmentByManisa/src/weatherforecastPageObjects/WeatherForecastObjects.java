package weatherforecastPageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import weatherForecastRunner.WeatherForecastStep_Definitions;

public class WeatherForecastObjects {

	public static WebDriver driver;
	public static int totalNoOfRows;
	public static WebDriverWait wait ;
	
	
	
	@FindBy(how=How.ID, using="city")
	public static WebElement City;
	
	public static void city(String city)
	{
		driver=WeatherForecastStep_Definitions.driver;
		wait=new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, WeatherForecastObjects.class);
		wait.until(ExpectedConditions.elementToBeClickable(City));
		City.clear();
		City.sendKeys(city);
		City.sendKeys(Keys.ENTER);
		
	}
	
	public static void VerifyFiveDayData()
	{
		int TotalNoOfDayRows = driver.findElements(By.xpath("//div[@class='summary']")).size();
		Assert.assertTrue(TotalNoOfDayRows==5);
	}
	
	public static void checkThreehourWeatherForecastDetails(String Displayweather,String DayNumber)
	{
		String Xpath= "//span[@data-test='day-"+DayNumber+"']/../../following-sibling::div[@class='details']";
		
		if (Displayweather.toLowerCase().equals("displayed")) {
			
			Assert.assertTrue(driver.findElement(By.xpath(Xpath)).isDisplayed());
			
		} else {
			Assert.assertFalse(driver.findElement(By.xpath(Xpath)).isDisplayed());
		}
		
	}
	
	public static void CheckWeatherForecastConditionSummary(String DayNumber)
	{
		String Xpath = "//span[@data-test='day-"+DayNumber+"']/../../following-sibling::div[@class='details']/div[1]/span[2]//*[name()='svg']";
		String ConditionNumberOne = driver.findElement(By.xpath(Xpath)).getAttribute("aria-label");
		
		String Summary = "//span[@data-test='day-"+DayNumber+"']/../../span[2]//*[name()='svg']";
		
		String SummaryConditionOfWeatherForecast = driver.findElement(By.xpath(Summary)).getAttribute("aria-label");
		
		Assert.assertEquals(ConditionNumberOne, SummaryConditionOfWeatherForecast);
	}
	
	public static void checkWindspeedSummaryOfWeatherForecast(String DayNumber)
	{
		String SummaryWindXpathOfWeatherForecast = "//span[@data-test='speed-"+DayNumber+"']";
		String summarywindspeedOfWeatherForecast = driver.findElement(By.xpath(SummaryWindXpathOfWeatherForecast)).getText();
		
		String firstthreehourWindspeedxpath = "//span[@data-test='speed-"+DayNumber+"-1']";
		String firstthreehourWindspeed = driver.findElement(By.xpath(firstthreehourWindspeedxpath)).getText();
		Assert.assertEquals(summarywindspeedOfWeatherForecast, firstthreehourWindspeed);
		
		String DirSummaryXpathOfWeatherForecast = "//span[@data-test='direction-"+DayNumber+"']/*";
		String DirSummaryStyleOfWeatherForecast = driver.findElement(By.xpath(DirSummaryXpathOfWeatherForecast)).getAttribute("style");
		
		String firstthreehourDirxpath = "//span[@data-test='direction-"+DayNumber+"-1']/*";
		String firstthreehourDirVal = driver.findElement(By.xpath(firstthreehourDirxpath)).getAttribute("style");
		Assert.assertEquals(DirSummaryStyleOfWeatherForecast, firstthreehourDirVal);

	}
	
	public static void CheckMaximumMinimumTemperature(String DayNumber)
	{
		int MaxTempSummaryOfWeatherForecast = Integer.valueOf(driver.findElement(By.xpath("//span[@data-test='maximum-"+DayNumber+"']")).getText().replace("°", ""));
		int MinTempSummaryWeatherForecast = Integer.valueOf(driver.findElement(By.xpath("//span[@data-test='minimum-"+DayNumber+"']")).getText().replace("°", ""));
		
		
		totalNoOfRows = driver.findElements(By.xpath("//div[@class='detail']/span[3]/span[contains(@data-test,'maximum-"+DayNumber+"')]")).size();
		
		int CurrentMaximum;
		int MaximumInThreehours=0;
		
		int CurrentMinimum;
		int MinimumInThreehours=1000;
		
		System.out.println("Total 3 hour Data is :="+ totalNoOfRows);
		
		for(int i=1;i<totalNoOfRows+1;i++)
		{
			System.out.println("Loop is executing");
			CurrentMaximum = Integer.valueOf(driver.findElement(By.xpath("(//div[@class='detail']/span[3]/span[contains(@data-test,'maximum-"+DayNumber+"')])["+i+"]")).getText().replace("°", ""));
			System.out.println("Current Maximum is:"+CurrentMaximum);
			if (CurrentMaximum>MaximumInThreehours) {
				MaximumInThreehours = CurrentMaximum;
				System.out.println("Maximum of three hour is set as:"+CurrentMaximum);
			}
			
			CurrentMinimum = Integer.valueOf(driver.findElement(By.xpath("(//div[@class='detail']/span[3]/span[contains(@data-test,'minimum-"+DayNumber+"')])["+i+"]")).getText().replace("°", ""));
			if (CurrentMinimum<MinimumInThreehours) {
				MinimumInThreehours = CurrentMinimum;
			}
		}
		
		System.out.println("In three hours maximum temperature is:"+MaximumInThreehours);
		System.out.println("Summary of maximum temp is: "+MaxTempSummaryOfWeatherForecast);
		
		Assert.assertEquals(MaximumInThreehours, MaxTempSummaryOfWeatherForecast);
		
		System.out.println("In three hours minimum temperature is: "+MinimumInThreehours);
		System.out.println("Summary of minimum temp is:"+MinTempSummaryWeatherForecast);
		Assert.assertEquals(MinimumInThreehours, MinTempSummaryWeatherForecast);

	}
	
	public static void checkRainfallSummaryOfWeatherForecast(String DayNumber) throws IOException
	{
		String rainfallSummaryValOfWeatherForecast = driver.findElement(By.xpath("//span[@data-test='rainfall-"+DayNumber+"']")).getText();
		
		int InthreehourRanfalltotal=0;
		
		for(int i=1;i<totalNoOfRows+1;i++)
		{
			InthreehourRanfalltotal = InthreehourRanfalltotal + Integer.valueOf(driver.findElement(By.xpath("(//div[@class='detail']/span[5]/span[contains(@data-test,'rainfall-"+DayNumber+"')])["+i+"]")).getText().replace("mm", ""));
		}
		
		Assert.assertEquals(rainfallSummaryValOfWeatherForecast,InthreehourRanfalltotal+"mm");
		
		
	}
	
	
	
}
