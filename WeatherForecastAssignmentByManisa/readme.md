"WeatherForecastAssignmentByManisa" is an automation test project to test "http://localhost:3000/"

Folder Structure :
-------------------------------------

WeatherForecastAssignmentByManisa

	->src
	
		->WeatherForecastRunner package
				->WeatherForecastRunner.java- junit test runner which maintains the run attributes such as reports tags
				
				->WeatherForecastStep_Definitions.java - Step definition file for feature file
		->weatherforecastPageObjects Package
			->WeatherForecastObjects.java - POM model page objects contains all the functions	
			
			->WeatherForecastFeatureFile Package
					->WeatherForecastFeature.feature - feature file
			
			->weatherforecastdriver Package
					->chromedriver.exe - Chrome Driver
			
	->target - contains the html report of last run
	
Pre Conditions
-----------------------

1. To Execute this test automation pack the application in the below URL must be up and running in the execution machine.

http://localhost:3000/

How to run the tests
-----------------------
1. Download the project and extract it
2. Import the project into an IDE like Eclipse(Add all dependencies like Selenium & Cucumber jars)
3. Run the 'WeatherForecastRunner.java' file as a Junit Test 
4. Now the project build will start and will execute the test cases


Test Report
-----------------------
The Cucumber Test report will be present in the following location
	[ WeatherForecastAssignmentByManisa]\target\WeatherForecast-Report\index.html ]
