Feature: Weather forecast Testing 

Background: Open weather forecast application 
	Given The Weather Forecast application is launched 
	
	
Scenario Outline: Validates weather forecast for different cities 

	Then User enter the city name as "<city>" and clicks on enter 
	Then User will validates five day weather forecast is displayed 
	When User clicks on day "1" 
	Then Validate the three hourly forecast is "Displayed" for day "1" 
	Then User Validates the day "1" summary weather condition is same as the first three hour data 
	Then User Validates the day "1" summary wind speed and direction is same as the first three hour data 
	Then User Validates the day "1" maximum and minimum temperature summary is displayed correctly 
	Then User Validates the day "1" rainfall summary is the aggregate three hour data 
	When User clicks on day "1" 
	Then Validate the three hourly forecast is "Not Displayed" for day "1" 
	When User clicks on day "2" 
	Then Validate the three hourly forecast is "Displayed" for day "2" 
	Then User Validates the day "2" summary weather condition is same as the first three hour data 
	Then User Validates the day "2" summary wind speed and direction is same as the first three hour data 
	Then User Validates the day "2" maximum and minimum temperature summary is displayed correctly 
	Then User Validates the day "2" rainfall summary is the aggregate three hour data 
	When User clicks on day "2" 
	Then Validate the three hourly forecast is "Not Displayed" for day "2" 
	When User clicks on day "3" 
	Then Validate the three hourly forecast is "Displayed" for day "3" 
	Then User Validates the day "3" summary weather condition is same as the first three hour data 
	Then User Validates the day "3" summary wind speed and direction is same as the first three hour data 
	Then User Validates the day "3" maximum and minimum temperature summary is displayed correctly 
	Then User Validates the day "3" rainfall summary is the aggregate three hour data 
	When User clicks on day "3" 
	Then Validate the three hourly forecast is "Not Displayed" for day "3" 
	When User clicks on day "4" 
	Then Validate the three hourly forecast is "Displayed" for day "4" 
	Then User Validates the day "4" summary weather condition is same as the first three hour data 
	Then User Validates the day "4" summary wind speed and direction is same as the first three hour data 
	Then User Validates the day "4" maximum and minimum temperature summary is displayed correctly 
	Then User Validates the day "4" rainfall summary is the aggregate three hour data 
	When User clicks on day "4" 
	Then Validate the three hourly forecast is "Not Displayed" for day "4" 
	When User clicks on day "5" 
	Then Validate the three hourly forecast is "Displayed" for day "5" 
	Then User Validates the day "5" summary weather condition is same as the first three hour data 
	Then User Validates the day "5" summary wind speed and direction is same as the first three hour data 
	Then User Validates the day "5" maximum and minimum temperature summary is displayed correctly 
	Then User Validates the day "5" rainfall summary is the aggregate three hour data 
	When User clicks on day "5" 
	Then Validate the three hourly forecast is "Not Displayed" for day "5" 
	
	Examples: 
		| city  |
		| aberdeen  |
		| dundee    |
		| edinburgh |
		| glasgow   |
		| perth     |
		| stirling  |
