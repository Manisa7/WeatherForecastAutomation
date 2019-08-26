package weatherForecastRunner;



import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.util.annotation.ManagedAttribute;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import weatherforecastPageObjects.WeatherForecastObjects;

public class WeatherForecastStep_Definitions {
	public static WebDriver driver;
	public static WebDriverWait wait ;
	
	

@Before
public static void beforeMethod()
{
	System.setProperty("webdriver.chrome.driver", "src\\weatherforecastdriver\\chromedriver.exe");
	driver= new ChromeDriver();
}

@Given("^The Weather Forecast application is launched$")
public static void the_Weather_Forecast_application_is_launched() throws InterruptedException, IOException
{
	driver.get("http://localhost:3000/");
	driver.manage().window().maximize();
	
	
}


@Then("^User enter the city name as \"([^\"]*)\" and clicks on enter$")

public void User_enter_the_city_name_as_and_press_clickls_on_enter(String city) throws Throwable {
	
	WeatherForecastObjects.city(city);
}

@Then("^User will validates five day weather forecast is displayed$")


public void User_will_validates_five_day_weather_forecast_is_displayed() throws Throwable {

	WeatherForecastObjects.VerifyFiveDayData();
}

@When("^User clicks on day \"([^\"]*)\"$")

public void User_clicks_on_day(String DayNumberber) throws Throwable {
	
	driver.findElement(By.xpath("//span[@data-test='day-"+DayNumberber+"']")).click();
	Thread.sleep(600);
}

@Then("^Validate the three hourly forecast is \"([^\"]*)\" for day \"([^\"]*)\"$")

public void Validate_the_three_hourly_forecast_is(String Displayweather,String DayNumberber) throws Throwable {

	WeatherForecastObjects.checkThreehourWeatherForecastDetails(Displayweather, DayNumberber);
	Thread.sleep(600);
	
}

@Then("^User Validates the day \"([^\"]*)\" summary weather condition is same as the first three hour data$")
public void User_Validates_the_day_summary_weather_condition_is_same_as_the_first_three_hour_data(String DayNumberber) throws Throwable {
	
	WeatherForecastObjects.CheckWeatherForecastConditionSummary(DayNumberber);
	
}

@Then("^User Validates the day \"([^\"]*)\" summary wind speed and direction is same as the first three hour data$")
public void User_Validates_the_day_summary_wind_speed_and_direction_is_same_as_the_first_three_hour_data(String DayNumberber) throws Throwable {
   
	WeatherForecastObjects.checkWindspeedSummaryOfWeatherForecast(DayNumberber);
	
}

@Then("^User Validates the day \"([^\"]*)\" maximum and minimum temperature summary is displayed correctly$")
public void User_Validates_the_day_maximum_and_minimum_temperature_summary_is_displayed_correctly(String DayNumber) throws Throwable {
   
	WeatherForecastObjects.CheckMaximumMinimumTemperature(DayNumber);
	
	
}

@Then("^User Validates the day \"([^\"]*)\" rainfall summary is the aggregate three hour data$")
public void User_Validates_the_day_rainfall_summary_is_the_aggregate_three_hour_data(String DayNumber) throws Throwable {
   
	WeatherForecastObjects.checkRainfallSummaryOfWeatherForecast(DayNumber);
	
}
@After
public  void afterClass(Scenario ScenarioWeatherForecast){

	driver.quit();
	System.out.println(ScenarioWeatherForecast.getName()+" : "+ScenarioWeatherForecast.getStatus());
	
}


}
