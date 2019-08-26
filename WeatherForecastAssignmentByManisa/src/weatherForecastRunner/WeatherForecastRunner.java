package weatherForecastRunner;

 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/WeatherForecastFeatureFile/",
		plugin = {"pretty",		
		"html:target/WeatherForecast-Report"}
		
		)



public class WeatherForecastRunner {

	
}





